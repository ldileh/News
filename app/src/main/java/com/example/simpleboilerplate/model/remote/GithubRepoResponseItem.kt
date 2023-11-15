package com.example.simpleboilerplate.model.remote

import com.google.gson.annotations.SerializedName

data class GithubRepoResponseItem(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0
)