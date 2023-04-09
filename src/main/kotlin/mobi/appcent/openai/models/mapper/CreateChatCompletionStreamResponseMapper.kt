package mobi.appcent.openai.models.mapper

import mobi.appcent.openai.models.ChatCompletionResponseMessage
import mobi.appcent.openai.models.CreateChatCompletionResponse
import mobi.appcent.openai.models.CreateChatCompletionResponseChoices
import mobi.appcent.openai.models.CreateChatCompletionStreamResponse

/**
 * Created by erenalpaslan on 9.04.2023
 */
object CreateChatCompletionStreamResponseMapper {

    fun transform(input: CreateChatCompletionStreamResponse?): CreateChatCompletionResponse {
        return CreateChatCompletionResponse(
            id = input?.id ?: "",
            `object` = input?.`object` ?: "",
            created = input?.created ?: 0,
            model = input?.model ?: "",
            choices = input?.choices?.map {streamChoices ->
                CreateChatCompletionResponseChoices(
                    index = streamChoices.index,
                    message = ChatCompletionResponseMessage(
                        role = streamChoices.delta.role,
                        content = streamChoices.delta.content
                    ),
                    finishReason = streamChoices.finishReason
                )
            } ?: emptyList()
        )
    }

}