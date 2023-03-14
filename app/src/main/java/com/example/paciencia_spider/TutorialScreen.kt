package com.example.paciencia_spider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Tutorial e Regras"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_screen)
    }
}