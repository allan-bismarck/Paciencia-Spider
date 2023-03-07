package com.example.paciencia_spider
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            runIntent(Intent(this, FirstActivity::class.java))
            finish()
        }

        userName = findViewById(R.id.editTextPersonName)

        btnPlay = findViewById(R.id.play)
        btnPlay.setOnClickListener {
            val i = Intent(this, FirstActivity::class.java)
            val name = userName.text.toString()

            configDataBase.createDB(name)

            i.putExtra("userName", name)
            userName.text.clear()
            runIntent(i)
            finish()
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun runIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}
