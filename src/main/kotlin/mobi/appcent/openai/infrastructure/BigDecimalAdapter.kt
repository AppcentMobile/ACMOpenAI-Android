package mobi.appcent.openai.infrastructure

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.math.BigDecimal

/**
 * Created by erenalpaslan on 5.04.2023
 */
class BigDecimalAdapter() {
    @FromJson
    fun fromJson(string: String) = BigDecimal(string)

    @ToJson
    fun toJson(value: BigDecimal) = value.toString()
}