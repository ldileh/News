package com.project.core.config

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteConfig {

    fun serviceBuilder(context: Context, baseUrl: String): Retrofit {
        val myChuckerInterceptor = ChuckerInterceptor.Builder(context) // `this` is the context
            // The previously created ChuckerCollector
            .collector(ChuckerCollector(
                context = context,                 // Context on which you are
                showNotification = true,        // Boolean for showing Notification, set to true to show and false otherwise
            ))
            // List of headers to replace with ** in the Chucker UI
            .redactHeaders("Auth-Token", "Bearer")
            // Read the whole response body even when the client does not consume the response completely.
            // This is useful in case of parsing errors or when the response body
            // is closed before being read like in Retrofit with Void and Unit types.
            .alwaysReadResponseBody(true)
            .build()

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(myChuckerInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}