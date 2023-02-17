package com.example.paciencia_spider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class FirstActivity : AppCompatActivity() {
    private lateinit var configDataBase: ConfigDataBaseUser

    private lateinit var text: TextView
    private lateinit var wins: TextView
    private lateinit var defeats: TextView
    private lateinit var performance: TextView
    private lateinit var btninitGame: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        configDataBase = ConfigDataBaseUser(this)
        var userName = configDataBase.getNameUser().toString().uppercase()

        text = findViewById(R.id.textView)
        text.text = userName

        var numberWins = configDataBase.getWins()
        var numberDefeats = configDataBase.getDefeats()

        wins = findViewById(R.id.wins)
        defeats = findViewById(R.id.defeats)
        performance = findViewById(R.id.performance)

        wins.text = numberWins.toString()
        defeats.text = numberDefeats.toString()
        if(numberWins == 0 && numberDefeats == 0) {
            performance.text = "Não houve jogadas"
        } else {
            var percent: Float = (numberWins!!/(numberWins + numberDefeats!!)).toFloat()
            performance.text = "$percent%"
        }


        val spinner: Spinner = findViewById(R.id.spinner_number_naipes)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.number_naipes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        btninitGame = findViewById(R.id.init_game)
        btninitGame.setOnClickListener {
            var i = Intent(this, GameActivity::class.java)
            i.putExtra("userName", userName)
            runIntent(i)
        }

        btnDelete = findViewById(R.id.delete_user)
        btnDelete.setOnClickListener {
            configDataBase.deleteUser()
            finish()
            runIntent(Intent(this, MainActivity::class.java))
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