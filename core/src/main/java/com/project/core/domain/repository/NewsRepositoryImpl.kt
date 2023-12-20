package com.project.core.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.project.core.domain.remote.NewsHeadlineClient
import com.project.core.model.remote.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsClient: NewsHeadlineClient
): NewsRepository {

    override suspend fun getHeadlines(): Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { newsClient }
    ).flow
}