package com.project.core.di

import com.project.core.domain.remote.GithubDataSource
import com.project.core.domain.repository.GithubRepository
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
    fun provideGithubRepository(dataSource: GithubDataSource) = GithubRepository(dataSource)
}