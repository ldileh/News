package com.example.simpleboilerplate.di

import com.example.core.domain.local.AuthData
import com.example.core.domain.local.UserData
import com.example.core.domain.remote.AuthService
import com.example.core.domain.repository.AuthRepository
import com.example.core.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideAuthRepository(
        authData: AuthData,
        userData: UserData,
        authService: AuthService
    ) = AuthRepository(authData, userData, authService)

    @Provides
    @ViewModelScoped
    fun provideUserRepository(userData: UserData) = UserRepository(userData)
}