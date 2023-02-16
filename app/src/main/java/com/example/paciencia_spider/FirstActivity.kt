package com.example.paciencia_spider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        if(intent != null) {
            var userName: String? = intent.getStringExtra("userName")
            text = findViewById(R.id.textView)
            text.text = userName
            Log.i("First Activity", userName!!)
        }
    }
}