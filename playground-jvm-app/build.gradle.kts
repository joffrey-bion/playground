plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlinx.serialization)
    application
}

application {
    mainClass.set("com.example.MainKt")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.ktor.client.java)
    implementation(libs.ktor.client.contentNegotiation)
    implementation(libs.ktor.client.websockets)
}
