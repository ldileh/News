package com.project.core.di

import com.project.core.domain.remote.GithubDataSource
import com.project.core.domain.remote.GithubService
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
    fun provideGithubDataSource(githubService: GithubService) = GithubDataSource(githubService)
}