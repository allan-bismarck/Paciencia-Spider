package com.app.paciencia_spider
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.properties.Delegates

class GameActivity : AppCompatActivity() {
    private lateinit var player: TextView
    private lateinit var reload: ImageButton
    private lateinit var exit: ImageButton
    private lateinit var userName: String
    private lateinit var gameFragment: GameFragment
    private var qtdNaipes by Delegates.notNull<Int>()
    private lateinit var b: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        player = findViewById(R.id.player)
        gameFragment = GameFragment()

        if(intent != null) {
            b = intent.extras!!
            userName = b.getString("userName").toString()
            qtdNaipes = b.getInt("qtdNaipes")
            player.text = userName.uppercase()
        }

        reload = findViewById(R.id.button_reload)

        reload.setOnClickListener {
            showDialog("RELOAD", gameFragment)
        }

        exit = findViewById(R.id.button_exit)

        exit.setOnClickListener {
            showDialog("EXIT", gameFragment)
        }

        loadFragment(gameFragment)
    }


    private fun loadFragment(fragment: Fragment) {
        val fragmentLoad = supportFragmentManager.beginTransaction()
        fragmentLoad.replace(R.id.frameFragment, fragment)
        fragment.arguments = b
        fragmentLoad.commit()
    }

    private fun reloadFragment(fragment: Fragment) {
        val fragmentLoad = supportFragmentManager.beginTransaction()
        fragmentLoad.remove(fragment)
        fragmentLoad.commit()

        gameFragment = GameFragment()
        loadFragment(gameFragment)
    }

    @SuppressLint("MissingInflatedId")
    private fun showDialog(type: String, fragment: GameFragment) {
        val configDataBase = ConfigDataBaseUser(this)
        configDataBase.setDefeats(1)

        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)
        val yes = view.findViewById<Button>(R.id.yes_dialog)
        val no = view.findViewById<Button>(R.id.no_dialog)
        val message = view.findViewById<TextView>(R.id.message)
        builder.setView(view)
        builder.setCancelable(false)

        val dialog = builder.create()

        if(type == "RELOAD") {
            message.text = "${resources.getString(R.string.to_restart)}"
            yes.setOnClickListener {
                dialog.dismiss()
                reloadFragment(fragment)
                Toast.makeText(this, "${resources.getString(R.string.game_restarted)}", Toast.LENGTH_LONG).show()
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
        } else {
            message.text = "${resources.getString(R.string.to_quit)}"
            yes.setOnClickListener {
                dialog.dismiss()
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "${resources.getString(R.string.finished_game)}", Toast.LENGTH_LONG).show()
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
        }

        dialog.show()
    }

}