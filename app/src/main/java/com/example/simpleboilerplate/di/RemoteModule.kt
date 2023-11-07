package com.example.simpleboilerplate.di

import com.example.core.domain.remote.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RemoteModule {

    @Provides
    @ViewModelScoped
    fun provideAuthService() = AuthService()
}