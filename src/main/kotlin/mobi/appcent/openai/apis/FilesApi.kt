package mobi.appcent.openai.apis

import mobi.appcent.openai.common.UrlConstant
import mobi.appcent.openai.infrastructure.*
import mobi.appcent.openai.models.DeleteFileResponse
import mobi.appcent.openai.models.ListFilesResponse
import mobi.appcent.openai.models.OpenAIFile

/**
 * Created by erenalpaslan on 6.04.2023
 */
class FilesApi: BaseApi() {

    /**
     * Returns a list of files that belong to the user&#x27;s organization.
     *
     * @return ListFilesResponse
     */
    fun listFiles(): ListFilesResponse {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            UrlConstant.FILES_URL
        )
        val response = apiClient.request<ListFilesResponse>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ListFilesResponse
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Upload a file that contains document(s) to be used across various endpoints/features. Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please contact us if you need to increase the storage limit.
     *
     * @param file
     * @param purpose
     * @return OpenAIFile
     */
    fun createFile(file: Array<Byte>, purpose: String): OpenAIFile {
        val localVariableBody: Any? = mapOf(
            "file" to "$file",
            "purpose" to purpose
        )

        val localVariableHeaders: Map<String, String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
            method = RequestMethod.POST,
            path = UrlConstant.FILES_URL,
            headers = localVariableHeaders
        )
        val response = apiClient.request<OpenAIFile>(
            localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as OpenAIFile
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Delete a file.
     *
     * @param fileId The ID of the file to use for this request
     * @return DeleteFileResponse
     */
    fun deleteFile(fileId: String): DeleteFileResponse {

        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/files/{file_id}".replace("{" + "file_id" + "}", "$fileId")
        )
        val response = apiClient.request<DeleteFileResponse>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as DeleteFileResponse
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Returns information about a specific file.
     *
     * @param fileId The ID of the file to use for this request
     * @return OpenAIFile
     */
    fun retrieveFile(fileId: String): OpenAIFile {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.FILES_URL}/"+fileId
        )
        val response = apiClient.request<OpenAIFile>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as OpenAIFile
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
     * Returns the contents of the specified file
     *
     * @param fileId The ID of the file to use for this request
     * @return kotlin.String
     */
    fun downloadFile(fileId: String): String {

        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "${UrlConstant.FILES_URL}/"+fileId+"/content"
        )
        val response = apiClient.request<String>(
            localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as kotlin.String
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }



}