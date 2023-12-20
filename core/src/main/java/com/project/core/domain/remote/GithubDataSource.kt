package com.project.core.domain.remote

import com.project.core.model.remote.GithubRepoResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class GithubDataSource @Inject constructor(
    private val githubService: GithubService
) {

    suspend fun getDataUser(username: String, page: Int = 1): ApiResponse<GithubRepoResponse> {
        return githubService.getUserRepos(username, page)
    }
}