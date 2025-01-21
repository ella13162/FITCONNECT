package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity : AppCompatActivity() {

    private lateinit var quickBookingButton: Button
    private lateinit var upcomingSessionsButton: Button
    private lateinit var fitnessTipsButton: Button
    private lateinit var socialNetworkingButton: Button
    private lateinit var helpSupportButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Initialize buttons
        quickBookingButton = findViewById(R.id.quickBookingButton)
        upcomingSessionsButton = findViewById(R.id.upcomingSessionsButton)
        fitnessTipsButton = findViewById(R.id.fitnessTipsButton)
        socialNetworkingButton = findViewById(R.id.socialNetworkingButton)
        helpSupportButton = findViewById(R.id.helpSupportButton)

        // Set click listeners for each button

        quickBookingButton.setOnClickListener {
            // Navigate to QuickBookingActivity (you can create this activity)
            val intent = Intent(this, QuickBookingActivity::class.java)
            startActivity(intent)
        }

        upcomingSessionsButton.setOnClickListener {
            // Navigate to UpcomingSessionsActivity (you can create this activity)
            val intent = Intent(this, UpcomingSessionsActivity::class.java)
            startActivity(intent)
        }

        fitnessTipsButton.setOnClickListener {
            // Navigate to FitnessTipsActivity (you can create this activity)
            val intent = Intent(this, FitnessTipsActivity::class.java)
            startActivity(intent)
        }

        socialNetworkingButton.setOnClickListener {
            // Navigate to SocialNetworkingActivity (you can create this activity)
            val intent = Intent(this, SocialNetworkingActivity::class.java)
            startActivity(intent)
        }

        helpSupportButton.setOnClickListener {
            // Navigate to HelpAndSupportActivity (you can create this activity)
            val intent = Intent(this, HelpAndSupportActivity::class.java)
            startActivity(intent)
        }
    }
}
