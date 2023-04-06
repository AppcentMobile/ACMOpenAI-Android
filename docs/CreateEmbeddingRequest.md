# CreateEmbeddingRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**model** | [**kotlin.String**](.md) | ID of the model to use. You can use the [List models](/docs/api-reference/models/list) API to see all of your available models, or see our [Model overview](/docs/models/overview) for descriptions of them. | 
**input** | [**OneOfCreateEmbeddingRequestInput**](OneOfCreateEmbeddingRequestInput.md) | Input text to get embeddings for, encoded as a string or array of tokens. To get embeddings for multiple inputs in a single request, pass an array of strings or array of token arrays. Each input must not exceed 8192 tokens in length.  | 
**user** | [**kotlin.String**](.md) | A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).  |  [optional]
