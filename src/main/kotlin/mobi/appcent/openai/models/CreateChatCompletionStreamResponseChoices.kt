package mobi.appcent.openai.models

import com.google.gson.annotations.SerializedName

/**
 * Created by erenalpaslan on 9.04.2023
 */
data class CreateChatCompletionStreamResponseChoices(
    val delta: ChatCompletionResponseMessage,
    val index: Int,
    @SerializedName("finish_reason")
    val finishReason: String?
)
