package com.example.fitconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SocialNetworkingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_networking)

        // Set up the button for each user to start a conversation
        val startConversationBtn1 = findViewById<Button>(R.id.startConversationBtn1)
        startConversationBtn1.setOnClickListener {
            openChatActivity("John Doe")
        }

        val startConversationBtn2 = findViewById<Button>(R.id.startConversationBtn2)
        startConversationBtn2.setOnClickListener {
            openChatActivity("Alice Smith")
        }

        val startConversationBtn3 = findViewById<Button>(R.id.startConversationBtn3)
        startConversationBtn3.setOnClickListener {
            openChatActivity("Bob Johnson")
        }

        val startConversationBtn4 = findViewById<Button>(R.id.startConversationBtn4)
        startConversationBtn4.setOnClickListener {
            openChatActivity("Emma Davis")
        }

        val startConversationBtn5 = findViewById<Button>(R.id.startConversationBtn5)
        startConversationBtn5.setOnClickListener {
            openChatActivity("Sophia Lee")
        }
    }

    // Method to open ChatActivity with the name of the user
    private fun openChatActivity(userName: String) {
        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("USER_NAME", userName) // Pass the name of the person to chat with
        startActivity(intent)
    }
}
