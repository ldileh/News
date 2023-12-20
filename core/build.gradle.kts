plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.project.core"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures{
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    api(Dependencies.main)
    api(Dependencies.appCompat)
    api(Dependencies.unitTest)
    api(Dependencies.androidUnitTest)

    debugImplementation(Dependencies.chuckerDebug)
    releaseImplementation(Dependencies.chuckerRelease)

    implementation(Dependencies.daggerHiltLibs)
    kapt(Dependencies.daggerHiltCompiler)

    kaptTest(Dependencies.daggerHiltKotlinTest)
}