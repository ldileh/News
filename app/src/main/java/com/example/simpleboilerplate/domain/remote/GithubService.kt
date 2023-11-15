package com.example.simpleboilerplate.domain.remote

import com.example.simpleboilerplate.model.remote.GithubRepoResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/users/{user}/repos")
    suspend fun getUserRepos(
        @Path("user") user: String,
        @Query("page") page: Int
    ): ApiResponse<GithubRepoResponse>
}