package com.example.jokes_application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokes_application.joke_view.JokesRecyclerViewAdapter
import com.example.jokes_application.models.Joke


class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val jokes = listOf(
            Joke(
                "Неадекватная бредятина",
                "\"Не добьётесь своего!\"",
                "- Олег Тиньков сменил фамилию на Т"
            ),
            Joke(
                "Чёрный юмор",
                "Любимая песня Джорджа Флойда?",
                "Розовое вино"
            ),
            Joke(
                "Бредни, россказни и небылицы",
                "Как избавиться от паразитов?",
                "Ком паразитов вышел утром после этого метода. " +
                        "На ночь перед сном нужно выпить пару капель копеечного советского " +
                        "(угадайте)."
            ),
            Joke(
                "Бредни, россказни и небылицы",
                "На похоронах усопшего так хвалили,",
                "что вдова два раза подходила к гробу, чтобы посмотреть, кто там лежит"
            ),
            Joke(
                "Неадекватная бредятина",
                "Почему медведь залез в машину и сгорел?",
                "Ему было холодно"
            ),
            Joke(
                "Неадекватная бредятина",
                "Почему ему было холодно?",
                "Он был ГОООООООООООЛ"
            ),
            Joke(
                "Неадекватная бредятина",
                "Почему в Румынии умерли все лебеди?",
                "Цыгане быстрее доплывают до хлеба"
            ),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JokesRecyclerViewAdapter(jokes)
    }
}