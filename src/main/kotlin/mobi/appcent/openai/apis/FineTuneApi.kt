package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.*

/**
 * Created by erenalpaslan on 5.04.2023
 */
class FineTuneApi: BaseApi() {

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.  Response includes details of the enqueued job including job status and the name of the fine-tuned models once complete.  [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     *
     * @param body
     * @return FineTune
     */
    fun createFineTune(body: CreateFineTuneRequest): FineTune {
        val localVariableBody: Any? = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.FINE_TUNES_URL
        )
        val response = apiClient.request<FineTune>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as FineTune
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * List your organization&#x27;s fine-tuning jobs
     *
     * @return ListFineTunesResponse
     */
    fun listFineTunes(): ListFineTunesResponse {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/fine-tunes"
        )
        val response = apiClient.request<ListFineTunesResponse>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ListFineTunesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Gets info about the fine-tune job.  [Learn more about Fine-tuning](/docs/guides/fine-tuning)
     *
     * @param fineTuneId The ID of the fine-tune job
     * @return FineTune
     */
    fun retrieveFineTune(fineTuneId: String): FineTune {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.FINE_TUNES_URL}/"+fineTuneId
        )
        val response = apiClient.request<FineTune>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as FineTune
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Immediately cancel a fine-tune job.
     *
     * @param fineTuneId The ID of the fine-tune job to cancel
     * @return FineTune
     */
    fun cancelFineTune(fineTuneId: String): FineTune {

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "${UrlConstant.FINE_TUNES_URL}/"+fineTuneId+"/cancel"
        )
        val response = apiClient.request<FineTune>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as FineTune
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Get fine-grained status updates for a fine-tune job.
     *
     * @param fineTuneId The ID of the fine-tune job to get events for.
     * @param stream Whether to stream events for the fine-tune job. If set to true, events will be sent as data-only [server-sent events](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format) as they become available. The stream will terminate with a &#x60;data: [DONE]&#x60; message when the job is finished (succeeded, cancelled, or failed).  If set to false, only events generated so far will be returned.  (optional, default to false)
     * @return ListFineTuneEventsResponse
     */
    fun listFineTuneEvents(fineTuneId: String, stream: Boolean? = null): ListFineTuneEventsResponse {
        val localVariableQuery: MultiValueMap = mapOf("stream" to listOf("$stream"))
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.FINE_TUNES_URL}/"+fineTuneId+"/events"
        )
        val response = apiClient.request<ListFineTuneEventsResponse>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ListFineTuneEventsResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Retrieves a model instance, providing basic information about the model such as the owner and permissioning.
     *
     * @param model The ID of the model to use for this request
     * @return Model
     */
    fun retrieveModel(model: String): Model {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.MODELS_URL}/"+model
        )
        val response = apiClient.request<Model>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Model
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}