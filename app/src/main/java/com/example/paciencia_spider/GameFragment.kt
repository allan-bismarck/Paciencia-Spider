package com.example.paciencia_spider

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class GameFragment : Fragment() {
    private var URL_IMAGES = "https://deckofcardsapi.com/static/img/"

    private lateinit var userName: TextView
    private lateinit var deck: FrameLayout
    private lateinit var deck_c1: ImageView
    private lateinit var deck_c2: ImageView
    private lateinit var deck_c3: ImageView
    private lateinit var deck_c4: ImageView
    private lateinit var deck_c5: ImageView

    private lateinit var p1_c1: ImageView
    private lateinit var p1_c2: ImageView
    private lateinit var p1_c3: ImageView
    private lateinit var p1_c4: ImageView
    private lateinit var p1_c5: ImageView
    private lateinit var p1_c6: ImageView
    private lateinit var p1_c7: ImageView
    private lateinit var p1_c8: ImageView
    private lateinit var p1_c9: ImageView
    private lateinit var p1_c10: ImageView
    private lateinit var p1_c11: ImageView
    private lateinit var p1_c12: ImageView
    private lateinit var p1_c13: ImageView

    private lateinit var p2_c1: ImageView
    private lateinit var p2_c2: ImageView
    private lateinit var p2_c3: ImageView
    private lateinit var p2_c4: ImageView
    private lateinit var p2_c5: ImageView
    private lateinit var p2_c6: ImageView
    private lateinit var p2_c7: ImageView
    private lateinit var p2_c8: ImageView
    private lateinit var p2_c9: ImageView
    private lateinit var p2_c10: ImageView
    private lateinit var p2_c11: ImageView
    private lateinit var p2_c12: ImageView
    private lateinit var p2_c13: ImageView

    private lateinit var p3_c1: ImageView
    private lateinit var p3_c2: ImageView
    private lateinit var p3_c3: ImageView
    private lateinit var p3_c4: ImageView
    private lateinit var p3_c5: ImageView
    private lateinit var p3_c6: ImageView
    private lateinit var p3_c7: ImageView
    private lateinit var p3_c8: ImageView
    private lateinit var p3_c9: ImageView
    private lateinit var p3_c10: ImageView
    private lateinit var p3_c11: ImageView
    private lateinit var p3_c12: ImageView
    private lateinit var p3_c13: ImageView

    private lateinit var p4_c1: ImageView
    private lateinit var p4_c2: ImageView
    private lateinit var p4_c3: ImageView
    private lateinit var p4_c4: ImageView
    private lateinit var p4_c5: ImageView
    private lateinit var p4_c6: ImageView
    private lateinit var p4_c7: ImageView
    private lateinit var p4_c8: ImageView
    private lateinit var p4_c9: ImageView
    private lateinit var p4_c10: ImageView
    private lateinit var p4_c11: ImageView
    private lateinit var p4_c12: ImageView
    private lateinit var p4_c13: ImageView

    private lateinit var p5_c1: ImageView
    private lateinit var p5_c2: ImageView
    private lateinit var p5_c3: ImageView
    private lateinit var p5_c4: ImageView
    private lateinit var p5_c5: ImageView
    private lateinit var p5_c6: ImageView
    private lateinit var p5_c7: ImageView
    private lateinit var p5_c8: ImageView
    private lateinit var p5_c9: ImageView
    private lateinit var p5_c10: ImageView
    private lateinit var p5_c11: ImageView
    private lateinit var p5_c12: ImageView
    private lateinit var p5_c13: ImageView

    private lateinit var p6_c1: ImageView
    private lateinit var p6_c2: ImageView
    private lateinit var p6_c3: ImageView
    private lateinit var p6_c4: ImageView
    private lateinit var p6_c5: ImageView
    private lateinit var p6_c6: ImageView
    private lateinit var p6_c7: ImageView
    private lateinit var p6_c8: ImageView
    private lateinit var p6_c9: ImageView
    private lateinit var p6_c10: ImageView
    private lateinit var p6_c11: ImageView
    private lateinit var p6_c12: ImageView
    private lateinit var p6_c13: ImageView

    private lateinit var p7_c1: ImageView
    private lateinit var p7_c2: ImageView
    private lateinit var p7_c3: ImageView
    private lateinit var p7_c4: ImageView
    private lateinit var p7_c5: ImageView
    private lateinit var p7_c6: ImageView
    private lateinit var p7_c7: ImageView
    private lateinit var p7_c8: ImageView
    private lateinit var p7_c9: ImageView
    private lateinit var p7_c10: ImageView
    private lateinit var p7_c11: ImageView
    private lateinit var p7_c12: ImageView
    private lateinit var p7_c13: ImageView

    private lateinit var p8_c1: ImageView
    private lateinit var p8_c2: ImageView
    private lateinit var p8_c3: ImageView
    private lateinit var p8_c4: ImageView
    private lateinit var p8_c5: ImageView
    private lateinit var p8_c6: ImageView
    private lateinit var p8_c7: ImageView
    private lateinit var p8_c8: ImageView
    private lateinit var p8_c9: ImageView
    private lateinit var p8_c10: ImageView
    private lateinit var p8_c11: ImageView
    private lateinit var p8_c12: ImageView
    private lateinit var p8_c13: ImageView

    private lateinit var p9_c1: ImageView
    private lateinit var p9_c2: ImageView
    private lateinit var p9_c3: ImageView
    private lateinit var p9_c4: ImageView
    private lateinit var p9_c5: ImageView
    private lateinit var p9_c6: ImageView
    private lateinit var p9_c7: ImageView
    private lateinit var p9_c8: ImageView
    private lateinit var p9_c9: ImageView
    private lateinit var p9_c10: ImageView
    private lateinit var p9_c11: ImageView
    private lateinit var p9_c12: ImageView
    private lateinit var p9_c13: ImageView

    private lateinit var p10_c1: ImageView
    private lateinit var p10_c2: ImageView
    private lateinit var p10_c3: ImageView
    private lateinit var p10_c4: ImageView
    private lateinit var p10_c5: ImageView
    private lateinit var p10_c6: ImageView
    private lateinit var p10_c7: ImageView
    private lateinit var p10_c8: ImageView
    private lateinit var p10_c9: ImageView
    private lateinit var p10_c10: ImageView
    private lateinit var p10_c11: ImageView
    private lateinit var p10_c12: ImageView
    private lateinit var p10_c13: ImageView

    private var stackOneCards: MutableList<Card> = mutableListOf()
    private var stackTwoCards: MutableList<Card> = mutableListOf()
    private var stackTreeCards: MutableList<Card> = mutableListOf()
    private var stackFourCards: MutableList<Card> = mutableListOf()
    private var stackFiveCards: MutableList<Card> = mutableListOf()
    private var stackSixCards: MutableList<Card> = mutableListOf()
    private var stackSevenCards: MutableList<Card> = mutableListOf()
    private var stackEightCards: MutableList<Card> = mutableListOf()
    private var stackNineCards: MutableList<Card> = mutableListOf()
    private var stackTenCards: MutableList<Card> = mutableListOf()

    private lateinit var deckId: String

    private var qtdNaipes by Delegates.notNull<Int>()

    private lateinit var splashFragment: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        qtdNaipes = arguments?.getInt("qtdNaipes")!!
        getDeck()
        Log.i("Ciclo GameFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game, container, false)

        userName = view.findViewById(R.id.label)
        deck = view.findViewById(R.id.deck)
        deck.setOnClickListener {
            var cardFalse = mutableListOf<Card>(Card("", false, "", ""))
            distributeCards(deckId, 10, cardFalse)
        }

        deck_c1 = view.findViewById(R.id.deck_c1)
        Glide.with(this).load("$URL_IMAGES/back.png").into(deck_c1)
        deck_c2 = view.findViewById(R.id.deck_c2)
        Glide.with(this).load("$URL_IMAGES/back.png").into(deck_c2)
        deck_c3 = view.findViewById(R.id.deck_c3)
        Glide.with(this).load("$URL_IMAGES/back.png").into(deck_c3)
        deck_c4 = view.findViewById(R.id.deck_c4)
        Glide.with(this).load("$URL_IMAGES/back.png").into(deck_c4)
        deck_c5 = view.findViewById(R.id.deck_c5)
        Glide.with(this).load("$URL_IMAGES/back.png").into(deck_c5)

        p1_c1 = view.findViewById(R.id.p1c1)
        p1_c2 = view.findViewById(R.id.p1c2)
        p1_c3 = view.findViewById(R.id.p1c3)
        p1_c4 = view.findViewById(R.id.p1c4)
        p1_c5 = view.findViewById(R.id.p1c5)
        p1_c6 = view.findViewById(R.id.p1c6)
        p1_c7 = view.findViewById(R.id.p1c7)
        p1_c8 = view.findViewById(R.id.p1c8)
        p1_c9 = view.findViewById(R.id.p1c9)
        p1_c10 = view.findViewById(R.id.p1c10)
        p1_c11 = view.findViewById(R.id.p1c11)
        p1_c12 = view.findViewById(R.id.p1c12)
        p1_c13 = view.findViewById(R.id.p1c13)

        p2_c1 = view.findViewById(R.id.p2c1)
        p2_c2 = view.findViewById(R.id.p2c2)
        p2_c3 = view.findViewById(R.id.p2c3)
        p2_c4 = view.findViewById(R.id.p2c4)
        p2_c5 = view.findViewById(R.id.p2c5)
        p2_c6 = view.findViewById(R.id.p2c6)
        p2_c7 = view.findViewById(R.id.p2c7)
        p2_c8 = view.findViewById(R.id.p2c8)
        p2_c9 = view.findViewById(R.id.p2c9)
        p2_c10 = view.findViewById(R.id.p2c10)
        p2_c11 = view.findViewById(R.id.p2c11)
        p2_c12 = view.findViewById(R.id.p2c12)
        p2_c13 = view.findViewById(R.id.p2c13)

        p3_c1 = view.findViewById(R.id.p3c1)
        p3_c2 = view.findViewById(R.id.p3c2)
        p3_c3 = view.findViewById(R.id.p3c3)
        p3_c4 = view.findViewById(R.id.p3c4)
        p3_c5 = view.findViewById(R.id.p3c5)
        p3_c6 = view.findViewById(R.id.p3c6)
        p3_c7 = view.findViewById(R.id.p3c7)
        p3_c8 = view.findViewById(R.id.p3c8)
        p3_c9 = view.findViewById(R.id.p3c9)
        p3_c10 = view.findViewById(R.id.p3c10)
        p3_c11 = view.findViewById(R.id.p3c11)
        p3_c12 = view.findViewById(R.id.p3c12)
        p3_c13 = view.findViewById(R.id.p3c13)

        p4_c1 = view.findViewById(R.id.p4c1)
        p4_c2 = view.findViewById(R.id.p4c2)
        p4_c3 = view.findViewById(R.id.p4c3)
        p4_c4 = view.findViewById(R.id.p4c4)
        p4_c5 = view.findViewById(R.id.p4c5)
        p4_c6 = view.findViewById(R.id.p4c6)
        p4_c7 = view.findViewById(R.id.p4c7)
        p4_c8 = view.findViewById(R.id.p4c8)
        p4_c9 = view.findViewById(R.id.p4c9)
        p4_c10 = view.findViewById(R.id.p4c10)
        p4_c11 = view.findViewById(R.id.p4c11)
        p4_c12 = view.findViewById(R.id.p4c12)
        p4_c13 = view.findViewById(R.id.p4c13)

        p5_c1 = view.findViewById(R.id.p5c1)
        p5_c2 = view.findViewById(R.id.p5c2)
        p5_c3 = view.findViewById(R.id.p5c3)
        p5_c4 = view.findViewById(R.id.p5c4)
        p5_c5 = view.findViewById(R.id.p5c5)
        p5_c6 = view.findViewById(R.id.p5c6)
        p5_c7 = view.findViewById(R.id.p5c7)
        p5_c8 = view.findViewById(R.id.p5c8)
        p5_c9 = view.findViewById(R.id.p5c9)
        p5_c10 = view.findViewById(R.id.p5c10)
        p5_c11 = view.findViewById(R.id.p5c11)
        p5_c12 = view.findViewById(R.id.p5c12)
        p5_c13 = view.findViewById(R.id.p5c13)

        p6_c1 = view.findViewById(R.id.p6c1)
        p6_c2 = view.findViewById(R.id.p6c2)
        p6_c3 = view.findViewById(R.id.p6c3)
        p6_c4 = view.findViewById(R.id.p6c4)
        p6_c5 = view.findViewById(R.id.p6c5)
        p6_c6 = view.findViewById(R.id.p6c6)
        p6_c7 = view.findViewById(R.id.p6c7)
        p6_c8 = view.findViewById(R.id.p6c8)
        p6_c9 = view.findViewById(R.id.p6c9)
        p6_c10 = view.findViewById(R.id.p6c10)
        p6_c11 = view.findViewById(R.id.p6c11)
        p6_c12 = view.findViewById(R.id.p6c12)
        p6_c13 = view.findViewById(R.id.p6c13)

        p7_c1 = view.findViewById(R.id.p7c1)
        p7_c2 = view.findViewById(R.id.p7c2)
        p7_c3 = view.findViewById(R.id.p7c3)
        p7_c4 = view.findViewById(R.id.p7c4)
        p7_c5 = view.findViewById(R.id.p7c5)
        p7_c6 = view.findViewById(R.id.p7c6)
        p7_c7 = view.findViewById(R.id.p7c7)
        p7_c8 = view.findViewById(R.id.p7c8)
        p7_c9 = view.findViewById(R.id.p7c9)
        p7_c10 = view.findViewById(R.id.p7c10)
        p7_c11 = view.findViewById(R.id.p7c11)
        p7_c12 = view.findViewById(R.id.p7c12)
        p7_c13 = view.findViewById(R.id.p7c13)

        p8_c1 = view.findViewById(R.id.p8c1)
        p8_c2 = view.findViewById(R.id.p8c2)
        p8_c3 = view.findViewById(R.id.p8c3)
        p8_c4 = view.findViewById(R.id.p8c4)
        p8_c5 = view.findViewById(R.id.p8c5)
        p8_c6 = view.findViewById(R.id.p8c6)
        p8_c7 = view.findViewById(R.id.p8c7)
        p8_c8 = view.findViewById(R.id.p8c8)
        p8_c9 = view.findViewById(R.id.p8c9)
        p8_c10 = view.findViewById(R.id.p8c10)
        p8_c11 = view.findViewById(R.id.p8c11)
        p8_c12 = view.findViewById(R.id.p8c12)
        p8_c13 = view.findViewById(R.id.p8c13)

        p9_c1 = view.findViewById(R.id.p9c1)
        p9_c2 = view.findViewById(R.id.p9c2)
        p9_c3 = view.findViewById(R.id.p9c3)
        p9_c4 = view.findViewById(R.id.p9c4)
        p9_c5 = view.findViewById(R.id.p9c5)
        p9_c6 = view.findViewById(R.id.p9c6)
        p9_c7 = view.findViewById(R.id.p9c7)
        p9_c8 = view.findViewById(R.id.p9c8)
        p9_c9 = view.findViewById(R.id.p9c9)
        p9_c10 = view.findViewById(R.id.p9c10)
        p9_c11 = view.findViewById(R.id.p9c11)
        p9_c12 = view.findViewById(R.id.p9c12)
        p9_c13 = view.findViewById(R.id.p9c13)

        p10_c1 = view.findViewById(R.id.p10c1)
        p10_c2 = view.findViewById(R.id.p10c2)
        p10_c3 = view.findViewById(R.id.p10c3)
        p10_c4 = view.findViewById(R.id.p10c4)
        p10_c5 = view.findViewById(R.id.p10c5)
        p10_c6 = view.findViewById(R.id.p10c6)
        p10_c7 = view.findViewById(R.id.p10c7)
        p10_c8 = view.findViewById(R.id.p10c8)
        p10_c9 = view.findViewById(R.id.p10c9)
        p10_c10 = view.findViewById(R.id.p10c10)
        p10_c11 = view.findViewById(R.id.p10c11)
        p10_c12 = view.findViewById(R.id.p10c12)
        p10_c13 = view.findViewById(R.id.p10c13)

        splashFragment = view.findViewById(R.id.splash_fragment)

        return view
    }

    override fun onStart() {
        super.onStart()

        Log.i("Ciclo GameFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("Ciclo GameFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Ciclo GameFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Ciclo GameFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("Ciclo GameFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Ciclo GameFragment", "onDestroy")
    }

    public fun alterLabel() {
        userName.text = "MUDOU O NOME"
    }

    private fun getDeck() {
        val BASE_URL = "https://deckofcardsapi.com"
        val serviceClient = Api.getRetrofitInstance(BASE_URL)
        val endpoint = serviceClient.create(Endpoint::class.java)

        when(qtdNaipes) {
            1 -> {
                endpoint.getDeckOneNaipe().enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        var data = response.body()
                        Log.i("RESPOSTA", data.toString())
                        deckId = data?.get("deck_id").toString()
                        deckId = deckId.split('"')[1]
                        loadCards()
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            2 -> {
                endpoint.getDeckTwoNaipes().enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        var data = response.body()
                        Log.i("RESPOSTA", data.toString())
                        deckId = data?.get("deck_id").toString()
                        deckId = deckId.split('"')[1]
                        loadCards()
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            else -> {
                endpoint.getDeckFourNaipes().enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        var data = response.body()
                        Log.i("RESPOSTA", data.toString())
                        deckId = data?.get("deck_id").toString()
                        deckId = deckId.split('"')[1]
                        loadCards()
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }
        }

    }

    private fun distributeCards(IdDeck: String, numberCards: Int, stack: MutableList<Card>, NumberStack: Int = 0) {
        val BASE_URL = "https://deckofcardsapi.com"
        val serviceClient = Api.getRetrofitInstance(BASE_URL)
        val endpoint = serviceClient.create(Endpoint::class.java)
        lateinit var data: JsonObject

        when(numberCards) {
            5 -> {
                endpoint.distributeFiveCards(IdDeck).enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        data = response.body()!!
                        Log.i("RESPOSTA", data.toString())
                        getCardsToStacks(data, stack, NumberStack)
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            6 -> {
                endpoint.distributeSixCards(IdDeck).enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        data = response.body()!!
                        Log.i("RESPOSTA", data.toString())
                        getCardsToStacks(data, stack, NumberStack)
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            else -> {
                endpoint.distributeTenCards(IdDeck).enqueue(object: Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        data = response.body()!!
                        // Log.i("RESPOSTA", data.toString())
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }
        }
    }

    fun getCardsToStacks(data: JsonObject, stack: MutableList<Card>, NumberStack: Int) {
        var gson = Gson()
        var d = gson.fromJson(data, CardModel::class.java)

        if(NumberStack == 1) {
            Log.i("PASSEI AQUI", "passei")
        }

        d.cards.forEach {
            var code = it.get("code").toString()
            code = code.split('"')[1]
            var show = true
            var value = it.get("value").toString()
            var suit = it.get("suit").toString()
            stack?.add(Card(code, show, value, suit))
        }

        when(NumberStack) {
            1 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                stack[4].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p1_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p1_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p1_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p1_c4)
                Glide.with(this).load(stack[4].getImageBack()).into(p1_c5)
                Glide.with(this).load(stack[5].getImageUrl(stack[5].getCodeC())).into(p1_c6)

            }

            2-> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                stack[4].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p2_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p2_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p2_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p2_c4)
                Glide.with(this).load(stack[4].getImageBack()).into(p2_c5)
                Glide.with(this).load(stack[5].getImageUrl(stack[5].getCodeC())).into(p2_c6)
            }

            3 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                stack[4].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p3_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p3_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p3_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p3_c4)
                Glide.with(this).load(stack[4].getImageBack()).into(p3_c5)
                Glide.with(this).load(stack[5].getImageUrl(stack[5].getCodeC())).into(p3_c6)
            }

            4 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                stack[4].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p4_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p4_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p4_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p4_c4)
                Glide.with(this).load(stack[4].getImageBack()).into(p4_c5)
                Glide.with(this).load(stack[5].getImageUrl(stack[5].getCodeC())).into(p4_c6)
            }

            5 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p5_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p5_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p5_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p5_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p5_c5)
            }

            6 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p6_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p6_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p6_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p6_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p6_c5)
            }

            7 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p7_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p7_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p7_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p7_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p7_c5)
            }

            8 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p8_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p8_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p8_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p8_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p8_c5)
            }

            9 -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p9_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p9_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p9_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p9_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p9_c5)
            }

            else -> {
                stack[0].setShow(false)
                stack[1].setShow(false)
                stack[2].setShow(false)
                stack[3].setShow(false)
                Glide.with(this).load(stack[0].getImageBack()).into(p10_c1)
                Glide.with(this).load(stack[1].getImageBack()).into(p10_c2)
                Glide.with(this).load(stack[2].getImageBack()).into(p10_c3)
                Glide.with(this).load(stack[3].getImageBack()).into(p10_c4)
                Glide.with(this).load(stack[4].getImageUrl(stack[4].getCodeC())).into(p10_c5)
            }
        }

    }

    fun loadCards() {
        distributeCards(deckId, 6, stackOneCards, 1)
        distributeCards(deckId, 6, stackTwoCards, 2)
        distributeCards(deckId, 6, stackTreeCards, 3)
        distributeCards(deckId, 6, stackFourCards, 4)
        distributeCards(deckId, 5, stackFiveCards, 5)
        distributeCards(deckId, 5, stackSixCards, 6)
        distributeCards(deckId, 5, stackSevenCards, 7)
        distributeCards(deckId, 5, stackEightCards, 8)
        distributeCards(deckId, 5, stackNineCards, 9)
        distributeCards(deckId, 5, stackTenCards, 10)

        Handler(Looper.getMainLooper()).postDelayed({
            splashFragment.visibility = View.INVISIBLE }, 6000)
    }
}