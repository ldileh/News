
# Simple Boilerplate Android

## Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* Android Support Libraries
* [Dagger Hilt](https://dagger.dev/hilt/)
* [Coil](https://github.com/coil-kt/coil)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Timber](https://github.com/JakeWharton/timber)
* [Mockito](http://site.mockito.org/)
* [Espresso](https://developer.android.com/training/testing/espresso/index.html)
* [Chucker](https://github.com/ChuckerTeam/chucker)
* [whatIf](https://github.com/skydoves/WhatIf)
* [sandwich](https://github.com/ChuckerTeam/chucker)

## Requirements

* JDK 11
* [Android SDK](https://developer.android.com/studio/index.html)

## Architecture

### User Interface

This layer makes use of the Android Framework and is used to create all of our UI components to display inside of activities or fragments.

### Repository

This layer's responsibility is to handle the 

### Domain

The domain layer responsibility is to simply contain the UseCase instance used to retrieve data from the Data layer and pass it onto the Presentation layer. 

### Local



### Remote

The Remote layer handles all communications with remote sources, in our case it makes a simple API call using a Retrofit interface. 

