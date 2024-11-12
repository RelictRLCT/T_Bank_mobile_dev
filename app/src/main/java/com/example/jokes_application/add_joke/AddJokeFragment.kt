package com.example.jokes_application.add_joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jokes_application.R
import com.example.jokes_application.models.Joke
import java.util.UUID

class AddJokeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_joke, container, false)

        val categoryInput = view.findViewById<EditText>(R.id.categoryEditText)
        val questionInput = view.findViewById<EditText>(R.id.questionEditText)
        val answerInput = view.findViewById<EditText>(R.id.answerEditText)
        val addButton = view.findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val joke = Joke(
                id = UUID.randomUUID().toString(),
                category = categoryInput.text.toString(),
                question = questionInput.text.toString(),
                answer = answerInput.text.toString()
            )
            findNavController().previousBackStackEntry?.savedStateHandle?.set("new_joke", joke)
            findNavController().popBackStack()
        }

        return view
    }
}
