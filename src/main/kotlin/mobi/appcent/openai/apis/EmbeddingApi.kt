package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.CreateEmbeddingRequest
import mobi.appcent.openai.models.CreateEmbeddingResponse

/**
 * Created by erenalpaslan on 5.04.2023
 */
class EmbeddingApi: BaseApi() {

    /**
     * Creates an embedding vector representing the input text.
     *
     * @param body
     * @return CreateEmbeddingResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun createEmbedding(body: CreateEmbeddingRequest): CreateEmbeddingResponse {
        val localVariableBody: CreateEmbeddingRequest = body

        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            UrlConstant.EMBEDDINGS_URL
        )
        val response = apiClient.request<CreateEmbeddingResponse>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as CreateEmbeddingResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}