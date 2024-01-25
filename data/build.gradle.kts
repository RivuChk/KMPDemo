import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
}



kotlin {
    js(IR) {
        moduleName = "@rivuchakraborty/kmpdemoSdk"
        browser {
            binaries.executable()
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SDK"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.okHttp)
            implementation(libs.okhttp.loggingInterceptor)
        }
        commonMain.dependencies {
            implementation(libs.bundles.common.ktor)
            implementation(libs.coroutines.core)
            implementation(libs.arrow.core)
            implementation(libs.kotlinInject.runtime)
        }
        jsMain.dependencies {

        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        val iosX64Main by getting {
            dependencies {
                dependsOn(iosMain.get())
                kotlin.srcDir("build/generated/ksp/iosX64/iosX64Main/kotlin")
            }
        }
        val iosArm64Main by getting {
            dependencies {
                dependsOn(iosMain.get())
                kotlin.srcDir("build/generated/ksp/iosArm64/iosArm64Main/kotlin")
            }
        }
        val iosSimulatorArm64Main by getting {
            dependencies {
                dependsOn(iosMain.get())
                kotlin.srcDir("build/generated/ksp/iosSimulatorArm64/iosSimulatorArm64Main/kotlin")
            }
        }
    }
}

android {
    namespace = "dev.rivu.kmpdemo.sdk"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // KSP will eventually have better multiplatform support and we'll be able to simply have
    // `ksp libs.kotlinInject.compiler` in the dependencies block of each source set
    // https://github.com/google/ksp/pull/1021
    add("kspIosX64", libs.kotlinInject.compiler)
    add("kspIosArm64", libs.kotlinInject.compiler)
    add("kspIosSimulatorArm64", libs.kotlinInject.compiler)
    add("kspAndroid", libs.kotlinInject.compiler)
    add("kspJs", libs.kotlinInject.compiler)
}