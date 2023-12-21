package com.project.news.ui.listener

import com.project.core.model.remote.Article

interface IMainActivity {

    fun onNewsSelected(article: Article)
}