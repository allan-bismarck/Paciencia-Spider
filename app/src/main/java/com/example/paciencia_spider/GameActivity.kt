package com.example.paciencia_spider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    private lateinit var player: TextView
    private lateinit var reload: ImageButton
    private lateinit var exit: ImageButton
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        player = findViewById(R.id.player)

        if(intent != null) {
            userName = intent.getStringExtra("userName").toString()
            player.text = userName.uppercase()
        }

        reload = findViewById(R.id.button_reload)
        exit = findViewById(R.id.button_exit)

        exit.setOnClickListener {
            finish()
        }
    }
}