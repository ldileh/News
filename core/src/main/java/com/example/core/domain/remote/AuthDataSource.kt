package com.example.core.domain.remote

import com.example.core.model.local.UserModel
import com.example.core.model.remote.LoginResponseModel

class AuthDataSource {

    suspend fun onLogin(username: String, password: String): LoginResponseModel?{
        if(username.isEmpty()){
            return null
        }

        // create dummy process of authentication
        return LoginResponseModel(
            "hello world!",
            UserModel(
                email = username,
                name = "Jhon Dalton",
                urlProfilePict = "https://gravatar.com/avatar/9980c46aced25e86cdd1555950eb14b8?s=400&d=robohash&r=x"
            )
        )
    }

    suspend fun onLogout(): Boolean{
        return true
    }
}