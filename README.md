
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

## Screenshot of App
![Fist Page](https://github.com/ldileh/Simple-Boilerplate-Android/blob/master/Screenshot_1703216729.png)
![Item News](https://github.com/ldileh/Simple-Boilerplate-Android/blob/master/Screenshot_1703216725.png)
![Detail News](https://github.com/ldileh/Simple-Boilerplate-Android/blob/master/Screenshot_1703216738.png)

## Requirements

* JDK 11
* [Android SDK](https://developer.android.com/studio/index.html)

## Architecture

![Main Pattern of App](https://github.com/ldileh/Simple-Boilerplate-Android/blob/0fa3273a59c410d2a7b824f8dc8699cb57f607cd/Sample%20Of%20Simple%20Architecture%20Android%20(2).jpg)
![Modules on project](https://github.com/ldileh/Simple-Boilerplate-Android/blob/master/Architecture%20modules%20Android.jpg)

### User Interface

This layer makes use of the Android Framework and is used to create all of our UI components to display inside of activities or fragments.

### Repository
![Modules on project](https://github.com/ldileh/Simple-Boilerplate-Android/blob/master/Data%20Layer.jpg)

This layer's responsibility is to handle the business logic on app.

### Domain

The domain layer responsibility is to simply contain the UseCase instance used to retrieve data from the Data layer and pass it onto the Presentation layer. 

### Local

### Remote

The Remote layer handles all communications with remote sources, in our case it makes a simple API call using a Retrofit interface. 

