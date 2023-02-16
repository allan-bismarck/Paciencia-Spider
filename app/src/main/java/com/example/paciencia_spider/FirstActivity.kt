package com.example.paciencia_spider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    private lateinit var configDataBase: ConfigDataBaseUser

    private lateinit var text: TextView
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        configDataBase = ConfigDataBaseUser(this)

        if(intent != null) {
            var userName: String? = intent.getStringExtra("userName")
            text = findViewById(R.id.textView)
            text.text = configDataBase.getNameUser().toString()
        }

        btnDelete = findViewById(R.id.delete_user)
        btnDelete.setOnClickListener {
            configDataBase.deleteUser()
            finish()
        }
    }
}