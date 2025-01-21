package com.example.fitconnect

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        // Get references to the radio buttons and button
        val paymentOptionsGroup = findViewById<RadioGroup>(R.id.paymentOptionsGroup)
        val makePaymentBtn = findViewById<Button>(R.id.makePaymentBtn)

        // Set onClick listener for the "Make Payment" button
        makePaymentBtn.setOnClickListener {

            // Get the selected radio button ID
            val selectedOptionId = paymentOptionsGroup.checkedRadioButtonId

            if (selectedOptionId != -1) {
                // Show booking confirmation toast without payment method
                Toast.makeText(this, "Booking Confirmed!", Toast.LENGTH_LONG).show()
            } else {
                // If no payment method is selected, show a toast prompting to choose one
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
