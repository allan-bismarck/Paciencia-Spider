package com.example.paciencia_spider

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
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

    private lateinit var deckId: String

    private var qtdNaipes by Delegates.notNull<Int>()

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
           distributeCards(deckId)
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
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }
        }
    }

    private fun distributeCards(IdDeck: String) {
        val BASE_URL = "https://deckofcardsapi.com"
        val serviceClient = Api.getRetrofitInstance(BASE_URL)
        val endpoint = serviceClient.create(Endpoint::class.java)

        endpoint.distributeCards(IdDeck).enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = response.body()
                Log.i("RESPOSTA", data.toString())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
            }

        })
    }
}