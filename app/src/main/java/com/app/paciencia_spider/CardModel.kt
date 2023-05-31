package com.app.paciencia_spider

import com.google.gson.JsonObject

data class CardModel (
    var success: Boolean,
    var deck_id: String,
    var cards: MutableList<JsonObject>,
    var remaining: Int
)