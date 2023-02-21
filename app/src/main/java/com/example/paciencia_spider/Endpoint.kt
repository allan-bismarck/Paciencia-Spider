package com.example.paciencia_spider

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    @GET("/api/deck/new/shuffle/?cards=AS,2S,3S,4S,5S,6S,7S,8S,9S,0S,JS,QS,KS&deck_count=8")
    fun getDeckOneNaipe(): Call<JsonObject>

    @GET("/api/deck/new/shuffle/?cards=AS,2S,3S,4S,5S,6S,7S,8S,9S,0S,JS,QS,KS,AC,2C,3C,4C,5C,6C,7C,8C,9C,0C,JC,QC,KC&deck_count=4")
    fun getDeckTwoNaipes(): Call<JsonObject>

    @GET("/api/deck/new/shuffle/?deck_count=2")
    fun getDeckFourNaipes(): Call<JsonObject>

    @GET("/api/deck/{deckId}/draw/?count=6")
    fun distributeSixCards(
        @Path(value = "deckId", encoded = true) deck_id: String,
    ): Call<JsonObject>

    @GET("/api/deck/{deckId}/draw/?count=5")
    fun distributeFiveCards(
        @Path(value = "deckId", encoded = true) deck_id: String,
    ): Call<JsonObject>

    @GET("/api/deck/{deckId}/draw/?count=10")
    fun distributeTenCards(
        @Path(value = "deckId", encoded = true) deck_id: String,
    ): Call<JsonObject>

}