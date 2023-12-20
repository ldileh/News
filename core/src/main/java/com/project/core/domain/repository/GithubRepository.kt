package com.project.core.domain.repository

import com.project.core.domain.remote.GithubDataSource
import com.project.core.model.remote.GithubRepoResponse
import com.skydoves.sandwich.ApiResponse

class GithubRepository(private val githubDataSource: GithubDataSource) {

    suspend fun getUsers(username: String, page: Int): ApiResponse<GithubRepoResponse> {
        return githubDataSource.getDataUser(username, page)
    }
}