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
package mobi.appcent.openai.models


/**
 * 
 * @param prompt A text description of the desired image(s). The maximum length is 1000 characters.
 * @param n The number of images to generate. Must be between 1 and 10.
 * @param size The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
 * @param responseFormat The format in which the generated images are returned. Must be one of `url` or `b64_json`.
 * @param user A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids). 
 */
data class CreateImageRequest (

    /* A text description of the desired image(s). The maximum length is 1000 characters. */
    val prompt: kotlin.String,
    /* The number of images to generate. Must be between 1 and 10. */
    val n: kotlin.Int? = null,
    /* The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`. */
    val size: CreateImageRequest.Size? = null,
    /* The format in which the generated images are returned. Must be one of `url` or `b64_json`. */
    val responseFormat: CreateImageRequest.ResponseFormat? = null,
    /* A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. [Learn more](/docs/guides/safety-best-practices/end-user-ids).  */
    val user: kotlin.String? = null
) {
    /**
    * The size of the generated images. Must be one of `256x256`, `512x512`, or `1024x1024`.
    * Values: _256X256,_512X512,_1024X1024
    */
    enum class Size(val value: kotlin.String?){
        _256X256("256x256"),
        _512X512("512x512"),
        _1024X1024("1024x1024");
    }
    /**
    * The format in which the generated images are returned. Must be one of `url` or `b64_json`.
    * Values: URL,B64JSON
    */
    enum class ResponseFormat(val value: kotlin.String?){
        URL("url"),
        B64JSON("b64_json");
    }
}