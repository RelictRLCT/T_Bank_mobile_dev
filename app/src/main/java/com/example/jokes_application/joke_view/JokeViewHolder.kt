package com.example.jokes_application.joke_view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.R
import com.example.jokes_application.models.Joke

class JokeViewHolder(itemView: View, val onJokeClicked: (Joke) -> Unit)
    : RecyclerView.ViewHolder(itemView) {

    private val categoryView: TextView = itemView.findViewById(R.id.categoryTextView)
    private val questionView: TextView = itemView.findViewById(R.id.questionTextView)
    private val answerView: TextView = itemView.findViewById(R.id.answerTextView)

    fun update(joke: Joke) {
        categoryView.text = joke.category
        questionView.text = joke.question
        answerView.text = joke.answer

        itemView.setOnClickListener { onJokeClicked(joke) }
    }
}
