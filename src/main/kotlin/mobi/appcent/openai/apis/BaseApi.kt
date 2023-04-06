package mobi.appcent.openai.apis

import mobi.appcent.openai.infrastructure.ApiClient

/**
 * Created by erenalpaslan on 5.04.2023
 */
open class BaseApi {

    protected lateinit var apiClient: ApiClient

    fun initApiClient(client: ApiClient) {
        this.apiClient = client
    }
}