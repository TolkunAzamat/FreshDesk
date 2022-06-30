package com.example.freshdesk.api

import com.example.freshdesk.App
import com.example.freshdesk.utils.sharedPreferences.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    fun retrofitModule(): Api {
        val authToken = SharedPreferences(App.getContext()).token
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    if (authToken != null) it.addHeader("Authorization", "Bearer $authToken")
                }.build())
            }
            .build()

        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("http://192.168.1.6:13156/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(Api::class.java)
        }
        return retrofit
    }
}
