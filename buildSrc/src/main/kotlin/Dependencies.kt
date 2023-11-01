import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * For more information about KDoc syntax, see [BuildSrc in Kotlin DSL](https://blog.kotlin-academy.com/kotlin-dsl-buildsrc-product-flavors-flavor-icon-and-more-abf30c65e8fd).
 */
object Dependencies {
    val coreKtx = "androidx.core:core-ktx:${Versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val material = "com.google.android.material:material:${Versions.material}"

    val jUnit = "junit:junit:${Versions.jUnit}"
    val jUnitExtension = "androidx.test.ext:junit:${Versions.jUnitExtension}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"

    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val retrofitInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitOkhttp3}"
    val retrofitOkHttp = "com.squareup.okhttp3:okhttp:${Versions.retrofitOkhttp3}"

    val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    val coil = "io.coil-kt:coil:${Versions.coil}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val main = arrayListOf<String>().apply {
        add(coreKtx)
        add(gson)
        add(daggerHilt)
        add(retrofit)
        add(retrofitGson)
        add(retrofitInterceptor)
        add(retrofitOkHttp)
        add(coil)
        add(timber)
    }

    val ui = arrayListOf<String>().apply {
        add(appCompat)
        add(material)
    }

    val unitTest = arrayListOf<String>().apply {
        add(jUnit)
    }

    val androidUnitTest = arrayListOf<String>().apply {
        add(jUnitExtension)
        add(espresso)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}