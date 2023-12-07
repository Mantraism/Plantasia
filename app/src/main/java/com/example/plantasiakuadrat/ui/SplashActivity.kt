package com.example.plantasiakuadrat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.MainActivity
import com.example.plantasiakuadrat.ui.StartPage
import com.example.plantasiakuadrat.databinding.ActivityStartPageBinding
class SplashActivity : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 3000 // Splash screen duration in milliseconds (3 seconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Create an Intent to start the destination activity
            val intent = Intent(this, StartPage::class.java)
            startActivity(intent)
            finish() // Finish the splash screen activity
        }, SPLASH_DURATION)

    }
}