package com.example.simpleboilerplate.di

import android.content.Context
import com.example.core.config.RemoteConfig
import com.example.simpleboilerplate.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    fun provideService(@ApplicationContext context: Context) = RemoteConfig.serviceBuilder(
        context,
        BuildConfig.BASE_URL
    )
}