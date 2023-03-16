package com.example.paciencia_spider
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class FirstActivity : AppCompatActivity() {
    private lateinit var configDataBase: ConfigDataBaseUser

    private lateinit var title: TextView
    private lateinit var wins: TextView
    private lateinit var defeats: TextView
    private lateinit var performance: TextView
    private lateinit var btninitGame: Button
    private lateinit var btnDelete: Button
    private lateinit var btnTutorial: Button

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        configDataBase = ConfigDataBaseUser(this)
        val userName = configDataBase.getNameUser().toString().uppercase()

        title = findViewById(R.id.title)
        title.text = "Bem vindo(a), $userName"

        val numberWins = configDataBase.getWins()
        val numberDefeats = configDataBase.getDefeats()

        wins = findViewById(R.id.wins)
        defeats = findViewById(R.id.defeats)
        performance = findViewById(R.id.performance)

        wins.text = numberWins.toString()
        defeats.text = numberDefeats.toString()
        if(numberWins == 0 && numberDefeats == 0) {
            performance.text = "Não houve jogadas"
        } else {
            val percent: Float = (numberWins.toFloat()/(numberWins.toFloat() + numberDefeats.toFloat()) * 100)
            val df = DecimalFormat("#.##")
            val dfPercent = df.format(percent)
            performance.text = "$dfPercent%"
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
            val i = Intent(this, GameActivity::class.java)
            val b = Bundle()
            b.putString("userName", userName)
            val qtdNaipes = spinner.selectedItem.toString().split(" ")
            b.putInt("qtdNaipes", qtdNaipes[0].toInt())
            i.putExtras(b)
            runIntent(i)
        }

        btnDelete = findViewById(R.id.delete_user)
        btnDelete.setOnClickListener {
            configDataBase.deleteUser()
            runIntent(Intent(this, MainActivity::class.java))
            finish()
        }

        btnTutorial = findViewById(R.id.tutorial)
        btnTutorial.setOnClickListener {
            startActivity(Intent(this,TutorialScreen::class.java))
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun runIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}