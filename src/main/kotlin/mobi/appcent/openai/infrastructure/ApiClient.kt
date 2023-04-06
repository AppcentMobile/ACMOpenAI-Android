package mobi.appcent.openai.infrastructure

import mobi.appcent.openai.common.HeaderConstant
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

open class ApiClient constructor(
    val baseUrl: String,
    apiKey: String?,
    organization: String?,
    debugging: Boolean = false,
    var client: OkHttpClient? = null
) {

    init {
        if (client == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = if (debugging)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

            this.client = OkHttpClient.Builder()
                .addInterceptor(AuthorizationInterceptor(apiKey, organization))
                .addInterceptor(logging)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .build()
        }
    }

    companion object {
        @JvmStatic
        var defaultHeaders: Map<String, String> by ApplicationDelegates.setOnce(mapOf(
            HeaderConstant.CONTENT_TYPE to HeaderConstant.JSON_MEDIA_TYPE,
            HeaderConstant.ACCEPT to HeaderConstant.JSON_MEDIA_TYPE
        ))

        @JvmStatic
        val jsonHeaders: Map<String, String> = mapOf(
            HeaderConstant.CONTENT_TYPE to HeaderConstant.JSON_MEDIA_TYPE,
            HeaderConstant.ACCEPT to HeaderConstant.JSON_MEDIA_TYPE
        )
    }

    inline fun <reified T> requestBody(content: T, mediaType: String = HeaderConstant.JSON_MEDIA_TYPE): RequestBody =
            when {
                content is File -> RequestBody.create(mediaType.toMediaTypeOrNull(), content)

                mediaType == HeaderConstant.FORM_DATA_MEDIA_TYPE -> {
                    var builder = FormBody.Builder()
                    // content's type *must* be Map<String, Any>
                    @Suppress("UNCHECKED_CAST")
                    (content as Map<String, String>).forEach { key, value ->
                        builder = builder.add(key, value)
                    }
                    builder.build()
                }
                mediaType == HeaderConstant.JSON_MEDIA_TYPE -> Serializer.gson.toJson(content)
                    .toRequestBody(mediaType.toMediaTypeOrNull())

                mediaType == HeaderConstant.XML_MEDIA_TYPE -> TODO("xml not currently supported.")

                // TODO: this should be extended with other serializers
                else -> TODO("requestBody currently only supports JSON body and File body.")
            }

    inline fun <reified T> responseBody(body: ResponseBody?, mediaType: String = HeaderConstant.JSON_MEDIA_TYPE): T? {
        if (body == null) return null
        return when (mediaType) {
            HeaderConstant.JSON_MEDIA_TYPE -> Serializer.gson.fromJson(body.source().readUtf8(), T::class.java)
            else -> TODO()
        }
    }

    inline fun <reified T> request(requestConfig: RequestConfig, body: Any? = null): ApiInfrastructureResponse<T?> {
        val httpUrl = baseUrl.toHttpUrlOrNull() ?: throw IllegalStateException("baseUrl is invalid.")

        var urlBuilder = httpUrl.newBuilder()
                .addPathSegments(requestConfig.path.trimStart('/'))

        requestConfig.query.forEach { query ->
            query.value.forEach { queryValue ->
                urlBuilder = urlBuilder.addQueryParameter(query.key, queryValue)
            }
        }

        val url = urlBuilder.build()
        val headers = requestConfig.headers + defaultHeaders

        if ((headers[HeaderConstant.CONTENT_TYPE] ?: "") == "") {
            throw kotlin.IllegalStateException("Missing Content-Type header. This is required.")
        }

        if ((headers[HeaderConstant.ACCEPT] ?: "") == "") {
            throw kotlin.IllegalStateException("Missing Accept header. This is required.")
        }

        // TODO: support multiple contentType,accept options here.
        val contentType = (headers[HeaderConstant.CONTENT_TYPE] as String).substringBefore(";").toLowerCase()
        val accept = (headers[HeaderConstant.ACCEPT] as String).substringBefore(";").toLowerCase()

        var request: Request.Builder = when (requestConfig.method) {
            RequestMethod.DELETE -> Request.Builder().url(url).delete()
            RequestMethod.GET -> Request.Builder().url(url)
            RequestMethod.HEAD -> Request.Builder().url(url).head()
            RequestMethod.PATCH -> Request.Builder().url(url).patch(requestBody(body, contentType))
            RequestMethod.PUT -> Request.Builder().url(url).put(requestBody(body, contentType))
            RequestMethod.POST -> Request.Builder().url(url).post(requestBody(body, contentType))
            RequestMethod.OPTIONS -> Request.Builder().url(url).method("OPTIONS", null)
        }

        headers.forEach { header -> request = request.addHeader(header.key, header.value.toString()) }

        val realRequest = request.build()
        val response = client?.newCall(realRequest)?.execute()

        when {
            response?.isRedirect == true -> return Redirection(
                    response.code,
                    response.headers.toMultimap()
            )
            response?.isInformational == true -> return Informational(
                    response.message,
                    response.code,
                    response.headers.toMultimap()
            )
            response?.isSuccessful == true -> return Success(
                    responseBody(response.body, accept) as T?,
                    response.code,
                    response.headers.toMultimap()
            )
            response?.isClientError == true -> return ClientError(
                    response.body?.string(),
                    response.code,
                    response.headers.toMultimap()
            )
            else -> return ServerError(
                    null,
                    response?.body?.string(),
                    response?.code ?: 9999,
                    response?.headers?.toMultimap() ?: mapOf()
            )
        }
    }
}