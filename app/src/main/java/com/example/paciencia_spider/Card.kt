package com.example.paciencia_spider

class Card {
    var code: String
    var show: Boolean?
    var value: Int
    var suit: String

    constructor(code: String, show: Boolean, value: Int, suit: String) {
        this.code = code
        this.show = show
        this.value = value
        this.suit = suit
    }

    fun getImageUrl(code: String):String {
        return "https://deckofcardsapi.com/static/img/$code.png"
    }

    fun getImageBack(): String {
        return "https://deckofcardsapi.com/static/img/back.png"
    }
}

