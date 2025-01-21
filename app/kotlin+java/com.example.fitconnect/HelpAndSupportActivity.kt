package com.example.fitconnect

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelpAndSupportActivity : AppCompatActivity() {

    private lateinit var faqButton: Button
    private lateinit var contactSupportButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_and_support)

        // Initialize views
        faqButton = findViewById(R.id.faqButton)
        contactSupportButton = findViewById(R.id.contactSupportButton)

        // Set click listener for FAQ button
        faqButton.setOnClickListener {
            // Display a list of FAQ items as a custom Toast message
            val faqs = listOf(
                "How to book a session?\n" +
                        "You can book a session by selecting the \"Quick Booking\" option in the app, choosing your preferred time and trainer, and confirming your booking.\n" +
                        "\n" +
                        "How to pay for a session?\n" +
                        "After booking, you can pay for your session via various payment methods available in the app, including credit/debit cards and mobile wallets.\n" +
                        "\n" +
                        "How to track progress?\n" +
                        "Track your fitness progress through the \"Upcoming Sessions\" and \"Fitness Tips\" sections, where you can monitor improvements in your performance and follow customized advice.\n" +
                        "\n" +
                        "How to change my profile details?\n" +
                        "To update your profile, go to the \"Profile\" section in the app and edit your personal information, including your name, email, and fitness goals.",
            )
            val faqMessage = faqs.joinToString("\n")

            // Inflate the custom toast layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.toast_custom, null)

            // Set the text of the Toast
            val toastText = layout.findViewById<TextView>(R.id.toastText)
            toastText.text = "FAQs:\n$faqMessage"

            // Create the Toast with custom layout
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.setGravity(Gravity.BOTTOM, 0, 200) // Position the toast
            toast.show()
        }

        // Set click listener for Contact Support button
        contactSupportButton.setOnClickListener {
            // Display a list of support contacts as a custom Toast message
            val supportContacts = listOf(
                "Support Email: support@komodohub.com",
                "Phone: +123 456 7890",
                "Live Chat: Under Development"
            )
            val supportMessage = supportContacts.joinToString("\n")

            // Inflate the custom toast layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.toast_custom, null)

            // Set the text of the Toast
            val toastText = layout.findViewById<TextView>(R.id.toastText)
            toastText.text = "Support Contacts:\n$supportMessage"

            // Create the Toast with custom layout
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.setGravity(Gravity.BOTTOM, 0, 200) // Position the toast
            toast.show()
        }
    }
}
