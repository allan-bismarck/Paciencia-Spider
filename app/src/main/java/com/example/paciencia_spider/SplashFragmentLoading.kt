package com.example.paciencia_spider

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.concurrent.timer

class SplashFragmentLoading : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("Ciclo SplashFragment", "onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.i("Ciclo SplashFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("Ciclo SplashFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Ciclo SplashFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Ciclo SplashFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("Ciclo SplashFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Ciclo SplashFragment", "onDestroy")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_game, container, false)

        return v
    }
}