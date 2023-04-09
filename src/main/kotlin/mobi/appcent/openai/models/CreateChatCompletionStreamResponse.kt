package mobi.appcent.openai.models

/**
 * Created by erenalpaslan on 9.04.2023
 */
data class CreateChatCompletionStreamResponse(
    val id: String,
    val `object`: String,
    val created: Int,
    val model: String,
    val choices: List<CreateChatCompletionStreamResponseChoices>
)
