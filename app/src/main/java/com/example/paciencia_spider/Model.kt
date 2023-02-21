package com.example.paciencia_spider

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Model (
    var success: Boolean,
    var deck_id: String,
    var cards: MutableList<JsonObject>,
    var remaining: Int
)