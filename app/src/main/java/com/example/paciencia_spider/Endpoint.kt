package com.example.paciencia_spider

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {
    @GET("/api/deck/new/shuffle/?deck_count=1")
    fun getDeck(): Call<JsonObject>

    @GET("/static/img/{card}")
    fun getImage(@Path(value = "card", encoded = true) card: String): Call<JsonObject>
}