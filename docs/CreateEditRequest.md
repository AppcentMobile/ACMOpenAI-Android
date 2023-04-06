# CreateEditRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**model** | [**kotlin.String**](.md) | ID of the model to use. You can use the &#x60;text-davinci-edit-001&#x60; or &#x60;code-davinci-edit-001&#x60; model with this endpoint. | 
**input** | [**kotlin.String**](.md) | The input text to use as a starting point for the edit. |  [optional]
**instruction** | [**kotlin.String**](.md) | The instruction that tells the model how to edit the prompt. | 
**n** | [**kotlin.Int**](.md) | How many edits to generate for the input and instruction. |  [optional]
**temperature** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.  We generally recommend altering this or &#x60;top_p&#x60; but not both.  |  [optional]
**topP** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.  We generally recommend altering this or &#x60;temperature&#x60; but not both.  |  [optional]
