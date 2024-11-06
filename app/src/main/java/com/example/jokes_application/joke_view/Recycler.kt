package com.example.jokes_application.joke_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.R
import com.example.jokes_application.models.Joke

class JokesRecyclerViewAdapter(val jokeList: List<Joke>, val onJokeClicked: (Joke) -> Unit)
    : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view, onJokeClicked)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.update(jokeList[position])
    }

    override fun getItemCount(): Int = jokeList.size
}

