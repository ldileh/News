package com.example.core.domain.repository

import com.example.core.domain.local.AuthData
import com.example.core.domain.local.UserData
import com.example.core.model.dummyUser

class AuthRepository(
    private val authData: AuthData,
    private val userData: UserData,
): IAuthRepository {

    override fun login(username: String, password: String) {
        // todo: create method remote data to check authentication user is valid or not

        // save state of user
        authData.setSessionUser("token of auth user")
        userData.store(dummyUser())
    }

    override fun logout() {
        // TODO: if needed, create some business logic before clear state of session login user
        authData.clear()
        userData.clear()
    }

    override fun isLoggedIn(): Boolean = authData.isLoggedIn()
}

interface IAuthRepository{

    fun login(username: String, password: String)
    fun logout()
    fun isLoggedIn(): Boolean
}