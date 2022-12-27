plugins {
    kotlin("jvm") version "1.6.21"
    application
}

group = "hu.info.hunyadi.ktbind"
version = "1.0.0"

apply(plugin = "java")
apply(plugin = "application")
apply(plugin = "org.jetbrains.kotlin.jvm")

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
val compileTestKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.named<Test>("test") {
    useJUnitPlatform {
        systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}
