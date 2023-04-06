package mobi.appcent.openai.infrastructure

import mobi.appcent.openai.common.HeaderConstant
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by erenalpaslan on 5.04.2023
 */
class AuthorizationInterceptor(
    private val apiKey: String? = null,
    private val organization: String? = null
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        if (!apiKey.isNullOrEmpty())
            builder.addHeader(HeaderConstant.AUTHORIZATION, "${HeaderConstant.BEARER}$apiKey")

        if (!organization.isNullOrEmpty())
            builder.addHeader(HeaderConstant.OPENAI_ORGANIZATION, organization)

        val newRequest = builder.build()
        return chain.proceed(newRequest)
    }
}