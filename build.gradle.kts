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

group = AppConfig.groupId
version = AppConfig.version

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
    maven("https://maven.google.com")
}

dependencies {
    implementation(Deps.kotlinJdk8)
    implementation(Deps.kotlinReflect)

    //OkHtpp
    implementation(platform(Deps.okhttpBom))
    implementation(Deps.okhttp)
    implementation(Deps.okhttpLogging)
    implementation(Deps.okhttpSSE)

    //Gson
    implementation(Deps.gson)

    //Coroutines
    implementation(Deps.coroutines)
}

java {
    withJavadocJar()
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

sourceSets.getByName("main") {
    java.srcDir("src/main/kotlin")
    java.srcDir("'build/generated/source/protos/main/java'")
}
sourceSets.getByName("test") {
    java.srcDir("src/test/kotlin/")
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