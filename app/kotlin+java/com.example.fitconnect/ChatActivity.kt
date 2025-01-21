package com.example.fitconnect

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var chatMessagesLayout: LinearLayout
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var chatHeader: TextView

    private val conversationHistory = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Initialize UI elements
        chatMessagesLayout = findViewById(R.id.chatMessagesLayout)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        chatHeader = findViewById(R.id.chatHeader)

        // Retrieve the user name passed from the previous activity
        val userName = intent.getStringExtra("USER_NAME")
        chatHeader.text = "Chat with $userName"

        // Add initial message
        addMessageToChat("Hey! How's it going?")

        // Set up the send button functionality
        sendButton.setOnClickListener {
            val message = messageInput.text.toString().trim()
            if (message.isNotEmpty()) {
                // Add the user's message to the chat
                addMessageToChat("You: $message")
                messageInput.text.clear() // Clear the input field

                // Generate a response based on the message
                generateReply(message)
            } else {
                Toast.makeText(this, "Please type a message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Method to add messages to the chat window
    private fun addMessageToChat(message: String) {
        val textView = TextView(this)
        textView.text = message
        textView.textSize = 16f
        textView.setTextColor(getColor(android.R.color.black))
        chatMessagesLayout.addView(textView)
    }

    // Method to generate a human-like response
    private fun generateReply(userMessage: String) {
        val reply = when {
            userMessage.contains("hello", ignoreCase = true) -> "Hi there! How can I help you today?"
            userMessage.contains("how are you", ignoreCase = true) -> "I'm doing great, thanks for asking! How about you?"
            userMessage.contains("session", ignoreCase = true) -> "You can book a session through the 'Quick Booking' section. Let me know if you need help with it!"
            userMessage.contains("progress", ignoreCase = true) -> "You can track your progress in the 'My Progress' section of the app."
            userMessage.contains("goals", ignoreCase = true) -> "Your goals are displayed under the 'My Progress' section. You can also set new goals there."
            userMessage.contains("diet", ignoreCase = true) -> "A balanced diet is essential for fitness. You can check out 'Fitness Tips' for some suggestions on healthy eating."
            userMessage.contains("workout", ignoreCase = true) -> "You can explore various workout routines in the 'Workout Plans' section of the app."
            userMessage.contains("weight loss", ignoreCase = true) -> "For weight loss, it's important to combine cardio with strength training. Don't forget to track your calories as well!"
            userMessage.contains("motivation", ignoreCase = true) -> "Stay consistent, and remember why you started! You've got this!"
            userMessage.contains("good morning", ignoreCase = true) -> "Good morning! Ready to crush your goals today?"
            userMessage.contains("good night", ignoreCase = true) -> "Good night! Rest well, and let's make tomorrow even better!"
            userMessage.contains("bye", ignoreCase = true) -> "Goodbye! Have a great day ahead!"
            userMessage.contains("help", ignoreCase = true) -> "I'm here to help! What can I assist you with today?"
            userMessage.contains("reminder", ignoreCase = true) -> "Don't forget to check your upcoming sessions and set your goals for today!"
            userMessage.contains("schedule", ignoreCase = true) -> "You can view and update your workout schedule in the 'My Schedule' section."
            userMessage.contains("fitness", ignoreCase = true) -> "Fitness is all about consistency! Keep going and stay active!"
            userMessage.contains("stretching", ignoreCase = true) -> "Stretching before and after your workout is key to preventing injuries. Stay flexible!"
            userMessage.contains("hydration", ignoreCase = true) -> "Make sure to drink plenty of water to stay hydrated throughout the day!"
            userMessage.contains("how to", ignoreCase = true) -> "Can you be more specific? What would you like to know how to do?"
            userMessage.contains("thank you", ignoreCase = true) -> "You're very welcome! I'm always here to help."
            userMessage.contains("contact support", ignoreCase = true) -> "For any support, you can contact our team through the 'Help & Support' section in the app."
            userMessage.contains("birthday", ignoreCase = true) -> "Wishing you a happy and healthy birthday! 🎉 Keep achieving your fitness goals!"
            userMessage.contains("motivation quotes", ignoreCase = true) -> "Here’s one for you: 'Success is the sum of small efforts, repeated day in and day out.' Keep pushing!"
            userMessage.contains("new features", ignoreCase = true) -> "We’re always working on adding new features! Stay tuned for exciting updates in the app."
            else -> "Hmm... I'm not sure about that. Can you rephrase? 😊"
        }

        addMessageToChat("Bot: $reply")
    }
}
