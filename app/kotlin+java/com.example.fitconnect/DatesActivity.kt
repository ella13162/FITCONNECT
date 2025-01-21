package com.example.fitconnect

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DatesActivity : AppCompatActivity() {

    private lateinit var selectedDateTextView: TextView
    private var selectedDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        selectedDateTextView = findViewById(R.id.selectedDateTextView)

        // Set date click listeners
        setDateClickListener(findViewById(R.id.date1), "1", false)
        setDateClickListener(findViewById(R.id.date2), "2", true)
        setDateClickListener(findViewById(R.id.date3), "3", true)
        setDateClickListener(findViewById(R.id.date4), "4", false)

        // Proceed to Payment button
        val proceedToPaymentBtn = findViewById<View>(R.id.proceedToPaymentBtn)
        proceedToPaymentBtn.setOnClickListener {
            if (selectedDate != null) {
                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("SELECTED_DATE", selectedDate)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select an available date first!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    // Function to set click listener for dates
    private fun setDateClickListener(dateView: TextView, date: String, isAvailable: Boolean) {
        dateView.setOnClickListener {
            if (isAvailable) {
                selectedDate = date
                selectedDateTextView.text = "Selected Date: $date"
                Toast.makeText(this, "You selected date: $date", Toast.LENGTH_SHORT).show()

                // Highlight the selected date visually
                resetDateSelection()
                dateView.setBackgroundColor(Color.parseColor("#90CAF9")) // Light Blue
            } else {
                Toast.makeText(this, "This date is unavailable. Please choose another date.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Reset date backgrounds
    private fun resetDateSelection() {
        findViewById<TextView>(R.id.date1).setBackgroundColor(Color.parseColor("#FFCDD2"))
        findViewById<TextView>(R.id.date2).setBackgroundColor(Color.parseColor("#C8E6C9"))
        findViewById<TextView>(R.id.date3).setBackgroundColor(Color.parseColor("#C8E6C9"))
        findViewById<TextView>(R.id.date4).setBackgroundColor(Color.parseColor("#FFCDD2"))
    }
}
