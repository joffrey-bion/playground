plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
    js {
        browser()
        nodejs {
            testTask {
                useMocha {
                    timeout = "60s"
                }
            }
        }
    }
    mingwX64()
    
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("reflect"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.websockets)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlinx.coroutines.test)
            }
        }
        jvmMain {
            dependencies {
                implementation(libs.java.websocket)
                implementation(libs.ktor.client.java)
            }
        }
        jsMain {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }
        mingwMain {
            dependencies {
                implementation(libs.ktor.client.winhttp)
            }
        }
    }
}
