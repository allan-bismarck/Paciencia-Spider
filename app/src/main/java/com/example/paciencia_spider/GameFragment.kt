package com.example.paciencia_spider

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates
import kotlin.reflect.typeOf

class GameFragment : Fragment() {
    private var URL_IMAGES = "https://deckofcardsapi.com/static/img/"

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

    private lateinit var p1: FrameLayout
    private lateinit var p2: FrameLayout
    private lateinit var p3: FrameLayout
    private lateinit var p4: FrameLayout
    private lateinit var p5: FrameLayout
    private lateinit var p6: FrameLayout
    private lateinit var p7: FrameLayout
    private lateinit var p8: FrameLayout
    private lateinit var p9: FrameLayout
    private lateinit var p10: FrameLayout

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

    private var deckId: String = ""

    private var qtdNaipes by Delegates.notNull<Int>()

    private lateinit var splashFragment: FrameLayout

    private var numberClick: Int = 0

    private var numberCardsDeck: Int = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        qtdNaipes = arguments?.getInt("qtdNaipes")!!

        getDeck()

        Log.i("Ciclo GameFragment", "onCreate")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game, container, false)

        deck = view.findViewById(R.id.deck)
        deck.setOnClickListener {
            Log.i("avaliable", avaliableSizeOfStacks().toString())
            if(avaliableSizeOfStacks()) {
                CoroutineScope(Dispatchers.Main).launch {
                    var cardFalse = mutableListOf<Card>(Card("", false, 0, ""))
                    distributeCards(deckId, 10, cardFalse)
                    animationDeck()
                }
            } else {
                Toast.makeText(this.context,"Uma das pilhas atingiu 15 cartas",Toast.LENGTH_SHORT).show()
            }
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

        p1 = view.findViewById(R.id.p1)
        p2 = view.findViewById(R.id.p2)
        p3 = view.findViewById(R.id.p3)
        p4 = view.findViewById(R.id.p4)
        p5 = view.findViewById(R.id.p5)
        p6 = view.findViewById(R.id.p6)
        p7 = view.findViewById(R.id.p7)
        p8 = view.findViewById(R.id.p8)
        p9 = view.findViewById(R.id.p9)
        p10 = view.findViewById(R.id.p10)

        p1_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p1_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p2_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p2_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p3_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p3_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p4_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p4_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p5_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p5_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p6_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p6_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p7_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p7_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p8_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p8_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p9_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p9_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

        p10_c1.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c2.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c3.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c4.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c5.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c6.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c7.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c8.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c9.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c10.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c11.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c12.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }
        p10_c13.setOnClickListener {
            playWithDoubleClick(it as ImageView)
        }

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

    private fun getDeck() {
        val BASE_URL = "https://deckofcardsapi.com"
        val serviceClient = Api.getRetrofitInstance(BASE_URL)
        val endpoint = serviceClient.create(Endpoint::class.java)
        lateinit var data: JsonObject

        if(deckId.isEmpty()) {
            when (qtdNaipes) {
                1 -> {
                    endpoint.getDeckOneNaipe().enqueue(object : Callback<JsonObject> {
                        override fun onResponse(
                            call: Call<JsonObject>,
                            response: Response<JsonObject>
                        ) {
                            data = response.body()!!
                            deckId = data?.get("deck_id").toString()
                            deckId = deckId.split('"')[1]
                            endpoint.shuffleDeck(deckId)
                            loadCards()
                        }

                        override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                            Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                        }

                    })
                }

                2 -> {
                    endpoint.getDeckTwoNaipes().enqueue(object : Callback<JsonObject> {
                        override fun onResponse(
                            call: Call<JsonObject>,
                            response: Response<JsonObject>
                        ) {
                            data = response.body()!!
                            deckId = data?.get("deck_id").toString()
                            deckId = deckId.split('"')[1]
                            endpoint.shuffleDeck(deckId)
                            loadCards()
                        }

                        override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                            Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                        }

                    })
                }

                else -> {
                    endpoint.getDeckFourNaipes().enqueue(object : Callback<JsonObject> {
                        override fun onResponse(
                            call: Call<JsonObject>,
                            response: Response<JsonObject>
                        ) {
                            data = response.body()!!
                            deckId = data?.get("deck_id").toString()
                            deckId = deckId.split('"')[1]
                            endpoint.shuffleDeck(deckId)
                            loadCards()
                        }

                        override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                            Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                        }

                    })
                }
            }
        } else {
            endpoint.returnDeck(deckId)
            endpoint.shuffleDeck(deckId)
            loadCards()
        }

    }

    private suspend fun distributeCards(IdDeck: String, numberCards: Int, stack: MutableList<Card>, NumberStack: Int = 0) {
        delay(150)
        val BASE_URL = "https://deckofcardsapi.com"
        val serviceClient = Api.getRetrofitInstance(BASE_URL)
        val endpoint = serviceClient.create(Endpoint::class.java)
        lateinit var data: JsonObject

        endpoint.shuffleDeckWithRemaining(IdDeck)

        when(numberCards) {
            5 -> {
                endpoint.distributeFiveCards(IdDeck).enqueue(object: Callback<JsonObject> {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        data = response.body()!!
                        getCardsToStacks(data, stack)
                        loadCardImagesStacks(stack, NumberStack)
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            6 -> {
                endpoint.distributeSixCards(IdDeck).enqueue(object: Callback<JsonObject> {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        data = response.body()!!
                        getCardsToStacks(data, stack)
                        loadCardImagesStacks(stack, NumberStack)
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }

            else -> {
                endpoint.distributeTenCards(IdDeck).enqueue(object : Callback<JsonObject> {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onResponse(
                        call: Call<JsonObject>,
                        response: Response<JsonObject>
                    ) {
                        data = response.body()!!
                        getCardsFromDeck(data)
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.i("Falha", "Não foi possível obter nenhuma resposta da API")
                    }

                })
            }
        }

    }

    fun getCardsToStacks(data: JsonObject, stack: MutableList<Card>) {
        var gson = Gson()
        var d = gson.fromJson(data, CardModel::class.java)

        d.cards.forEach {
            var code = it.get("code").toString()
            code = code.split('"')[1]
            var show = false
            var charValue = it.get("value").toString()
            var value = mapValueToInt(charValue)
            var suit = it.get("suit").toString()
            stack?.add(Card(code, show, value, suit))
        }
    }

    private fun mapValueToInt(charValue: String): Int {
        var char = charValue.split('"')[1]
        return when(char) {
            "ACE" -> 1
            "2" -> 2
            "3" -> 3
            "4" -> 4
            "5" -> 5
            "6" -> 6
            "7" -> 7
            "8" -> 8
            "9" -> 9
            "10" -> 10
            "JACK" -> 11
            "QUEEN" -> 12
            "KING" -> 13
            else -> 0
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun loadCardImagesStacks(stack: MutableList<Card>, NumberStack: Int) {

        var glideCtx = Glide.with(this)

        if(stack.size >=1 ) {
            stack[stack.lastIndex].setShow(true)
        }

        stack.indices.forEach {
            var imgview = identifyImgView(NumberStack, it+1)
            if(stack[it].getShow() == false) {
                glideCtx.load(stack[it].getImageBack()).into(imgview!!)
            } else {
                glideCtx.load(stack[it].getImageUrl(stack[it].getCodeC())).into(imgview!!)
            }
        }

        checkAvaiableCards()
        numberCardsDeck = 5
    }

    @SuppressLint("ResourceAsColor")
    fun loadCards() {
        CoroutineScope(Dispatchers.Main).launch {
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
        }

        Handler(Looper.getMainLooper()).postDelayed({
            splashFragment.visibility = View.INVISIBLE }, 7000)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun getCardsFromDeck(data: JsonObject) {
        var gson = Gson()
        var d = gson.fromJson(data, CardModel::class.java)
        var cards = mutableListOf<Card>()

        if(d.cards.size >= 10) {
            d.cards.forEach {
                var code = it.get("code").toString()
                code = code.split('"')[1]
                var show = true
                var charValue = it.get("value").toString()
                var value = mapValueToInt(charValue)
                var suit = it.get("suit").toString()
                cards.add(Card(code, show, value, suit))
            }

            stackOneCards.add(cards[0])
            loadCardsFromDeck(stackOneCards, 1)

            stackTwoCards.add(cards[1])
            loadCardsFromDeck(stackTwoCards, 2)

            stackTreeCards.add(cards[2])
            loadCardsFromDeck(stackTreeCards, 3)

            stackFourCards.add(cards[3])
            loadCardsFromDeck(stackFourCards, 4)

            stackFiveCards.add(cards[4])
            loadCardsFromDeck(stackFiveCards, 5)

            stackSixCards.add(cards[5])
            loadCardsFromDeck(stackSixCards, 6)

            stackSevenCards.add(cards[6])
            loadCardsFromDeck(stackSevenCards, 7)

            stackEightCards.add(cards[7])
            loadCardsFromDeck(stackEightCards, 8)

            stackNineCards.add(cards[8])
            loadCardsFromDeck(stackNineCards, 9)

            stackTenCards.add(cards[9])
            loadCardsFromDeck(stackTenCards, 10)
        }

        if(numberCardsDeck > 0) {
            numberCardsDeck--
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun loadCardsFromDeck(stack: MutableList<Card>, numberStack: Int) {
        var imgView: ImageView?
        var size = stack.size
        imgView = identifyImgView(numberStack, size)
        if(imgView != null) {
            Glide.with(this).load(stack[size - 1].getImageUrl(stack[size - 1].getCodeC()))
                .into(imgView)
        }

        checkAvaiableCards()
    }

    private fun identifyImgView(numberStack: Int, position: Int): ImageView? {
        var imgView: ImageView? = null
        when(numberStack) {
            1 -> {
                imgView = when(position) {
                    1 -> p1_c1
                    2 -> p1_c2
                    3 -> p1_c3
                    4 -> p1_c4
                    5 -> p1_c5
                    6 -> p1_c6
                    7 -> p1_c7
                    8 -> p1_c8
                    9 -> p1_c9
                    10 -> p1_c10
                    11 -> p1_c11
                    12 -> p1_c12
                    13 -> p1_c13
                    else -> null
                }
            }

            2 -> {
                imgView = when(position) {
                    1 -> p2_c1
                    2 -> p2_c2
                    3 -> p2_c3
                    4 -> p2_c4
                    5 -> p2_c5
                    6 -> p2_c6
                    7 -> p2_c7
                    8 -> p2_c8
                    9 -> p2_c9
                    10 -> p2_c10
                    11 -> p2_c11
                    12 -> p2_c12
                    13 -> p2_c13
                    else -> null
                }
            }

            3 -> {
                imgView = when(position) {
                    1 -> p3_c1
                    2 -> p3_c2
                    3 -> p3_c3
                    4 -> p3_c4
                    5 -> p3_c5
                    6 -> p3_c6
                    7 -> p3_c7
                    8 -> p3_c8
                    9 -> p3_c9
                    10 -> p3_c10
                    11 -> p3_c11
                    12 -> p3_c12
                    13 -> p3_c13
                    else -> null
                }
            }

            4 -> {
                imgView = when(position) {
                    1 -> p4_c1
                    2 -> p4_c2
                    3 -> p4_c3
                    4 -> p4_c4
                    5 -> p4_c5
                    6 -> p4_c6
                    7 -> p4_c7
                    8 -> p4_c8
                    9 -> p4_c9
                    10 -> p4_c10
                    11 -> p4_c11
                    12 -> p4_c12
                    13 -> p4_c13
                    else -> null
                }
            }

            5 -> {
                imgView = when(position) {
                    1 -> p5_c1
                    2 -> p5_c2
                    3 -> p5_c3
                    4 -> p5_c4
                    5 -> p5_c5
                    6 -> p5_c6
                    7 -> p5_c7
                    8 -> p5_c8
                    9 -> p5_c9
                    10 -> p5_c10
                    11 -> p5_c11
                    12 -> p5_c12
                    13 -> p5_c13
                    else -> null
                }
            }

            6 -> {
                imgView = when(position) {
                    1 -> p6_c1
                    2 -> p6_c2
                    3 -> p6_c3
                    4 -> p6_c4
                    5 -> p6_c5
                    6 -> p6_c6
                    7 -> p6_c7
                    8 -> p6_c8
                    9 -> p6_c9
                    10 -> p6_c10
                    11 -> p6_c11
                    12 -> p6_c12
                    13 -> p6_c13
                    else -> null
                }
            }

            7 -> {
                imgView = when(position) {
                    1 -> p7_c1
                    2 -> p7_c2
                    3 -> p7_c3
                    4 -> p7_c4
                    5 -> p7_c5
                    6 -> p7_c6
                    7 -> p7_c7
                    8 -> p7_c8
                    9 -> p7_c9
                    10 -> p7_c10
                    11 -> p7_c11
                    12 -> p7_c12
                    13 -> p7_c13
                    else -> null
                }
            }

            8 -> {
                imgView = when(position) {
                    1 -> p8_c1
                    2 -> p8_c2
                    3 -> p8_c3
                    4 -> p8_c4
                    5 -> p8_c5
                    6 -> p8_c6
                    7 -> p8_c7
                    8 -> p8_c8
                    9 -> p8_c9
                    10 -> p8_c10
                    11 -> p8_c11
                    12 -> p8_c12
                    13 -> p8_c13
                    else -> null
                }
            }

            9 -> {
                imgView = when(position) {
                    1 -> p9_c1
                    2 -> p9_c2
                    3 -> p9_c3
                    4 -> p9_c4
                    5 -> p9_c5
                    6 -> p9_c6
                    7 -> p9_c7
                    8 -> p9_c8
                    9 -> p9_c9
                    10 -> p9_c10
                    11 -> p9_c11
                    12 -> p9_c12
                    13 -> p9_c13
                    else -> null
                }
            }

            10 -> {
                imgView = when(position) {
                    1 -> p10_c1
                    2 -> p10_c2
                    3 -> p10_c3
                    4 -> p10_c4
                    5 -> p10_c5
                    6 -> p10_c6
                    7 -> p10_c7
                    8 -> p10_c8
                    9 -> p10_c9
                    10 -> p10_c10
                    11 -> p10_c11
                    12 -> p10_c12
                    13 -> p10_c13
                    else -> null
                }
            }
        }
        return imgView
    }

    private fun avaliableSizeOfStacks(): Boolean {
        return !(
                stackOneCards.size == 13 ||
                stackTwoCards.size  == 13 ||
                stackTreeCards.size  == 13 ||
                stackFourCards.size  == 13 ||
                stackFiveCards.size == 13 ||
                stackSixCards.size  == 13 ||
                stackSevenCards.size == 13 ||
                stackEightCards.size == 13 ||
                stackNineCards.size == 13 ||
                stackTenCards.size  == 13
                )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkAvaiableCards() {
        avaiableCardsOnStack(stackOneCards,  1)
        avaiableCardsOnStack(stackTwoCards,  2)
        avaiableCardsOnStack(stackTreeCards, 3)
        avaiableCardsOnStack(stackFourCards, 4)
        avaiableCardsOnStack(stackFiveCards, 5)
        avaiableCardsOnStack(stackSixCards,  6)
        avaiableCardsOnStack(stackSevenCards, 7)
        avaiableCardsOnStack(stackEightCards, 8)
        avaiableCardsOnStack(stackNineCards, 9)
        avaiableCardsOnStack(stackTenCards,  10)
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun avaiableCardsOnStack(stack: MutableList<Card>, numberStack: Int) {

        if(stack.isNotEmpty()) {

            stack[stack.lastIndex].setAvaiable(true)
            stack[stack.lastIndex].setShow(true)

            stack.indices.forEach {
                if(it != stack.lastIndex) {
                    stack[it].setAvaiable(false)
                }
            }

            stack.indices.reversed().forEach {
                if (it > 0) {
                    var imgView = identifyImgView(numberStack, it)
                    if (((stack[it].getValue()) == stack[it-1].getValue()-1) && (stack[it].getSuit() == stack[it-1].getSuit())) {
                        stack[it - 1].setAvaiable(true)
                        imgView?.isClickable = true
                    }
                }
            }

            stack.indices.reversed().forEach {
                if(it != 0) {
                    if (!stack[it].getAvaiable()) {
                        stack[it-1].setAvaiable(false)
                    }
                }
            }

            stack.indices.forEach {
                var imgView = identifyImgView(numberStack, it+1)
                if(!stack[it].getAvaiable() || stack[it].getShow() == false) {
                    imgView?.foreground = ColorDrawable(R.color.black_transparent)
                    imgView?.isClickable = false
                } else {
                    imgView?.foreground = ColorDrawable(0)
                    imgView?.isClickable = true
                    if(stack[it].getShow() == true) {
                        Glide.with(this).load(stack[it].getImageUrl(stack[it].getCodeC())).into(imgView!!)
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun playWithDoubleClick(imgview: ImageView) {
        if(imgview.drawable != null ) {
            var stack = identifyStack(imgview)
            var numberStack = identifyNumberStack(imgview)
            var position = identifyPosition(imgview)
            numberClick++
            Handler(Looper.getMainLooper()).postDelayed({
                if (numberClick == 1) {
                    Log.i("1 click", "stack: $stack, position: $position")
                    var moveElements = selectCards(stack, position)
                    applyModifierInStack(::insertCardsSelecteds, moveElements, numberStack!!)
                    avaiableCardsOnStack(stack!!,numberStack)
                } else if (numberClick == 2) {
                    Log.i("2 clicks", "stack: $stack, position: $position")
                    var moveElements = selectCards(stack, position)
                    applyModifierInStack(::removeCardsSelecteds, moveElements, numberStack!!)
                    avaiableCardsOnStack(stack!!,numberStack)
                }

                numberClick = 0
            }, 300)
        }
    }

    private fun identifyStack(imgView: ImageView): MutableList<Card>? {
        when(imgView) {
            p1_c1 -> return stackOneCards
            p1_c2 -> return stackOneCards
            p1_c3 -> return stackOneCards
            p1_c4 -> return stackOneCards
            p1_c5 -> return stackOneCards
            p1_c6 -> return stackOneCards
            p1_c7 -> return stackOneCards
            p1_c8 -> return stackOneCards
            p1_c9 -> return stackOneCards
            p1_c10 -> return stackOneCards
            p1_c11 -> return stackOneCards
            p1_c12 -> return stackOneCards
            p1_c13 -> return stackOneCards

            p2_c1 -> return stackTwoCards
            p2_c2 -> return stackTwoCards
            p2_c3 -> return stackTwoCards
            p2_c4 -> return stackTwoCards
            p2_c5 -> return stackTwoCards
            p2_c6 -> return stackTwoCards
            p2_c7 -> return stackTwoCards
            p2_c8 -> return stackTwoCards
            p2_c9 -> return stackTwoCards
            p2_c10 -> return stackTwoCards
            p2_c11 -> return stackTwoCards
            p2_c12 -> return stackTwoCards
            p2_c13 -> return stackTwoCards

            p3_c1 -> return stackTreeCards
            p3_c2 -> return stackTreeCards
            p3_c3 -> return stackTreeCards
            p3_c4 -> return stackTreeCards
            p3_c5 -> return stackTreeCards
            p3_c6 -> return stackTreeCards
            p3_c7 -> return stackTreeCards
            p3_c8 -> return stackTreeCards
            p3_c9 -> return stackTreeCards
            p3_c10 -> return stackTreeCards
            p3_c11 -> return stackTreeCards
            p3_c12 -> return stackTreeCards
            p3_c13 -> return stackTreeCards

            p4_c1 -> return stackFourCards
            p4_c2 -> return stackFourCards
            p4_c3 -> return stackFourCards
            p4_c4 -> return stackFourCards
            p4_c5 -> return stackFourCards
            p4_c6 -> return stackFourCards
            p4_c7 -> return stackFourCards
            p4_c8 -> return stackFourCards
            p4_c9 -> return stackFourCards
            p4_c10 -> return stackFourCards
            p4_c11 -> return stackFourCards
            p4_c12 -> return stackFourCards
            p4_c13 -> return stackFourCards

            p5_c1 -> return stackFiveCards
            p5_c2 -> return stackFiveCards
            p5_c3 -> return stackFiveCards
            p5_c4 -> return stackFiveCards
            p5_c5 -> return stackFiveCards
            p5_c6 -> return stackFiveCards
            p5_c7 -> return stackFiveCards
            p5_c8 -> return stackFiveCards
            p5_c9 -> return stackFiveCards
            p5_c10 -> return stackFiveCards
            p5_c11 -> return stackFiveCards
            p5_c12 -> return stackFiveCards
            p5_c13 -> return stackFiveCards

            p6_c1 -> return stackSixCards
            p6_c2 -> return stackSixCards
            p6_c3 -> return stackSixCards
            p6_c4 -> return stackSixCards
            p6_c5 -> return stackSixCards
            p6_c6 -> return stackSixCards
            p6_c7 -> return stackSixCards
            p6_c8 -> return stackSixCards
            p6_c9 -> return stackSixCards
            p6_c10 -> return stackSixCards
            p6_c11 -> return stackSixCards
            p6_c12 -> return stackSixCards
            p6_c13 -> return stackSixCards

            p7_c1 -> return stackSevenCards
            p7_c2 -> return stackSevenCards
            p7_c3 -> return stackSevenCards
            p7_c4 -> return stackSevenCards
            p7_c5 -> return stackSevenCards
            p7_c6 -> return stackSevenCards
            p7_c7 -> return stackSevenCards
            p7_c8 -> return stackSevenCards
            p7_c9 -> return stackSevenCards
            p7_c10 -> return stackSevenCards
            p7_c11 -> return stackSevenCards
            p7_c12 -> return stackSevenCards
            p7_c13 -> return stackSevenCards

            p8_c1 -> return stackEightCards
            p8_c2 -> return stackEightCards
            p8_c3 -> return stackEightCards
            p8_c4 -> return stackEightCards
            p8_c5 -> return stackEightCards
            p8_c6 -> return stackEightCards
            p8_c7 -> return stackEightCards
            p8_c8 -> return stackEightCards
            p8_c9 -> return stackEightCards
            p8_c10 -> return stackEightCards
            p8_c11 -> return stackEightCards
            p8_c12 -> return stackEightCards
            p8_c13 -> return stackEightCards

            p9_c1 -> return stackNineCards
            p9_c2 -> return stackNineCards
            p9_c3 -> return stackNineCards
            p9_c4 -> return stackNineCards
            p9_c5 -> return stackNineCards
            p9_c6 -> return stackNineCards
            p9_c7 -> return stackNineCards
            p9_c8 -> return stackNineCards
            p9_c9 -> return stackNineCards
            p9_c10 -> return stackNineCards
            p9_c11 -> return stackNineCards
            p9_c12 -> return stackNineCards
            p9_c13 -> return stackNineCards

            p10_c1 -> return stackTenCards
            p10_c2 -> return stackTenCards
            p10_c3 -> return stackTenCards
            p10_c4 -> return stackTenCards
            p10_c5 -> return stackTenCards
            p10_c6 -> return stackTenCards
            p10_c7 -> return stackTenCards
            p10_c8 -> return stackTenCards
            p10_c9 -> return stackTenCards
            p10_c10 -> return stackTenCards
            p10_c11 -> return stackTenCards
            p10_c12 -> return stackTenCards
            p10_c13 -> return stackTenCards

            else -> return null
        }
    }

    private fun identifyPosition(imgView: ImageView): Int? {
        when(imgView) {
            p1_c1 -> return 0
            p1_c2 -> return 1
            p1_c3 -> return 2
            p1_c4 -> return 3
            p1_c5 -> return 4
            p1_c6 -> return 5
            p1_c7 -> return 6
            p1_c8 -> return 7
            p1_c9 -> return 8
            p1_c10 -> return 9
            p1_c11 -> return 10
            p1_c12 -> return 11
            p1_c13 -> return 12

            p2_c1 -> return 0
            p2_c2 -> return 1
            p2_c3 -> return 2
            p2_c4 -> return 3
            p2_c5 -> return 4
            p2_c6 -> return 5
            p2_c7 -> return 6
            p2_c8 -> return 7
            p2_c9 -> return 8
            p2_c10 -> return 9
            p2_c11 -> return 10
            p2_c12 -> return 11
            p2_c13 -> return 12

            p3_c1 -> return 0
            p3_c2 -> return 1
            p3_c3 -> return 2
            p3_c4 -> return 3
            p3_c5 -> return 4
            p3_c6 -> return 5
            p3_c7 -> return 6
            p3_c8 -> return 7
            p3_c9 -> return 8
            p3_c10 -> return 9
            p3_c11 -> return 10
            p3_c12 -> return 11
            p3_c13 -> return 12

            p4_c1 -> return 0
            p4_c2 -> return 1
            p4_c3 -> return 2
            p4_c4 -> return 3
            p4_c5 -> return 4
            p4_c6 -> return 5
            p4_c7 -> return 6
            p4_c8 -> return 7
            p4_c9 -> return 8
            p4_c10 -> return 9
            p4_c11 -> return 10
            p4_c12 -> return 11
            p4_c13 -> return 12

            p5_c1 -> return 0
            p5_c2 -> return 1
            p5_c3 -> return 2
            p5_c4 -> return 3
            p5_c5 -> return 4
            p5_c6 -> return 5
            p5_c7 -> return 6
            p5_c8 -> return 7
            p5_c9 -> return 8
            p5_c10 -> return 9
            p5_c11 -> return 10
            p5_c12 -> return 11
            p5_c13 -> return 12

            p6_c1 -> return 0
            p6_c2 -> return 1
            p6_c3 -> return 2
            p6_c4 -> return 3
            p6_c5 -> return 4
            p6_c6 -> return 5
            p6_c7 -> return 6
            p6_c8 -> return 7
            p6_c9 -> return 8
            p6_c10 -> return 9
            p6_c11 -> return 10
            p6_c12 -> return 11
            p6_c13 -> return 12

            p7_c1 -> return 0
            p7_c2 -> return 1
            p7_c3 -> return 2
            p7_c4 -> return 3
            p7_c5 -> return 4
            p7_c6 -> return 5
            p7_c7 -> return 6
            p7_c8 -> return 7
            p7_c9 -> return 8
            p7_c10 -> return 9
            p7_c11 -> return 10
            p7_c12 -> return 11
            p7_c13 -> return 12

            p8_c1 -> return 0
            p8_c2 -> return 1
            p8_c3 -> return 2
            p8_c4 -> return 3
            p8_c5 -> return 4
            p8_c6 -> return 5
            p8_c7 -> return 6
            p8_c8 -> return 7
            p8_c9 -> return 8
            p8_c10 -> return 9
            p8_c11 -> return 10
            p8_c12 -> return 11
            p8_c13 -> return 12

            p9_c1 -> return 0
            p9_c2 -> return 1
            p9_c3 -> return 2
            p9_c4 -> return 3
            p9_c5 -> return 4
            p9_c6 -> return 5
            p9_c7 -> return 6
            p9_c8 -> return 7
            p9_c9 -> return 8
            p9_c10 -> return 9
            p9_c11 -> return 10
            p9_c12 -> return 11
            p9_c13 -> return 12

            p10_c1 -> return 0
            p10_c2 -> return 1
            p10_c3 -> return 2
            p10_c4 -> return 3
            p10_c5 -> return 4
            p10_c6 -> return 5
            p10_c7 -> return 6
            p10_c8 -> return 7
            p10_c9 -> return 8
            p10_c10 -> return 9
            p10_c11 -> return 10
            p10_c12 -> return 11
            p10_c13 -> return 12

            else -> return null
        }
    }

    private fun identifyNumberStack(imgView: ImageView): Int? {
        when(imgView) {
            p1_c1 -> return 1
            p1_c2 -> return 1
            p1_c3 -> return 1
            p1_c4 -> return 1
            p1_c5 -> return 1
            p1_c6 -> return 1
            p1_c7 -> return 1
            p1_c8 -> return 1
            p1_c9 -> return 1
            p1_c10 -> return 1
            p1_c11 -> return 1
            p1_c12 -> return 1
            p1_c13 -> return 1

            p2_c1 -> return 2
            p2_c2 -> return 2
            p2_c3 -> return 2
            p2_c4 -> return 2
            p2_c5 -> return 2
            p2_c6 -> return 2
            p2_c7 -> return 2
            p2_c8 -> return 2
            p2_c9 -> return 2
            p2_c10 -> return 2
            p2_c11 -> return 2
            p2_c12 -> return 2
            p2_c13 -> return 2

            p3_c1 -> return 3
            p3_c2 -> return 3
            p3_c3 -> return 3
            p3_c4 -> return 3
            p3_c5 -> return 3
            p3_c6 -> return 3
            p3_c7 -> return 3
            p3_c8 -> return 3
            p3_c9 -> return 3
            p3_c10 -> return 3
            p3_c11 -> return 3
            p3_c12 -> return 3
            p3_c13 -> return 3

            p4_c1 -> return 4
            p4_c2 -> return 4
            p4_c3 -> return 4
            p4_c4 -> return 4
            p4_c5 -> return 4
            p4_c6 -> return 4
            p4_c7 -> return 4
            p4_c8 -> return 4
            p4_c9 -> return 4
            p4_c10 -> return 4
            p4_c11 -> return 4
            p4_c12 -> return 4
            p4_c13 -> return 4

            p5_c1 -> return 5
            p5_c2 -> return 5
            p5_c3 -> return 5
            p5_c4 -> return 5
            p5_c5 -> return 5
            p5_c6 -> return 5
            p5_c7 -> return 5
            p5_c8 -> return 5
            p5_c9 -> return 5
            p5_c10 -> return 5
            p5_c11 -> return 5
            p5_c12 -> return 5
            p5_c13 -> return 5

            p6_c1 -> return 6
            p6_c2 -> return 6
            p6_c3 -> return 6
            p6_c4 -> return 6
            p6_c5 -> return 6
            p6_c6 -> return 6
            p6_c7 -> return 6
            p6_c8 -> return 6
            p6_c9 -> return 6
            p6_c10 -> return 6
            p6_c11 -> return 6
            p6_c12 -> return 6
            p6_c13 -> return 6

            p7_c1 -> return 7
            p7_c2 -> return 7
            p7_c3 -> return 7
            p7_c4 -> return 7
            p7_c5 -> return 7
            p7_c6 -> return 7
            p7_c7 -> return 7
            p7_c8 -> return 7
            p7_c9 -> return 7
            p7_c10 -> return 7
            p7_c11 -> return 7
            p7_c12 -> return 7
            p7_c13 -> return 7

            p8_c1 -> return 8
            p8_c2 -> return 8
            p8_c3 -> return 8
            p8_c4 -> return 8
            p8_c5 -> return 8
            p8_c6 -> return 8
            p8_c7 -> return 8
            p8_c8 -> return 8
            p8_c9 -> return 8
            p8_c10 -> return 8
            p8_c11 -> return 8
            p8_c12 -> return 8
            p8_c13 -> return 8

            p9_c1 -> return 9
            p9_c2 -> return 9
            p9_c3 -> return 9
            p9_c4 -> return 9
            p9_c5 -> return 9
            p9_c6 -> return 9
            p9_c7 -> return 9
            p9_c8 -> return 9
            p9_c9 -> return 9
            p9_c10 -> return 9
            p9_c11 -> return 9
            p9_c12 -> return 9
            p9_c13 -> return 9

            p10_c1 -> return 10
            p10_c2 -> return 10
            p10_c3 -> return 10
            p10_c4 -> return 10
            p10_c5 -> return 10
            p10_c6 -> return 10
            p10_c7 -> return 10
            p10_c8 -> return 10
            p10_c9 -> return 10
            p10_c10 -> return 10
            p10_c11 -> return 10
            p10_c12 -> return 10
            p10_c13 -> return 10

            else -> return null
        }
    }

    private fun animationDeck() {
        when(numberCardsDeck) {
            1 -> deck_c1.setImageResource(0)
            2 -> deck_c2.setImageResource(0)
            3 -> deck_c3.setImageResource(0)
            4 -> deck_c4.setImageResource(0)
            5 -> deck_c5.setImageResource(0)
        }
    }

    private fun selectCards(stack: MutableList<Card>?, position: Int?): MutableList<Card> {
        var moveElements = mutableListOf<Card>()
        if(stack?.lastIndex!! >= 0) {
            moveElements = stack.subList(position!!, stack.lastIndex+1)
            Log.i("moveElements", moveElements.size.toString())

            moveElements.forEach {
                Log.i("moveElementsValue", "${it.getValue()}")
            }
        }
        return moveElements
    }

    private fun applyModifierInStack(function: (MutableList<Card>, MutableList<Card>, Int) -> Unit, moveElements: MutableList<Card>, numberStack: Int) {
        when(numberStack) {
            1 -> function(stackOneCards, moveElements, numberStack)
            2 -> function(stackTwoCards, moveElements, numberStack)
            3 -> function(stackTreeCards, moveElements, numberStack)
            4 -> function(stackFourCards, moveElements, numberStack)
            5 -> function(stackFiveCards, moveElements, numberStack)
            6 -> function(stackSixCards, moveElements, numberStack)
            7 -> function(stackSevenCards, moveElements, numberStack)
            8 -> function(stackEightCards, moveElements, numberStack)
            9 -> function(stackNineCards, moveElements, numberStack)
            10 -> function(stackTenCards, moveElements, numberStack)
        }
    }

    private fun mapNumberStackToStackFrame(numberStack: Int): FrameLayout {
        return when(numberStack) {
            1 -> p1
            2 -> p2
            3 -> p3
            4 -> p4
            5 -> p5
            6 -> p6
            7 -> p7
            8 -> p8
            9 -> p9
            else -> p10
        }
    }

    private fun removeCardsSelecteds(stackOrigin: MutableList<Card>, moveElements: MutableList<Card>, numberStack: Int) {
        var p = mapNumberStackToStackFrame(numberStack)
        var count = 0
        var moveElementsSize = moveElements.size
        while(count != moveElementsSize) {
            var lastIndex = stackOrigin.lastIndex
            var img = p.getChildAt(lastIndex)
            Glide.with(this).load(0).into(img as ImageView)
            stackOrigin.removeLast()
            count++
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun insertCardsSelecteds(stackDestiny: MutableList<Card>, moveElements: MutableList<Card>, numberStack: Int) {
        var p = mapNumberStackToStackFrame(numberStack)
        var count = 0
        var moveElementsSize = moveElements.size
        var stackDestinySize = stackDestiny.size

        if((stackDestinySize + moveElementsSize) <= 13) {
            while(count != moveElementsSize) {
                var element = moveElements[count]
                Glide.with(this).load(element.getImageUrl(element.getCodeC())).into(p.getChildAt(stackDestinySize + count) as ImageView)
                count++
            }

            var moveCards = mutableListOf<Card>()

            moveElements.indices.forEach {
                var code = moveElements[it].getCodeC()
                Log.i("IT $it", "teste")
                var show = moveElements[it].getShow()
                var value = moveElements[it].getValue()
                var suit = moveElements[it].getSuit()
                var avaiable = moveElements[it].getAvaiable()
                var card = Card(code, show!!, value, suit, avaiable)
                moveCards.add(card)
            }
            stackDestiny.addAll(moveCards)
        }

        Log.i("Size updated insert", stackDestiny[stackDestiny.lastIndex].getValue().toString())
    }
}