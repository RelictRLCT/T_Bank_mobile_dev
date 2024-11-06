package com.example.jokes_application.joke_detail

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
        val view = inflater.inflate(R.layout.fragment_joke_detail, container, false)

        val category = arguments?.getString(EXTRA_CATEGORY)
        val question = arguments?.getString(EXTRA_QUESTION)
        val answer = arguments?.getString(EXTRA_ANSWER)

        view.findViewById<TextView>(R.id.categoryDetailTextView).text = category
        view.findViewById<TextView>(R.id.questionDetailTextView).text = question
        view.findViewById<TextView>(R.id.answerDetailTextView).text = answer

        return view
    }

    companion object {
        private const val EXTRA_CATEGORY = "Category"
        private const val EXTRA_QUESTION = "Question"
        private const val EXTRA_ANSWER = "Answer"

        fun newInstance(category: String, question: String, answer: String): JokeDetailFragment {
            val fragment = JokeDetailFragment()
            fragment.arguments = Bundle().apply {
                putString(EXTRA_CATEGORY, category)
                putString(EXTRA_QUESTION, question)
                putString(EXTRA_ANSWER, answer)
            }
            return fragment
        }
    }
}
