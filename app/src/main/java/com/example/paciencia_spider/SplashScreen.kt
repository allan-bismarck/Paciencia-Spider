package com.example.paciencia_spider

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnRepeat
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import kotlinx.coroutines.delay

class SplashScreen : AppCompatActivity() {

    private lateinit var icon: ImageView
    private lateinit var animation: ObjectAnimator
    @SuppressLint("ObjectAnimatorBinding")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        icon = findViewById(R.id.icon)

        animation = ObjectAnimator.ofFloat(icon, "rotationY", 0f, 360f)
        animation.duration = 1000
        animation.interpolator = FastOutSlowInInterpolator()

        animation.repeatCount = ValueAnimator.INFINITE

        animation.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}