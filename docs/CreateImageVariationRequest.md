# CreateImageVariationRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**image** | [**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md) | The image to use as the basis for the variation(s). Must be a valid PNG file, less than 4MB, and square. | 
**n** | [**kotlin.Int**](.md) | The number of images to generate. Must be between 1 and 10. |  [optional]
**size** | [**inline**](#SizeEnum) | The size of the generated images. Must be one of &#x60;256x256&#x60;, &#x60;512x512&#x60;, or &#x60;1024x1024&#x60;. |  [optional]
**responseFormat** | [**inline**](#ResponseFormatEnum) | The format in which the generated images are returned. Must be one of &#x60;url&#x60; or &#x60;b64_json&#x60;. |  [optional]
**user** | [**kotlin.String**](.md) | A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).  |  [optional]

<a name="SizeEnum"></a>
## Enum: size
Name | Value
---- | -----
size | 256x256, 512x512, 1024x1024

<a name="ResponseFormatEnum"></a>
## Enum: response_format
Name | Value
---- | -----
responseFormat | url, b64_json
