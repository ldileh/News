package com.project.news.ui.view.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.project.core.base.BaseActivity
import com.project.core.model.remote.Article
import com.project.core.utils.ext.PermissionResult
import com.project.core.utils.ext.hide
import com.project.core.utils.ext.registerPermission
import com.project.core.utils.ext.runPermissionNotification
import com.project.core.utils.ext.safe
import com.project.core.utils.ext.show
import com.project.news.R
import com.project.news.databinding.ActivityMainBinding
import com.project.news.ui.adapter.NewsAdapter
import com.project.news.ui.listener.IMainActivity
import com.project.news.ui.listener.IViewModel
import com.project.news.ui.view.news.detail.NewsDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), IViewModel<MainViewModel>,
    PermissionResult, IMainActivity {

    private val viewModel by viewModels<MainViewModel>()

    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter(this@MainActivity::onNewsSelected)
    }

    private val requestPermissionNotification: ActivityResultLauncher<String> by lazy {
        registerPermission(this@MainActivity, this@MainActivity)
    }

    override fun ActivityMainBinding.onViewCreated(savedInstanceState: Bundle?) {
        requestPermissionNotification.runPermissionNotification()

        configureViews()

        viewModel.onObserve()
    }

    override fun getBindingFactory(): (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun toolbarId(): Int? = null

    override fun isShowDisplayHome(): Boolean = false

    override fun MainViewModel.onObserve() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                headlinesNews.collectLatest{ newsAdapter.submitData(it) }
            }

            newsAdapter.loadStateFlow
                .distinctUntilChangedBy { it.refresh }
                .filter { it.refresh is LoadState.NotLoading }
                .collect { getBinding().list.scrollToPosition(0) }
        }
    }

    override fun onFinishRequestPermission(isGranted: Boolean) {
    }

    override fun onNewsSelected(article: Article) {
        NewsDetailActivity.showPage(this@MainActivity, article)
    }

    private fun ActivityMainBinding.configureViews(){
        list.configureNews()

        initViewsListener()
    }

    private fun ActivityMainBinding.initViewsListener(){
        viewRefresh.setOnRefreshListener { newsAdapter.refresh() }
    }

    @SuppressLint("SetTextI18n")
    private fun RecyclerView.configureNews(){
        newsAdapter.addLoadStateListener {
            val loadState = it.refresh

            getBinding().viewRefresh.isRefreshing = loadState is LoadState.Loading

            if(loadState is LoadState.Error){
                getBinding().tvErrorMessage.apply {
                    show()
                    text = getString(R.string.text_error_common, loadState.error.message.safe())
                }
            }else{
                getBinding().tvErrorMessage.hide()
            }
        }

        adapter = newsAdapter
    }

}