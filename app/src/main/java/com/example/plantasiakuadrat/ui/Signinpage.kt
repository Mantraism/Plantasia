package com.example.plantasiakuadrat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.plantasiakuadrat.MainActivity
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.data.DBHelper

class Signinpage : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var email: EditText
    private lateinit var btnlogin: Button
    private lateinit var DB: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinpage)
        username = findViewById(R.id.username1)
        password = findViewById(R.id.password1)
        email = findViewById(R.id.email1)
        btnlogin = findViewById(R.id.buttonsignin)
        DB = DBHelper(this)

        btnlogin.setOnClickListener(View.OnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            val email = email.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
            } else {
                val checkuserpass = DB.checkusernamepassword(user, pass, email)
                if (checkuserpass) {
                    Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}