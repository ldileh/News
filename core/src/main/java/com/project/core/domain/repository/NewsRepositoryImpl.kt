package com.project.core.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.project.core.domain.remote.NewsHeadlineClient
import com.project.core.domain.remote.NewsService
import com.project.core.model.remote.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
): NewsRepository {

    override fun getHeadlines(): Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = NewsHeadlineClient.PAGE_SIZE, prefetchDistance = 2),
        pagingSourceFactory = { NewsHeadlineClient(newsService) }
    ).flow
}