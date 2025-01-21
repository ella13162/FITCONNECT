package com.example.fitconnect

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FitnessTipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_tips)

        // Find the TextView for displaying the tips
        val fitnessTipsTextView: TextView = findViewById(R.id.fitnessTipsTextView)

    }
}
