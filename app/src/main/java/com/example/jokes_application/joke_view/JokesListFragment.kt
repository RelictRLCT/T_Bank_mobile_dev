package com.example.jokes_application.joke_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.JokesLoader
import com.example.jokes_application.R
import com.example.jokes_application.models.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeListFragment : Fragment() {

    private var jokeList: MutableList<Joke> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var jokesAdapter: JokesRecyclerViewAdapter

    private var startJokesLoaded = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)
        val addJokeButton = view.findViewById<Button>(R.id.addJokeButton)

        if (!startJokesLoaded) {
            loadStartJokes()
            startJokesLoaded = true
        }

        jokesAdapter = JokesRecyclerViewAdapter(jokeList) { joke ->
            val bundle = Bundle().apply {
                putString("category", joke.category)
                putString("question", joke.question)
                putString("answer", joke.answer)
            }
            findNavController().navigate(R.id.action_jokeListFragment_to_jokeDetailFragment, bundle)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = jokesAdapter

        loadJokesWithDelay()

        addJokeButton.setOnClickListener {
            findNavController().navigate(R.id.action_jokeListFragment_to_addJokeFragment)
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Joke>("new_joke")
            ?.observe(viewLifecycleOwner) { newJoke ->
                if (!jokeList.contains(newJoke)) {
                    addJoke(newJoke)
                }
            }
    }

    private fun loadStartJokes() {
        jokeList.addAll(JokesLoader().loadJokes())
    }

    private fun addJoke(joke: Joke) {
        jokeList.add(joke)
        jokesAdapter.notifyItemInserted(jokeList.size - 1)
    }

    private fun loadJokesWithDelay() {
        lifecycleScope.launch {
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
            delay(1000)
            withContext(Dispatchers.Main) {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                jokesAdapter.notifyDataSetChanged()
            }
        }
    }
}
