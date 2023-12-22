package com.project.news.ui.view.news.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.core.model.remote.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(): ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article

    fun initData(data: Article) {
        _article.value = data
    }
}