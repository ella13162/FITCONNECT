package com.example.fitconnect

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var registerOption: TextView
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize fields
        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
        loginButton = findViewById(R.id.loginButton)
        registerOption = findViewById(R.id.registerOption) // Initialize register option

        // Initialize Database Helper
        databaseHelper = DatabaseHelper(this)

        // Set click listener for the Login button
        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Validation checks
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@LoginActivity, "Both fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Authenticate user
            if (authenticateUser(email, password)) {
                Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                // Redirect to HomeActivity
                val intent = Intent(this@LoginActivity, HomePageActivity::class.java)
                startActivity(intent)
                finish() // Close the LoginActivity
            } else {
                Toast.makeText(this@LoginActivity, "Invalid email or password!", Toast.LENGTH_SHORT).show()
            }
        }

        // Set click listener for the Register option
        registerOption.setOnClickListener {
            // Redirect to RegistrationActivity
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish() // Close the LoginActivity
        }
    }

    // Method to authenticate user
    private fun authenticateUser(email: String, password: String): Boolean {
        val cursor: Cursor? = databaseHelper.getUserByEmail(email)
        cursor?.let {
            if (it.moveToFirst()) {
                val passwordIndex = it.getColumnIndex(DatabaseHelper.COL_PASSWORD) // Use the constant here
                if (passwordIndex != -1) {
                    val storedPassword = it.getString(passwordIndex)
                    it.close()
                    return password == storedPassword // Compare passwords
                } else {
                    it.close()
                    Toast.makeText(this, "Error retrieving password", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return false
    }
}
