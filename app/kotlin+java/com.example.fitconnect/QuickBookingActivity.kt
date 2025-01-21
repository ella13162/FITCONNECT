package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuickBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_booking)

        // Button Click Listeners
        val selectBtn1 = findViewById<Button>(R.id.selectBtn1)
        val selectBtn2 = findViewById<Button>(R.id.selectBtn2)
        val selectBtn3 = findViewById<Button>(R.id.selectBtn3)
        val selectBtn4 = findViewById<Button>(R.id.selectBtn4)
        val selectBtn5 = findViewById<Button>(R.id.selectBtn5)

        selectBtn1.setOnClickListener { openTrainerActivity("Cardio Training") }
        selectBtn2.setOnClickListener { openTrainerActivity("Strength Training") }
        selectBtn3.setOnClickListener { openTrainerActivity("Yoga & Flexibility") }
        selectBtn4.setOnClickListener { openTrainerActivity("HIIT Workout") }
        selectBtn5.setOnClickListener { openTrainerActivity("Weightlifting") }
    }

    // Function to open TrainerActivity and pass the exercise name
    private fun openTrainerActivity(exerciseName: String) {
        val intent = Intent(this, TrainerActivity::class.java)
        intent.putExtra("EXERCISE_NAME", exerciseName)
        startActivity(intent)
        Toast.makeText(this, "Booking $exerciseName", Toast.LENGTH_SHORT).show()
    }
}
