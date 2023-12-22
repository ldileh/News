package com.project.news.ui.view.news.detail

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.project.core.base.BaseActivity
import com.project.core.model.remote.Article
import com.project.news.R
import com.project.news.databinding.ActivityNewsDetailBinding
import com.project.news.ui.listener.INewsDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NullPointerException

@AndroidEntryPoint
class NewsDetailActivity: BaseActivity<ActivityNewsDetailBinding>(), INewsDetailActivity {

    private val viewModel by viewModels<NewsDetailViewModel>()

    private lateinit var data: Article

    companion object{

        private const val EXTRA_DATA = "extra_data"

        fun showPage(context: Context, data: Article){
            context.startActivity(Intent(context, NewsDetailActivity::class.java).apply {
                putExtra(EXTRA_DATA, data)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_DATA, Article::class.java)
        }else{
            intent.getSerializableExtra(EXTRA_DATA) as Article?
        } ?: throw NullPointerException("cannot move to this activity without data article")

        super.onCreate(savedInstanceState)
    }

    override fun ActivityNewsDetailBinding.onViewCreated(savedInstanceState: Bundle?) {
        getBinding().lifecycleOwner = this@NewsDetailActivity
        getBinding().apply {
            vm = viewModel
            page = this@NewsDetailActivity
        }

        viewModel.initData(data)
    }

    override fun getBindingFactory(): (LayoutInflater) -> ActivityNewsDetailBinding {
        return ActivityNewsDetailBinding::inflate
    }

    override fun toolbarId(): Int? = null

    override fun isShowDisplayHome(): Boolean = false

    override fun getLayoutId(): Int = R.layout.activity_news_detail

    override fun isUseDataBinding(): Boolean  = true

    override fun onClosePage() {
        onBackPressedDispatcher.onBackPressed()
    }
}