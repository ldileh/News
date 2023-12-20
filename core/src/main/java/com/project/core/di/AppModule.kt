package com.project.core.di

import android.content.Context
import com.project.core.config.RemoteConfig
import com.project.core.BuildConfig
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