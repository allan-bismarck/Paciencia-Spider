package com.example.paciencia_spider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnPlay: Button
    private lateinit var userName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.editTextPersonName)

        btnPlay = findViewById(R.id.play)
        btnPlay.setOnClickListener {
            var i = Intent(this, FirstActivity::class.java)
            Log.i("userName", userName.text.toString())
            i.putExtra("userName", userName.text.toString())
            userName.text.clear()
            runIntent(i)
        }
    }

    private fun runIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}
