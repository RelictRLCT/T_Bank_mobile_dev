package com.example.jokes_application.joke_detail_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.jokes_application.R



class JokeDetailActivity : ComponentActivity() {

    companion object {
        private const val EXTRA_CATEGORY = "Category"
        private const val EXTRA_QUESTION = "Question"
        private const val EXTRA_ANSWER = "Answer"

        fun createIntent(context: Context, category: String, question: String, answer: String): Intent {
            return Intent(context, JokeDetailActivity::class.java).apply {
                putExtra(EXTRA_CATEGORY, category)
                putExtra(EXTRA_QUESTION, question)
                putExtra(EXTRA_ANSWER, answer)
            }
        }
    }

    private fun updateCategoryText(category: String?) {
        findViewById<TextView>(R.id.categoryDetailTextView).text = category
    }

    private fun updateQuestionText(question: String?) {
        findViewById<TextView>(R.id.questionDetailTextView).text = question
    }

    private fun updateAnswerText(answer: String?) {
        findViewById<TextView>(R.id.answerDetailTextView).text = answer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_detail)

        val category = intent.getStringExtra(EXTRA_CATEGORY)
        val question = intent.getStringExtra(EXTRA_QUESTION)
        val answer = intent.getStringExtra(EXTRA_ANSWER)

        updateCategoryText(category)
        updateQuestionText(question)
        updateAnswerText(answer)
    }
}
