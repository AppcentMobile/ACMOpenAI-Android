package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.Engine
import mobi.appcent.openai.models.ListEnginesResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class EngineApi: BaseApi() {

    /**
     * Lists the currently available (non-finetuned) models, and provides basic information about each one such as the owner and availability.
     *
     * @return ListEnginesResponse
     */
    fun listEngines(): ListEnginesResponse {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            UrlConstant.ENGINES_URL
        )
        val response = apiClient.request<ListEnginesResponse>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ListEnginesResponse
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Retrieves a model instance, providing basic information about it such as the owner and availability.
     *
     * @param engineId The ID of the engine to use for this request
     * @return Engine
     */
    fun retrieveEngine(engineId: String): Engine {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.ENGINES_URL}/" + engineId
        )
        val response = apiClient.request<Engine>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Engine
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}