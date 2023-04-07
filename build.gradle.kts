import org.gradle.api.publish.maven.MavenPublication

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
    id("java")
    id("maven-publish")
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
}

group = "mobi.appcent"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
    maven("https://maven.google.com")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}")

    //OkHtpp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "mobi.appcent"
            artifactId = "ACMOpenAI-Android"
            version = "1.0.0"

            from(components["java"])
        }
    }
}