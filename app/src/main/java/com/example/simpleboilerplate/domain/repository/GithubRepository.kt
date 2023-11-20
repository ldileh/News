package com.example.simpleboilerplate.domain.repository

import com.example.simpleboilerplate.domain.remote.GithubDataSource
import com.example.simpleboilerplate.model.remote.GithubRepoResponse
import com.skydoves.sandwich.ApiResponse

class GithubRepository(private val githubDataSource: GithubDataSource) {

    suspend fun getUsers(username: String, page: Int): ApiResponse<GithubRepoResponse> {
        return githubDataSource.getDataUser(username, page)
    }
}