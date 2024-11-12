package com.example.jokes_application.joke_detail_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.jokes_application.R

class JokeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString("category")
        val question = arguments?.getString("question")
        val answer = arguments?.getString("answer")

        view.findViewById<TextView>(R.id.categoryDetailTextView).text = category
        view.findViewById<TextView>(R.id.questionDetailTextView).text = question
        view.findViewById<TextView>(R.id.answerDetailTextView).text = answer
    }
}
