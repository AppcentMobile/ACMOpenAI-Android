package mobi.appcent.openai.apis

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateCompletionRequest
import mobi.appcent.openai.models.CreateCompletionResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class CompletionApi: BaseApi() {

    /**
     * Creates a completion for the provided prompt and parameters
     *
     * @param body
     * @return CreateCompletionResponse
     */
    fun createCompletion(body: CreateCompletionRequest): Flow<CreateCompletionResponse?> {
        val localVariableBody: CreateCompletionRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.COMPLETION_URL
        )

        return if (localVariableBody.stream == true) {
            apiClient.collectEvent<CreateCompletionResponse>(
                localVariableConfig, localVariableBody
            )
        }else {
            flow<CreateCompletionResponse> {
                val response = apiClient.request<CreateCompletionResponse>(
                    localVariableConfig, localVariableBody
                )

                when (response.responseType) {
                    ResponseType.Success -> emit((response as Success<*>).data as CreateCompletionResponse)
                    ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
                    ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
                }
            }
        }
    }

}