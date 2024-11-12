package com.example.jokes_application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jokes_application.joke_detail.JokeDetailFragment
import com.example.jokes_application.joke_view.JokeListFragment
import com.example.jokes_application.models.Joke

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        if (savedInstanceState == null) {
            val jokeListFragment = JokeListFragment()
            jokeListFragment.setOnJokeSelectedListener { joke ->
                showJokeDetail(joke)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, jokeListFragment)
                .commit()
        }
    }

    private fun showJokeDetail(joke: Joke) {
        val detailFragment = JokeDetailFragment.newInstance(
            joke.category, joke.question, joke.answer
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}
