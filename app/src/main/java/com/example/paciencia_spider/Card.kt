package com.example.paciencia_spider

class Card {
    private var code: String
    private var show: Boolean?
    private var value: String
    private var suit: String

    constructor(code: String, show: Boolean, value: String, suit: String) {
        this.code = code
        this.show = show
        this.value = value
        this.suit = suit
    }

    fun getCodeC(): String {
        return code
    }

    fun setShow(show: Boolean) {
        this.show = show
    }

    fun getShow():Boolean? {
        return this.show
    }

    fun getImageUrl(code: String):String {
        return "https://deckofcardsapi.com/static/img/$code.png"
    }

    fun getImageBack(): String {
        return "https://deckofcardsapi.com/static/img/back.png"
    }
}

