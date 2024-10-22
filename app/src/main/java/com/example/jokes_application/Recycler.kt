package com.example.jokes_application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val jokeList: List<Joke>) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryView: TextView = itemView.findViewById(R.id.categoryTextView)
        val questionView: TextView = itemView.findViewById(R.id.questionTextView)
        val answerView: TextView = itemView.findViewById(R.id.answerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val joke = jokeList[position]
        holder.categoryView.text = joke.category
        holder.questionView.text = joke.question

        // Обрезка
        holder.answerView.text = if (joke.answer.length > 100) {
            "${joke.answer.take(100)}..."
        } else {
            joke.answer
        }
    }

    override fun getItemCount(): Int = jokeList.size
}

