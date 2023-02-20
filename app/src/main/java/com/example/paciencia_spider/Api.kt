package com.example.paciencia_spider

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    companion object {
        fun getRetrofitInstance(BASE_URL: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}