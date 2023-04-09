package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateEditRequest
import mobi.appcent.openai.models.CreateEditResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class EditApi: BaseApi() {

    /**
     * Creates a new edit for the provided input, instruction, and parameters.
     *
     * @param body
     * @return CreateEditResponse
     */
    fun createEdit(body: CreateEditRequest): CreateEditResponse {
        val localVariableBody: CreateEditRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.EDITS_URL
        )
        val response = apiClient.request<CreateEditResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateEditResponse
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}