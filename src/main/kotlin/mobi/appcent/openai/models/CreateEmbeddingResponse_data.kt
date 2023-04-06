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
 * @param index 
 * @param &#x60;object&#x60; 
 * @param embedding 
 */
data class CreateEmbeddingResponseData (

    val index: kotlin.Int,
    val `object`: kotlin.String,
    val embedding: kotlin.Array<java.math.BigDecimal>
) {
}