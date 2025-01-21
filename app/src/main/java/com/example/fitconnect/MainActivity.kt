package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        val appLogo: ImageView = findViewById(R.id.appLogo)
        val welcomeMessage: TextView = findViewById(R.id.welcomeMessage)
        val introductionMessage: TextView = findViewById(R.id.introductionMessage)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginButton: Button = findViewById(R.id.loginButton)

        // Register Button Click
        registerButton.setOnClickListener {
            Toast.makeText(this, "Register clicked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Login Button Click
        loginButton.setOnClickListener {
            Toast.makeText(this, "Login clicked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
