package com.project.news.ui.view.listener

import com.project.core.model.remote.Article

interface IMainActivity {

    fun onNewsSelected(article: Article)
}