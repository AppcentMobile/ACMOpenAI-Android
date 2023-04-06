package mobi.appcent.openai.infrastructure

import com.google.gson.Gson

object Serializer {
    @JvmStatic
    val gson: Gson = Gson()
}