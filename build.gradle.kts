import org.gradle.api.publish.maven.MavenPublication
import org.jetbrains.kotlin.fir.resolve.withExpectedType

buildscript {

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
    }
}

plugins {
    java
    `maven-publish`
    `java-library`
    id("org.jetbrains.kotlin.jvm") version Versions.kotlinVersion
}

group = AppConfig.groupId
version = AppConfig.version

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
    maven("https://maven.google.com")
}

dependencies {
    //Kotlin
    implementation(Deps.kotlinJdk8)
    implementation(Deps.kotlinReflect)

    //OkHtpp
    api(platform(Deps.okhttpBom))
    api(Deps.okhttp)
    api(Deps.okhttpLogging)
    api(Deps.okhttpSSE)

    //Gson
    api(Deps.gson)

    //Coroutines
    api(Deps.coroutines)
    api(Deps.coroutinesJdk8)
    api(Deps.coroutinesSf4j)
}

java {
    withJavadocJar()
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = AppConfig.groupId
            artifactId = AppConfig.artifactId
            version = AppConfig.version

            from(components["java"])

            pom {
                packaging = "jar"
                name.set(AppConfig.name)
                scm {
                    url.set("https://github.com/AppcentMobile/ACMOpenAI-Android")
                }
            }

        }
    }
}