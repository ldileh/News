package com.example.core.domain.repository

import com.example.core.domain.local.UserData
import com.example.core.model.local.UserModel

class UserRepository(private val userData: UserData): IUserRepository {

    override fun getUserDataLocal(): UserModel? {
        return try {
            userData.getUserData()
        }catch (e: Exception){
            null
        }
    }

}

interface IUserRepository{

    fun getUserDataLocal(): UserModel?
}