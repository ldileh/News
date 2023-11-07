package com.example.simpleboilerplate.di

import android.content.Context
import com.example.core.domain.local.AuthData
import com.example.core.domain.local.UserData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class LocalModule {

    @Provides
    @ViewModelScoped
    fun provideAuthData(@ApplicationContext context: Context) = AuthData(context)

    @Provides
    @ViewModelScoped
    fun provideUserData(@ApplicationContext context: Context) = UserData(context)
}