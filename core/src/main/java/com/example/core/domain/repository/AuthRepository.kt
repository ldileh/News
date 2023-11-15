package com.example.core.domain.repository

import com.example.core.domain.local.AuthData
import com.example.core.domain.local.UserData
import com.example.core.domain.remote.AuthDataSource

class AuthRepository(
    private val authData: AuthData,
    private val userData: UserData,
    private val authService: AuthDataSource
): IAuthRepository {

    // create method remote data to check authentication user is valid or not
    override suspend fun login(username: String, password: String): Boolean {
        val response = authService.onLogin(username, password)
        if(response != null){
            // save state of user
            authData.setSessionUser(response.token)
            userData.store(response.user)

            return true
        }

        return false
    }

    // if needed, create some business logic before clear state of session login user
    override suspend fun logout(): Boolean {
        authData.clear()
        userData.clear()

        return true
    }

    override fun isLoggedIn(): Boolean = authData.isLoggedIn()
}

interface IAuthRepository{

    suspend fun login(username: String, password: String): Boolean
    suspend fun logout(): Boolean
    fun isLoggedIn(): Boolean
}