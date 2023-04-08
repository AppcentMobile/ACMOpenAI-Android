import org.gradle.api.publish.maven.MavenPublication

buildscript {

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
    }
}
plugins {
    java
    `maven-publish`
    `java-library`
    id("org.jetbrains.kotlin.jvm") version Versions.kotlinVersion
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
            groupId = "mobi.appcent"
            artifactId = "acmopenai-android"
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