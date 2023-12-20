package com.project.core.di

import com.project.core.domain.repository.NewsRepository
import com.project.core.domain.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}