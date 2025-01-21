package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameField: EditText
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var registerButton: Button
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize fields
        usernameField = findViewById(R.id.usernameField)
        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
        registerButton = findViewById(R.id.registerButton)

        // Initialize Database Helper
        databaseHelper = DatabaseHelper(this)

        // Set click listener for the Register button
        registerButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Validation checks
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@RegisterActivity, "All fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if the email already exists
            if (databaseHelper.isEmailExists(email)) {
                Toast.makeText(this@RegisterActivity, "Email already registered!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Register user
            val isInserted = databaseHelper.insertUser(username, email, password)

            if (isInserted) {
                Toast.makeText(this@RegisterActivity, "Registration successful!", Toast.LENGTH_SHORT).show()
                // Redirect to LoginActivity
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish() // Close the RegistrationActivity
            } else {
                Toast.makeText(this@RegisterActivity, "Registration failed. Please try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
