# CreateTranslationRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file** | [**kotlin.Array&lt;kotlin.Byte&gt;**](kotlin.Array&lt;kotlin.Byte&gt;.md) | The audio file to translate, in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or webm.  | 
**model** | [**kotlin.String**](.md) | ID of the model to use. Only &#x60;whisper-1&#x60; is currently available.  | 
**prompt** | [**kotlin.String**](.md) | An optional text to guide the model&#x27;s style or continue a previous audio segment. The [prompt](/docs/guides/speech-to-text/prompting) should be in English.  |  [optional]
**responseFormat** | [**kotlin.String**](.md) | The format of the transcript output, in one of these options: json, text, srt, verbose_json, or vtt.  |  [optional]
**temperature** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The sampling temperature, between 0 and 1. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic. If set to 0, the model will use [log probability](https://en.wikipedia.org/wiki/Log_probability) to automatically increase the temperature until certain thresholds are hit.  |  [optional]
