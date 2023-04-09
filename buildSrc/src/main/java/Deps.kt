/**
 * Created by erenalpaslan on 8.04.2023
 */
object Versions {
    const val kotlinVersion = "1.5.31"
    const val okhttpBomVersion = "4.10.0"
    const val gsonVersion = "2.10.1"
    const val coroutinesVersion = "1.5.2"
}

object Deps {
    //Kotlin
    const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.coroutinesVersion}"

    //OkHttp
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttpBomVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor"
    const val okhttpSSE = "com.squareup.okhttp3:okhttp-sse"

    //Serialization
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

}