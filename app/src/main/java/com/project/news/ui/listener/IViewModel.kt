package com.project.news.ui.listener

import androidx.lifecycle.ViewModel

interface IViewModel<T: ViewModel> {

    fun T.onObserve()
}