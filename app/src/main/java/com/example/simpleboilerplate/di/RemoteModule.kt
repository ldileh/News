package com.example.simpleboilerplate.di

import com.example.core.domain.remote.AuthDataSource
import com.example.simpleboilerplate.domain.remote.GithubDataSource
import com.example.simpleboilerplate.domain.remote.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class RemoteModule {

    @Provides
    @ViewModelScoped
    fun provideGithubService(retrofit: Retrofit) = retrofit.create(GithubService::class.java)

    @Provides
    @ViewModelScoped
    fun provideAuthDataSource() = AuthDataSource()

    @Provides
    @ViewModelScoped
    fun provideGithubDataSource(githubService: GithubService) = GithubDataSource(githubService)
}