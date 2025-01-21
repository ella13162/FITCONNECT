package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TrainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        // Set up click listeners for Check Availability buttons
        val checkAvailabilityBtn1 = findViewById<Button>(R.id.checkAvailabilityBtn1)
        val checkAvailabilityBtn2 = findViewById<Button>(R.id.checkAvailabilityBtn2)

        checkAvailabilityBtn1.setOnClickListener {
            openDatesActivity("Alex Johnson")
        }

        checkAvailabilityBtn2.setOnClickListener {
            openDatesActivity("Maria Lopez")
        }
    }

    // Method to open DatesActivity with trainer's name
    private fun openDatesActivity(trainerName: String) {
        val intent = Intent(this, DatesActivity::class.java)
        intent.putExtra("TRAINER_NAME", trainerName)
        startActivity(intent)
    }
}
