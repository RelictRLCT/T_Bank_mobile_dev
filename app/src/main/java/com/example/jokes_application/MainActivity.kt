package com.example.jokes_application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.joke_detail_activity.JokeDetailActivity
import com.example.jokes_application.joke_view.JokesRecyclerViewAdapter


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val jokes = JokesLoader().loadJokes()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = JokesRecyclerViewAdapter(jokes) { joke ->
            val intent = JokeDetailActivity.createIntent(
                this,
                category = joke.category,
                question = joke.question,
                answer = joke.answer
            )
            startActivity(intent)
        }

    }
}