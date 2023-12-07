package com.example.plantasiakuadrat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.view.View
import android.widget.TextView
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.databinding.ActivityStartPageBinding
class StartPage : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 3000 // Splash screen duration in milliseconds (
    private lateinit var binding: ActivityStartPageBinding
    private lateinit var loginbtn2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)
        binding = ActivityStartPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
        loginbtn2 = findViewById(R.id.loginbtn2)
        loginbtn2.setOnClickListener(View.OnClickListener {
            // Create an Intent to navigate to the MainActivity
            val intent = Intent(this, Signinpage::class.java)
            startActivity(intent)
        })
    }
}