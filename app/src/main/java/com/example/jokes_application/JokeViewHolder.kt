package com.example.jokes_application

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.models.Joke

class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val categoryView: TextView = itemView.findViewById(R.id.categoryTextView)
    val questionView: TextView = itemView.findViewById(R.id.questionTextView)
    val answerView: TextView = itemView.findViewById(R.id.answerTextView)

    fun update(jokeList: List<Joke>, position: Int) {
        val joke = jokeList[position]
        categoryView.text = joke.category
        questionView.text = joke.question
        answerView.text = joke.answer
    }
}