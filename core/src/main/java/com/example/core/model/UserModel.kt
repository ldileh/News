package com.example.core.model

import java.io.Serializable

data class UserModel(
    val email: String,
    val name: String,
    val urlProfilePict: String
): Serializable

fun dummyUser(): UserModel = UserModel(
    "ldileh@gmail.com",
    "ldileh",
    ""
)