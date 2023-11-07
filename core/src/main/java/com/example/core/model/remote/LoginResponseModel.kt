package com.example.core.model.remote

import com.example.core.model.local.UserModel

data class LoginResponseModel(
    val token: String?,
    val user: UserModel
)
