package com.project.core.model.remote


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ArticleResponseModel(
    @SerializedName("articles")
    val articles: List<Article>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)