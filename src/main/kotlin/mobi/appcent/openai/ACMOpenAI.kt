/**
 * OpenAI API
 * APIs for sampling from and fine-tuning language models
 *
 * OpenAPI spec version: 1.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package mobi.appcent.openai

import mobi.appcent.openai.apis.*
import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class ACMOpenAI private constructor(
    private var baseUrl: String,
    private var organization: String? = null,
    private var apiKey: String? = null,
    private var logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE,
    client: OkHttpClient? = null
) {

    private var client: ApiClient

    private val completionApi: CompletionApi = CompletionApi()
    private val chatApi: ChatApi = ChatApi()
    private val editApi: EditApi = EditApi()
    private val embeddingApi: EmbeddingApi = EmbeddingApi()
    private val engineApi: EngineApi = EngineApi()
    private val fineTuneApi: FineTuneApi = FineTuneApi()
    private val imageApi: ImageApi = ImageApi()
    private val moderationApi: ModerationApi = ModerationApi()
    private val filesApi: FilesApi = FilesApi()

    init {
        checkNotNull(apiKey) {
            "Api Key cannot be null"
        }
        this.client = ApiClient(
            baseUrl = baseUrl,
            apiKey = apiKey,
            organization = organization,
            logLevel = logLevel,
            client = client,
        )
        bindApiClients()
    }

    private fun bindApiClients() {
        completionApi.initApiClient(client)
        chatApi.initApiClient(client)
        editApi.initApiClient(client)
        embeddingApi.initApiClient(client)
        engineApi.initApiClient(client)
        fineTuneApi.initApiClient(client)
        imageApi.initApiClient(client)
        moderationApi.initApiClient(client)
        filesApi.initApiClient(client)
    }

    class Builder {
        private var baseUrl: String = UrlConstant.BASE_URL
        private var organization: String? = null
        private var apiKey: String? = null
        private var client: OkHttpClient? = null
        private var logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE

        fun baseUrl(url: String) = apply { this.baseUrl = url }
        fun organization(organization: String) = apply { this.organization = organization }
        fun apiKey(apiKey: String) = apply { this.apiKey = apiKey }
        fun client(client: OkHttpClient) = apply { this.client = client }
        fun logLevel(logLevel: HttpLoggingInterceptor.Level) = apply { this.logLevel = logLevel }
        fun build(): ACMOpenAI = ACMOpenAI(baseUrl, organization, apiKey, logLevel, client)
    }

    fun chat() = chatApi
    fun completions() = completionApi
    fun edits() = editApi
    fun embeddings() = embeddingApi
    fun engines() = engineApi
    fun fineTunes() = fineTuneApi
    fun images() = imageApi
    fun moderations() = moderationApi
    fun files() = filesApi

}
