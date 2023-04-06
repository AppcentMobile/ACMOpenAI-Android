package mobi.appcent.openai.apis

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
    fun createCompletion(body: CreateCompletionRequest): CreateCompletionResponse {
        val localVariableBody: CreateCompletionRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.COMPLETION_URL
        )
        val response = apiClient.request<CreateCompletionResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateCompletionResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}