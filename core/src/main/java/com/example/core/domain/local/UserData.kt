package com.example.core.domain.local

import android.content.Context
import android.content.SharedPreferences
import com.example.core.config.LocalConfig
import com.example.core.model.local.UserModel
import com.example.core.utils.ext.safe
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class UserData(context: Context) {

    private val keyData = "user-data"

    private val preference: SharedPreferences = context.getSharedPreferences(
        LocalConfig.USER_STORAGE,
        Context.MODE_PRIVATE
    )

    fun store(data: UserModel){
        preference
            .edit()
            .putString(keyData, Gson().toJson(data))
            .apply()
    }

    fun clear(){
        preference
            .edit()
            .clear()
            .apply()
    }

    @Throws(JsonSyntaxException::class, Exception::class)
    fun getUserData(): UserModel? {
        val userDataJson = preference.getString(keyData, "").safe()
        if(userDataJson.isEmpty()) throw Exception("user data is empty! check current state of login")

        return Gson().fromJson(userDataJson, UserModel::class.java)
    }
}