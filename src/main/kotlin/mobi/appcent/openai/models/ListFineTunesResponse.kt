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
 * @param &#x60;data&#x60; 
 */
data class ListFineTunesResponse (

    val `object`: kotlin.String,
    val `data`: kotlin.Array<FineTune>
) {
}