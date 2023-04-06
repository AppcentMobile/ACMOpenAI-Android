package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateTranscriptionResponse
import mobi.appcent.openai.models.CreateTranslationResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class AudioApi: BaseApi() {

    /**
     * Transcribes audio into the input language.
     *
     * @param file
     * @param model
     * @param prompt
     * @param responseFormat
     * @param temperature
     * @param language
     * @return CreateTranscriptionResponse
     */
    fun createTranscription(file: List<Byte>, model: String, prompt: String, responseFormat: String, temperature: java.math.BigDecimal, language: String): CreateTranscriptionResponse {
        val localVariableBody: kotlin.Any? = mapOf(
            "file" to "$file",
            "model" to model,
            "prompt" to prompt,
            "response_format" to responseFormat,
            "temperature" to "$temperature",
            "language" to language
        )

        val localVariableHeaders: Map<String, String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "${UrlConstant.AUDIO_URL}/transcriptions", headers = localVariableHeaders
        )
        val response = apiClient.request<CreateTranscriptionResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateTranscriptionResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Translates audio into English.
     *
     * @param file
     * @param model
     * @param prompt
     * @param responseFormat
     * @param temperature
     * @return CreateTranslationResponse
     */
    fun createTranslation(file: List<Byte>, model: String, prompt: String, responseFormat: String, temperature: java.math.BigDecimal): CreateTranslationResponse {
        val localVariableBody: Any? = mapOf(
            "file" to "$file",
            "model" to model,
            "prompt" to prompt,
            "response_format" to responseFormat,
            "temperature" to "$temperature"
        )

        val localVariableHeaders: Map<String, String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "${UrlConstant.AUDIO_URL}/translations", headers = localVariableHeaders
        )
        val response = apiClient.request<CreateTranslationResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateTranslationResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }


}