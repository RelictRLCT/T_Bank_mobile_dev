package com.example.jokes_application.joke_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.JokesLoader
import com.example.jokes_application.R
import com.example.jokes_application.models.Joke

class JokeListFragment : Fragment() {

    private var onJokeSelected: ((Joke) -> Unit)? = null
    private val jokeList: List<Joke> = JokesLoader().loadJokes()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_joke_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = JokesRecyclerViewAdapter(jokeList) { joke ->
            onJokeSelected?.invoke(joke)
        }
        return view
    }

    fun setOnJokeSelectedListener(listener: (Joke) -> Unit) {
        onJokeSelected = listener
    }
}
