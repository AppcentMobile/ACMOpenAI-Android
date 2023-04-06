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
 * @param id 
 * @param &#x60;object&#x60; 
 * @param bytes 
 * @param createdAt 
 * @param filename 
 * @param purpose 
 * @param status 
 * @param statusDetails 
 */
data class OpenAIFile (

    val id: kotlin.String,
    val `object`: kotlin.String,
    val bytes: kotlin.Int,
    val createdAt: kotlin.Int,
    val filename: kotlin.String,
    val purpose: kotlin.String,
    val status: kotlin.String? = null,
    val statusDetails: kotlin.Any? = null
) {
}