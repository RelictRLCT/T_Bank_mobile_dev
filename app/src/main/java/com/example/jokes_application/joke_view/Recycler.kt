package com.example.jokes_application.joke_view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.R
import com.example.jokes_application.joke_detail_activity.JokeDetailActivity
import com.example.jokes_application.models.Joke

class JokesRecyclerViewAdapter(private val jokeList: List<Joke>) : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokeList[position]
        holder.update(joke)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, JokeDetailActivity::class.java).apply {
                putExtra("Category", joke.category)
                putExtra("Question", joke.question)
                putExtra("Answer", joke.answer)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = jokeList.size
}

