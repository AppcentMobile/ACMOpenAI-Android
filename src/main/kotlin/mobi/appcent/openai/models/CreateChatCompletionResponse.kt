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
 * @param created 
 * @param model 
 * @param choices 
 * @param usage 
 */
data class CreateChatCompletionResponse (

    val id: String,
    val `object`: String,
    val created: Int,
    val model: String,
    val choices: List<CreateChatCompletionResponseChoices>,
    val usage: CreateCompletionResponseUsage? = null
) {
}