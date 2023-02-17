package com.example.paciencia_spider
import android.content.Intent
import android.graphics.Bitmap.Config
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var configDataBase: ConfigDataBaseUser

    private lateinit var btnPlay: Button
    private lateinit var userName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configDataBase = ConfigDataBaseUser(this)

        if(configDataBase.existUser()) {
            finish()
            runIntent(Intent(this, FirstActivity::class.java))
        }

        userName = findViewById(R.id.editTextPersonName)

        btnPlay = findViewById(R.id.play)
        btnPlay.setOnClickListener {
            var i = Intent(this, FirstActivity::class.java)
            var name = userName.text.toString()

            configDataBase.createDB(name)

            i.putExtra("userName", name)
            userName.text.clear()
            finish()
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
