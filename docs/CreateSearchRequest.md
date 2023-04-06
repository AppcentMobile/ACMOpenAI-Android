# CreateSearchRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**query** | [**kotlin.String**](.md) | Query to search against the documents. | 
**documents** | [**kotlin.Array&lt;kotlin.String&gt;**](.md) | Up to 200 documents to search over, provided as a list of strings.  The maximum document length (in tokens) is 2034 minus the number of tokens in the query.  You should specify either &#x60;documents&#x60; or a &#x60;file&#x60;, but not both.  |  [optional]
**file** | [**kotlin.String**](.md) | The ID of an uploaded file that contains documents to search over.  You should specify either &#x60;documents&#x60; or a &#x60;file&#x60;, but not both.  |  [optional]
**maxRerank** | [**kotlin.Int**](.md) | The maximum number of documents to be re-ranked and returned by search.  This flag only takes effect when &#x60;file&#x60; is set.  |  [optional]
**returnMetadata** | [**kotlin.Boolean**](.md) | A special boolean flag for showing metadata. If set to &#x60;true&#x60;, each document entry in the returned JSON will contain a \&quot;metadata\&quot; field.  This flag only takes effect when &#x60;file&#x60; is set.  |  [optional]
**user** | [**kotlin.String**](.md) | A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).  |  [optional]
