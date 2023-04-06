package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateImageRequest
import mobi.appcent.openai.models.ImagesResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class ImageApi: BaseApi() {

    /**
     * Creates an image given a prompt.
     *
     * @param body
     * @return ImagesResponse
     */
    fun createImage(body: CreateImageRequest): ImagesResponse {
        val localVariableBody: kotlin.Any? = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "${UrlConstant.IMAGES_URL}/generations"
        )
        val response = apiClient.request<ImagesResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ImagesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Creates an edited or extended image given an original image and a prompt.
     *
     * @param image
     * @param mask
     * @param prompt
     * @param n
     * @param size
     * @param responseFormat
     * @param user
     * @return ImagesResponse
     */
    fun createImageEdit(image: List<Byte>, mask: List<Byte>, prompt: String, n: Int, size: String, responseFormat: String, user: String): ImagesResponse {
        val localVariableBody: Any? = mapOf(
            "image" to "$image",
            "mask" to "$mask",
            "prompt" to prompt,
            "n" to "$n",
            "size" to size,
            "response_format" to responseFormat,
            "user" to user
        )

        val localVariableHeaders: Map<String, String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
            method = RequestMethod.POST,
            path = "${UrlConstant.IMAGES_URL}/edits",
            headers = localVariableHeaders
        )
        val response = apiClient.request<ImagesResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ImagesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Creates a variation of a given image.
     *
     * @param image
     * @param n
     * @param size
     * @param responseFormat
     * @param user
     * @return ImagesResponse
     */
    fun createImageVariation(image: List<Byte>, n: Int, size: String, responseFormat: String, user: String): ImagesResponse {
        val localVariableBody: Any? = mapOf(
            "image" to "$image",
            "n" to "$n",
            "size" to size,
            "response_format" to responseFormat,
            "user" to user
        )

        val localVariableHeaders: Map<String, String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "${UrlConstant.IMAGES_URL}/variations", headers = localVariableHeaders
        )
        val response = apiClient.request<ImagesResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ImagesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}