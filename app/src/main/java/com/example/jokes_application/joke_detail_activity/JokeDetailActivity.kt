package com.example.jokes_application.joke_detail_activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.jokes_application.R

class JokeDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_detail)

        val category = intent.getStringExtra("Category")
        val question = intent.getStringExtra("Question")
        val answer = intent.getStringExtra("Answer")

        findViewById<TextView>(R.id.categoryDetailTextView).text = category
        findViewById<TextView>(R.id.questionDetailTextView).text = question
        findViewById<TextView>(R.id.answerDetailTextView).text = answer
    }
}
