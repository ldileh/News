package com.example.simpleboilerplate.domain.remote

import com.example.simpleboilerplate.model.remote.GithubRepoResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class GithubDataSource @Inject constructor(
    private val githubService: GithubService
) {

    suspend fun getDataUser(username: String, page: Int = 1): ApiResponse<GithubRepoResponse> {
        return githubService.getUserRepos(username, page)
    }
}