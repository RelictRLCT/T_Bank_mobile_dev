package com.example.jokes_application.models

import java.io.Serializable

data class Joke(
    val id: String,
    val category: String,
    val question: String,
    val answer: String
) : Serializable