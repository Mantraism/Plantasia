package com.example.plantasiakuadrat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.plantasiakuadrat.MainActivity
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.data.DBHelper
import com.example.plantasiakuadrat.databinding.ActivityStartPageBinding
class SignUp : AppCompatActivity() {
//    private lateinit var binding: ActivityStartPageBinding
//    val buttonNavigate: Button = findViewById(R.id.button)
    private lateinit var buttonNavigate: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var email: EditText
    private lateinit var signup: Button
    private lateinit var signin: Button
    private lateinit var DB: DBHelper
    private lateinit var loginbtn : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
//        binding = ActivityStartPageBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.button.setOnClickListener{
//            startActivity(Intent(this, HomeFragment::class.java))
//            finish()
//        }

//        buttonNavigate.setOnClickListener(View.OnClickListener {
//        // Create an Intent to navigate to the second activity
//            val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//    })

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        email = findViewById(R.id.email)
        DB = DBHelper(this)
        buttonNavigate = findViewById(R.id.button)

        buttonNavigate.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            val email = email.text.toString()

            if (user.isEmpty() || pass.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
            } else {
                if (pass != email) {
                    val checkuser = DB.checkusername(user)
                    if (!checkuser) {
                        val insert = DB.insertData(user, pass, email)
                        if (insert) {
                            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
//                    try {
//                        val insert = DB.insertData(user, pass, email)
//                        if (insert) {
//                            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
//                            val intent = Intent(applicationContext, MainActivity::class.java)
//                            startActivity(intent)
//                        } else {
//                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                        Toast.makeText(this, "An error occurred during registration", Toast.LENGTH_SHORT).show()
//                    }

                }
            }
        }
        loginbtn = findViewById(R.id.loginbtn)
//        loginbtn.setOnClickListener {
//            val intent = Intent(this, Signinpage::class.java)
////          startActivity(intent)
//        }




        loginbtn.setOnClickListener(View.OnClickListener {
            // Create an Intent to navigate to the MainActivity
                val intent = Intent(this, Signinpage::class.java)
            startActivity(intent)
        })


    }
}