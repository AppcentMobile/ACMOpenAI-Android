package mobi.appcent.openai.apis

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateChatCompletionRequest
import mobi.appcent.openai.models.CreateChatCompletionResponse
import mobi.appcent.openai.models.CreateChatCompletionStreamResponse
import mobi.appcent.openai.models.CreateCompletionResponse
import mobi.appcent.openai.models.mapper.CreateChatCompletionStreamResponseMapper

/**
 * Created by erenalpaslan on 5.04.2023
 */
class ChatApi : BaseApi() {

    /**
     * Creates a completion for the chat message
     *
     * @param body
     * @return CreateChatCompletionResponse
     */
    fun createChatCompletion(body: CreateChatCompletionRequest): Flow<CreateChatCompletionResponse?> {
        val localVariableBody: CreateChatCompletionRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.CHAT_COMPLETION_URL
        )

        return if (localVariableBody.stream == true) {
            apiClient.collectEvent<CreateChatCompletionStreamResponse>(
                localVariableConfig, localVariableBody
            ).map { response ->
                return@map CreateChatCompletionStreamResponseMapper.transform(response)
            }
        }else {
            val response = apiClient.request<CreateChatCompletionResponse>(
                localVariableConfig,
                localVariableBody
            )
            flow {
                when (response.responseType) {
                    ResponseType.Success -> emit((response as Success<*>).data as CreateChatCompletionResponse)
                    ResponseType.ClientError -> throw ClientException(
                        (response as ClientError<*>).body as? String ?: "Client error"
                    )

                    ResponseType.ServerError -> throw ServerException(
                        (response as ServerError<*>).message ?: "Server error"
                    )
                }
            }
        }
    }

}