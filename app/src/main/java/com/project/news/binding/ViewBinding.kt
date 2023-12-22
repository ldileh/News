package com.project.news.binding

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.project.core.utils.ext.formatDate
import com.project.core.utils.ext.safe
import com.project.news.R

object ViewBinding {

    @JvmStatic
    @BindingAdapter("dateFormat")
    fun bindDateFormat(view: TextView, date: String?) {
        view.text = date.formatDate("dd MMMM yyyy HH:mm")
    }

    @JvmStatic
    @BindingAdapter("loadBanner")
    fun bindLoadBanner(view: ImageView, url: String?) {
        view.load(url){
            crossfade(true)
            placeholder(R.drawable.img_placeholder)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @JvmStatic
    @BindingAdapter("loadWeb")
    fun bindLoadWeb(view: WebView, url: String?) {
        view.apply {
            settings.apply {
                javaScriptEnabled = true
            }
            webViewClient = WebViewClient()

            loadUrl(url.safe())
        }
    }
}