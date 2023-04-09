package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateModerationRequest
import mobi.appcent.openai.models.CreateModerationResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class ModerationApi: BaseApi() {

    /**
     * Classifies if text violates OpenAI&#x27;s Content Policy
     *
     * @param body
     * @return CreateModerationResponse
     */
    fun createModeration(body: CreateModerationRequest): CreateModerationResponse {
        val localVariableBody: CreateModerationRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.MODERATIONS_URL
        )
        val response = apiClient.request<CreateModerationResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateModerationResponse
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}