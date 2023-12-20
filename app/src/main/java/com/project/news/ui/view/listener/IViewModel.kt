package com.project.news.ui.view.listener

import androidx.lifecycle.ViewModel

interface IViewModel<T: ViewModel> {

    fun T.onObserve()
}