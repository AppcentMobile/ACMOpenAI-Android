package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateChatCompletionRequest
import mobi.appcent.openai.models.CreateChatCompletionResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class ChatApi: BaseApi() {

    /**
     * Creates a completion for the chat message
     *
     * @param body
     * @return CreateChatCompletionResponse
     */
    fun createChatCompletion(body: CreateChatCompletionRequest): CreateChatCompletionResponse {
        val localVariableBody: CreateChatCompletionRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.CHAT_COMPLETION_URL
        )
        val response = apiClient.request<CreateChatCompletionResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateChatCompletionResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}