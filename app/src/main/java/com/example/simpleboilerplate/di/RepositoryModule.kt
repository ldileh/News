package com.example.simpleboilerplate.di

import com.example.core.domain.local.AuthData
import com.example.core.domain.local.UserData
import com.example.core.domain.remote.AuthDataSource
import com.example.core.domain.repository.AuthRepository
import com.example.core.domain.repository.UserRepository
import com.example.simpleboilerplate.domain.remote.GithubDataSource
import com.example.simpleboilerplate.domain.repository.GithubRepository
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
        authService: AuthDataSource
    ) = AuthRepository(authData, userData, authService)

    @Provides
    @ViewModelScoped
    fun provideUserRepository(userData: UserData) = UserRepository(userData)

    @Provides
    @ViewModelScoped
    fun provideGithubRepository(dataSource: GithubDataSource) = GithubRepository(dataSource)
}