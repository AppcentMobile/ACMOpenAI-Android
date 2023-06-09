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
 * @param &#x60;object&#x60; 
 * @param model 
 * @param &#x60;data&#x60; 
 */
data class CreateSearchResponse (

    val `object`: kotlin.String? = null,
    val model: kotlin.String? = null,
    val `data`: kotlin.Array<CreateSearchResponseData>? = null
) {
}