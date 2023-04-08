import org.gradle.api.publish.maven.MavenPublication

buildscript {

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}
plugins {
    java
    `maven-publish`
    id("org.jetbrains.kotlin.plugin.sam.with.receiver") version Versions.kotlinVersion
    `java-library`
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

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "mobi.appcent"
            artifactId = "ACMOpenAI-Android"
            version = "1.0.0"

            from(components["java"])

            pom {
                packaging = "jar"
                name.set("ACMOpenAI-Android")
                scm {
                    url.set("https://github.com/AppcentMobile/ACMOpenAI-Android")
                }
            }

        }
    }
}