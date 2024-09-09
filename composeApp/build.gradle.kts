import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Navigation
            implementation(libs.androidx.navigation.compose)

            // Material Design 3
            implementation(libs.material3)

            // Icons
            implementation(compose.materialIconsExtended)

            // Coil
            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha08")
            implementation("io.coil-kt.coil3:coil-network-ktor:3.0.0-alpha08")
            implementation("io.ktor:ktor-client-core:3.0.0-wasm2")





        }
    }
}







