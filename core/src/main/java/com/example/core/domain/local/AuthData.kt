package com.example.core.domain.local

import android.content.Context
import android.content.SharedPreferences
import com.example.core.config.LocalConfig
import com.example.core.utils.ext.safe
import java.lang.Exception

class AuthData(context: Context) {

    private val keyStateLogin = "isUserLogin"
    private val keyToken = "token"

    private val preference: SharedPreferences = context.getSharedPreferences(
        LocalConfig.AUTH_STORAGE,
        Context.MODE_PRIVATE
    )

    fun isLoggedIn() =
        preference.contains(keyStateLogin) && preference.getBoolean(keyStateLogin, false)

    fun setSessionUser(token: String?){
        if(token.isNullOrEmpty()) throw Exception("token is null or empty!")

        preference.edit()
            .apply {
                putBoolean(keyStateLogin, true)
                putString(keyToken, token)
            }
            .apply()
    }

    fun getToken(): String = preference.getString(keyToken, "").safe()

    fun clear() {
        preference
            .edit()
            .clear()
            .apply()
    }
}