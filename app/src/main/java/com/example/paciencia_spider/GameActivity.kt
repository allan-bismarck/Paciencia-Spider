package com.example.paciencia_spider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.internal.ContextUtils.getActivity

class GameActivity : AppCompatActivity() {
    private lateinit var player: TextView
    private lateinit var insertName: Button
    private lateinit var reload: ImageButton
    private lateinit var exit: ImageButton
    private lateinit var userName: String
    private lateinit var gameFragment: GameFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        player = findViewById(R.id.player)
        gameFragment = GameFragment()

        if(intent != null) {
            userName = intent.getStringExtra("userName").toString()
            player.text = userName.uppercase()
        }

        insertName = findViewById(R.id.button_name)

        insertName.setOnClickListener {
            gameFragment.alterLabel()
        }

        reload = findViewById(R.id.button_reload)

        reload.setOnClickListener {
            reloadFragment(gameFragment)
        }

        exit = findViewById(R.id.button_exit)

        exit.setOnClickListener {
            finish()
        }

        loadFragment(gameFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentLoad = supportFragmentManager.beginTransaction()
        fragmentLoad.replace(R.id.frameFragment, fragment)
        fragmentLoad.commit()
    }

    private fun reloadFragment(fragment: Fragment) {
        val fragmentLoad = supportFragmentManager.beginTransaction()
        fragmentLoad.remove(fragment)
        fragmentLoad.commit()

        gameFragment = GameFragment()
        loadFragment(gameFragment)
    }
}