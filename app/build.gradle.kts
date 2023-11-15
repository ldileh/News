plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfig.appPackage
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appPackage
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "BASE_URL", AppConfig.baseUrlProd)
        }

        debug {
            isMinifyEnabled = false

            buildConfigField("String", "BASE_URL", AppConfig.baseUrlDev)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Dependencies.ui)

    implementation(Dependencies.daggerHiltLibs)
    kapt(Dependencies.daggerHiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}