package com.project.core.model.remote

import com.project.core.model.local.UserModel

data class LoginResponseModel(
    val token: String?,
    val user: UserModel
)
