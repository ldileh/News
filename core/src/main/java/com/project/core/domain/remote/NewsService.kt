package com.project.core.domain.remote

import com.project.core.model.remote.ArticleResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int,
        @Query("country") country: String = "country",
        @Query("apiKey") apiKey: String = "",
    ): Response<ArticleResponseModel>
}