package com.project.core.domain.repository

import androidx.paging.PagingData
import com.project.core.model.remote.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository{

    suspend fun getHeadlines(): Flow<PagingData<Article>>
}