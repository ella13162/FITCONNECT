package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UpcomingSessionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming_sessions)

        // Button for Session 1
        val btnJoinSession1 = findViewById<Button>(R.id.btnJoinSession1)
        btnJoinSession1.setOnClickListener {
            joinSession("Full Body Workout", "2024-12-25", "10:00 AM")
        }

        // Button for Session 2
        val btnJoinSession2 = findViewById<Button>(R.id.btnJoinSession2)
        btnJoinSession2.setOnClickListener {
            joinSession("Yoga for Beginners", "2024-12-26", "8:00 AM")
        }

        // Button for Session 3
        val btnJoinSession3 = findViewById<Button>(R.id.btnJoinSession3)
        btnJoinSession3.setOnClickListener {
            joinSession("Strength Training", "2024-12-27", "9:00 AM")
        }

        // Button for Session 4
        val btnJoinSession4 = findViewById<Button>(R.id.btnJoinSession4)
        btnJoinSession4.setOnClickListener {
            joinSession("Cardio Blast", "2024-12-28", "7:00 AM")
        }

        // Button for Session 5
        val btnJoinSession5 = findViewById<Button>(R.id.btnJoinSession5)
        btnJoinSession5.setOnClickListener {
            joinSession("HIIT Workout", "2024-12-29", "11:00 AM")
        }
    }

    // Method to handle joining a session
    private fun joinSession(sessionName: String, sessionDate: String, sessionTime: String) {
        // Show a Toast message with the session details
        Toast.makeText(
            this,
            "You have joined the session: $sessionName\nDate: $sessionDate\nTime: $sessionTime",
            Toast.LENGTH_LONG
        ).show()
    }
}
