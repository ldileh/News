package com.project.news.ui.view.main

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.project.core.domain.repository.NewsRepository
import com.project.core.model.remote.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(newsRepository: NewsRepository): ViewModel() {

    val headlinesNews: Flow<PagingData<Article>> = newsRepository
        .getHeadlines()
        .flowOn(Dispatchers.IO)
}