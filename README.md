# io.swagger.client - Kotlin client library for OpenAI API

## Requires

* Kotlin 1.4.30
* Gradle 5.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in Swagger definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.openai.com/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OpenAIApi* | [**cancelFineTune**](docs/OpenAIApi.md#cancelfinetune) | **POST** /fine-tunes/{fine_tune_id}/cancel | Immediately cancel a fine-tune job. 
*OpenAIApi* | [**createAnswer**](docs/OpenAIApi.md#createanswer) | **POST** /answers | Answers the specified question using the provided documents and examples.  The endpoint first [searches](/docs/api-reference/searches) over provided documents or files to find relevant context. The relevant context is combined with the provided examples and question to create the prompt for [completion](/docs/api-reference/completions). 
*OpenAIApi* | [**createChatCompletion**](docs/OpenAIApi.md#createchatcompletion) | **POST** /chat/completions | Creates a completion for the chat message
*OpenAIApi* | [**createClassification**](docs/OpenAIApi.md#createclassification) | **POST** /classifications | Classifies the specified `query` using provided examples.  The endpoint first [searches](/docs/api-reference/searches) over the labeled examples to select the ones most relevant for the particular query. Then, the relevant examples are combined with the query to construct a prompt to produce the final label via the [completions](/docs/api-reference/completions) endpoint.  Labeled examples can be provided via an uploaded `file`, or explicitly listed in the request using the `examples` parameter for quick tests and small scale use cases. 
*OpenAIApi* | [**createCompletion**](docs/OpenAIApi.md#createcompletion) | **POST** /completions | Creates a completion for the provided prompt and parameters
*OpenAIApi* | [**createEdit**](docs/OpenAIApi.md#createedit) | **POST** /edits | Creates a new edit for the provided input, instruction, and parameters.
*OpenAIApi* | [**createEmbedding**](docs/OpenAIApi.md#createembedding) | **POST** /embeddings | Creates an embedding vector representing the input text.
*OpenAIApi* | [**createFile**](docs/OpenAIApi.md#createfile) | **POST** /files | Upload a file that contains document(s) to be used across various endpoints/features. Currently, the size of all the files uploaded by one organization can be up to 1 GB. Please contact us if you need to increase the storage limit. 
*OpenAIApi* | [**createFineTune**](docs/OpenAIApi.md#createfinetune) | **POST** /fine-tunes | Creates a job that fine-tunes a specified model from a given dataset.  Response includes details of the enqueued job including job status and the name of the fine-tuned models once complete.  [Learn more about Fine-tuning](/docs/guides/fine-tuning) 
*OpenAIApi* | [**createImage**](docs/OpenAIApi.md#createimage) | **POST** /images/generations | Creates an image given a prompt.
*OpenAIApi* | [**createImageEdit**](docs/OpenAIApi.md#createimageedit) | **POST** /images/edits | Creates an edited or extended image given an original image and a prompt.
*OpenAIApi* | [**createImageVariation**](docs/OpenAIApi.md#createimagevariation) | **POST** /images/variations | Creates a variation of a given image.
*OpenAIApi* | [**createModeration**](docs/OpenAIApi.md#createmoderation) | **POST** /moderations | Classifies if text violates OpenAI's Content Policy
*OpenAIApi* | [**createSearch**](docs/OpenAIApi.md#createsearch) | **POST** /engines/{engine_id}/search | The search endpoint computes similarity scores between provided query and documents. Documents can be passed directly to the API if there are no more than 200 of them.  To go beyond the 200 document limit, documents can be processed offline and then used for efficient retrieval at query time. When `file` is set, the search endpoint searches over all the documents in the given file and returns up to the `max_rerank` number of documents. These documents will be returned along with their search scores.  The similarity score is a positive score that usually ranges from 0 to 300 (but can sometimes go higher), where a score above 200 usually means the document is semantically similar to the query. 
*OpenAIApi* | [**createTranscription**](docs/OpenAIApi.md#createtranscription) | **POST** /audio/transcriptions | Transcribes audio into the input language.
*OpenAIApi* | [**createTranslation**](docs/OpenAIApi.md#createtranslation) | **POST** /audio/translations | Translates audio into into English.
*OpenAIApi* | [**deleteFile**](docs/OpenAIApi.md#deletefile) | **DELETE** /files/{file_id} | Delete a file.
*OpenAIApi* | [**deleteModel**](docs/OpenAIApi.md#deletemodel) | **DELETE** /models/{model} | Delete a fine-tuned model. You must have the Owner role in your organization.
*OpenAIApi* | [**downloadFile**](docs/OpenAIApi.md#downloadfile) | **GET** /files/{file_id}/content | Returns the contents of the specified file
*OpenAIApi* | [**listEngines**](docs/OpenAIApi.md#listengines) | **GET** /engines | Lists the currently available (non-finetuned) models, and provides basic information about each one such as the owner and availability.
*OpenAIApi* | [**listFiles**](docs/OpenAIApi.md#listfiles) | **GET** /files | Returns a list of files that belong to the user's organization.
*OpenAIApi* | [**listFineTuneEvents**](docs/OpenAIApi.md#listfinetuneevents) | **GET** /fine-tunes/{fine_tune_id}/events | Get fine-grained status updates for a fine-tune job. 
*OpenAIApi* | [**listFineTunes**](docs/OpenAIApi.md#listfinetunes) | **GET** /fine-tunes | List your organization's fine-tuning jobs 
*OpenAIApi* | [**listModels**](docs/OpenAIApi.md#listmodels) | **GET** /models | Lists the currently available models, and provides basic information about each one such as the owner and availability.
*OpenAIApi* | [**retrieveEngine**](docs/OpenAIApi.md#retrieveengine) | **GET** /engines/{engine_id} | Retrieves a model instance, providing basic information about it such as the owner and availability.
*OpenAIApi* | [**retrieveFile**](docs/OpenAIApi.md#retrievefile) | **GET** /files/{file_id} | Returns information about a specific file.
*OpenAIApi* | [**retrieveFineTune**](docs/OpenAIApi.md#retrievefinetune) | **GET** /fine-tunes/{fine_tune_id} | Gets info about the fine-tune job.  [Learn more about Fine-tuning](/docs/guides/fine-tuning) 
*OpenAIApi* | [**retrieveModel**](docs/OpenAIApi.md#retrievemodel) | **GET** /models/{model} | Retrieves a model instance, providing basic information about the model such as the owner and permissioning.

<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.swagger.client.models.ChatCompletionRequestMessage](docs/ChatCompletionRequestMessage.md)
 - [io.swagger.client.models.ChatCompletionResponseMessage](docs/ChatCompletionResponseMessage.md)
 - [io.swagger.client.models.CreateAnswerRequest](docs/CreateAnswerRequest.md)
 - [io.swagger.client.models.CreateAnswerResponse](docs/CreateAnswerResponse.md)
 - [io.swagger.client.models.CreateAnswerResponseSelectedDocuments](docs/CreateAnswerResponseSelectedDocuments.md)
 - [io.swagger.client.models.CreateChatCompletionRequest](docs/CreateChatCompletionRequest.md)
 - [io.swagger.client.models.CreateChatCompletionResponse](docs/CreateChatCompletionResponse.md)
 - [io.swagger.client.models.CreateChatCompletionResponseChoices](docs/CreateChatCompletionResponseChoices.md)
 - [io.swagger.client.models.CreateClassificationRequest](docs/CreateClassificationRequest.md)
 - [io.swagger.client.models.CreateClassificationResponse](docs/CreateClassificationResponse.md)
 - [io.swagger.client.models.CreateClassificationResponseSelectedExamples](docs/CreateClassificationResponseSelectedExamples.md)
 - [io.swagger.client.models.CreateCompletionRequest](docs/CreateCompletionRequest.md)
 - [io.swagger.client.models.CreateCompletionResponse](docs/CreateCompletionResponse.md)
 - [io.swagger.client.models.CreateCompletionResponseChoices](docs/CreateCompletionResponseChoices.md)
 - [io.swagger.client.models.CreateCompletionResponseLogprobs](docs/CreateCompletionResponseLogprobs.md)
 - [io.swagger.client.models.CreateCompletionResponseUsage](docs/CreateCompletionResponseUsage.md)
 - [io.swagger.client.models.CreateEditRequest](docs/CreateEditRequest.md)
 - [io.swagger.client.models.CreateEditResponse](docs/CreateEditResponse.md)
 - [io.swagger.client.models.CreateEmbeddingRequest](docs/CreateEmbeddingRequest.md)
 - [io.swagger.client.models.CreateEmbeddingResponse](docs/CreateEmbeddingResponse.md)
 - [io.swagger.client.models.CreateEmbeddingResponseData](docs/CreateEmbeddingResponseData.md)
 - [io.swagger.client.models.CreateEmbeddingResponseUsage](docs/CreateEmbeddingResponseUsage.md)
 - [io.swagger.client.models.CreateFileRequest](docs/CreateFileRequest.md)
 - [io.swagger.client.models.CreateFineTuneRequest](docs/CreateFineTuneRequest.md)
 - [io.swagger.client.models.CreateImageEditRequest](docs/CreateImageEditRequest.md)
 - [io.swagger.client.models.CreateImageRequest](docs/CreateImageRequest.md)
 - [io.swagger.client.models.CreateImageVariationRequest](docs/CreateImageVariationRequest.md)
 - [io.swagger.client.models.CreateModerationRequest](docs/CreateModerationRequest.md)
 - [io.swagger.client.models.CreateModerationResponse](docs/CreateModerationResponse.md)
 - [io.swagger.client.models.CreateModerationResponseCategories](docs/CreateModerationResponseCategories.md)
 - [io.swagger.client.models.CreateModerationResponseCategoryScores](docs/CreateModerationResponseCategoryScores.md)
 - [io.swagger.client.models.CreateModerationResponseResults](docs/CreateModerationResponseResults.md)
 - [io.swagger.client.models.CreateSearchRequest](docs/CreateSearchRequest.md)
 - [io.swagger.client.models.CreateSearchResponse](docs/CreateSearchResponse.md)
 - [io.swagger.client.models.CreateSearchResponseData](docs/CreateSearchResponseData.md)
 - [io.swagger.client.models.CreateTranscriptionRequest](docs/CreateTranscriptionRequest.md)
 - [io.swagger.client.models.CreateTranscriptionResponse](docs/CreateTranscriptionResponse.md)
 - [io.swagger.client.models.CreateTranslationRequest](docs/CreateTranslationRequest.md)
 - [io.swagger.client.models.CreateTranslationResponse](docs/CreateTranslationResponse.md)
 - [io.swagger.client.models.DeleteFileResponse](docs/DeleteFileResponse.md)
 - [io.swagger.client.models.DeleteModelResponse](docs/DeleteModelResponse.md)
 - [io.swagger.client.models.Engine](docs/Engine.md)
 - [io.swagger.client.models.FineTune](docs/FineTune.md)
 - [io.swagger.client.models.FineTuneEvent](docs/FineTuneEvent.md)
 - [io.swagger.client.models.ImagesResponse](docs/ImagesResponse.md)
 - [io.swagger.client.models.ImagesResponseData](docs/ImagesResponseData.md)
 - [io.swagger.client.models.ListEnginesResponse](docs/ListEnginesResponse.md)
 - [io.swagger.client.models.ListFilesResponse](docs/ListFilesResponse.md)
 - [io.swagger.client.models.ListFineTuneEventsResponse](docs/ListFineTuneEventsResponse.md)
 - [io.swagger.client.models.ListFineTunesResponse](docs/ListFineTunesResponse.md)
 - [io.swagger.client.models.ListModelsResponse](docs/ListModelsResponse.md)
 - [io.swagger.client.models.Model](docs/Model.md)
 - [io.swagger.client.models.OneOfCreateAnswerRequestStop](docs/OneOfCreateAnswerRequestStop.md)
 - [io.swagger.client.models.OneOfCreateChatCompletionRequestStop](docs/OneOfCreateChatCompletionRequestStop.md)
 - [io.swagger.client.models.OneOfCreateCompletionRequestPrompt](docs/OneOfCreateCompletionRequestPrompt.md)
 - [io.swagger.client.models.OneOfCreateCompletionRequestStop](docs/OneOfCreateCompletionRequestStop.md)
 - [io.swagger.client.models.OneOfCreateEmbeddingRequestInput](docs/OneOfCreateEmbeddingRequestInput.md)
 - [io.swagger.client.models.OneOfCreateModerationRequestInput](docs/OneOfCreateModerationRequestInput.md)
 - [io.swagger.client.models.OpenAIFile](docs/OpenAIFile.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
