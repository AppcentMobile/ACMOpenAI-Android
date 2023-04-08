# ACMOpenAI
[![](https://jitpack.io/v/AppcentMobile/ACMOpenAI-Android.svg)](https://jitpack.io/#AppcentMobile/ACMOpenAI-Android)<br>
ACMOpenAI is an unofficial library that help developers to use Open AI API easily.

## Installation
### Maven users

Add this dependency to your project's POM:

```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
    <groupId>com.github.AppcentMobile</groupId>
    <artifactId>ACMOpenAI-Android</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
   implementation 'com.github.AppcentMobile:ACMOpenAI-Android:1.0.0'
}
```
## Usage
Basicly create a instance of ```ACMOpenAI```
and set the apiKey
```kotlin
val openApi = ACMOpenAI.Builder()
    .apiKey("${YOUR_API_KEY}")
    .debugging(true)
    .build()

val response = openApi.chat().createChatCompletion(
    CreateChatCompletionRequest(
        model = "gpt-3.5-turbo",
        messages = arrayOf(
            ChatCompletionRequestMessage(
                role = ChatCompletionRequestMessage.Role.USER.value,
                content = "Hello ChatGPT"
            )
        )
    )
)
```

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints
[**Domentation**](docs/OpenAIApi.md)
All URIs are relative to *https://api.openai.com/v1*

<a name="documentation-for-models"></a>
## [Documentation for Models](docs)

## License

 * MIT ([LICENSE.md](LICENCE) or https://opensource.org/license/mit/)
