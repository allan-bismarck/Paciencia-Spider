package com.example.paciencia_spider

class Card {
    private var code: String
    private var show: Boolean?
    private var value: Int
    private var suit: String
    private var avaiable: Boolean

    constructor(code: String, show: Boolean, value: Int, suit: String, avaiable: Boolean = false) {
        this.code = code
        this.show = show
        this.value = value
        this.suit = suit
        this.avaiable = avaiable
    }

    fun setAvaiable(avaiable: Boolean) {
        this.avaiable = avaiable
    }

    fun getAvaiable(): Boolean {
        return avaiable
    }

    fun getValue(): Int {
        return value
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

