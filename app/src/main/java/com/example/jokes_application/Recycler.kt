package com.example.jokes_application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JokesRecyclerViewAdapter(private val jokeList: List<Joke>) : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.update(jokeList, position)
    }

    override fun getItemCount(): Int = jokeList.size
}

