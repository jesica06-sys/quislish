package com.example.quislish.quis

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quislish.R
import com.example.quislish.data.model.LevelViewModel
import com.example.quislish.data.model.Question

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    // Ambil levelId dari Bundle
    private val levelId: Int by lazy {
        arguments?.getInt("levelId") ?: 1
    }

    // Shared LevelViewModel -> dipakai HomeFragment & QuizFragment
    private val levelViewModel: LevelViewModel by activityViewModels()

    // >>> TIDAK ADA FILE FACTORY <<<
    private val quizViewModel: QuizViewModel by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(levelId, levelViewModel) as T
            }
        }
    }

    private lateinit var txtQuestion: TextView
    private lateinit var txtQuestionNumber: TextView
    private lateinit var topProgress: ProgressBar
    private lateinit var cardOpt0: CardView
    private lateinit var cardOpt1: CardView
    private lateinit var cardOpt2: CardView
    private lateinit var cardOpt3: CardView
    private lateinit var txtOpt0: TextView
    private lateinit var txtOpt1: TextView
    private lateinit var txtOpt2: TextView
    private lateinit var txtOpt3: TextView
    private lateinit var btnNext: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View binding manual
        txtQuestion = view.findViewById(R.id.txtQuestion)
        txtQuestionNumber = view.findViewById(R.id.txtQuestionNumber)
        topProgress = view.findViewById(R.id.topProgress)
        cardOpt0 = view.findViewById(R.id.cardOpt0)
        cardOpt1 = view.findViewById(R.id.cardOpt1)
        cardOpt2 = view.findViewById(R.id.cardOpt2)
        cardOpt3 = view.findViewById(R.id.cardOpt3)
        txtOpt0 = view.findViewById(R.id.txtOpt0)
        txtOpt1 = view.findViewById(R.id.txtOpt1)
        txtOpt2 = view.findViewById(R.id.txtOpt2)
        txtOpt3 = view.findViewById(R.id.txtOpt3)
        btnNext = view.findViewById(R.id.bottomNext)
        val btnBack: View = view.findViewById(R.id.imgViewBack)
        // Observers
        quizViewModel.currentQuestion.observe(viewLifecycleOwner) { q ->
            if (q != null) bindQuestion(q)
        }

        quizViewModel.currentIndex.observe(viewLifecycleOwner) { idx ->
            txtQuestionNumber.text = "${levelId}"
            topProgress.max = quizViewModel.totalQuestions()
            topProgress.progress = idx + 1
        }

        cardOpt0.setOnClickListener { onOptionClicked(0) }
        cardOpt1.setOnClickListener { onOptionClicked(1) }
        cardOpt2.setOnClickListener { onOptionClicked(2) }
        cardOpt3.setOnClickListener { onOptionClicked(3) }
        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        btnNext.setOnClickListener {
            val moved = quizViewModel.nextQuestion()

            if (!moved) {
                val score = quizViewModel.score.value ?: 0
                Toast.makeText(requireContext(), "Selesai! Score: $score", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun bindQuestion(q: Question) {
        txtQuestion.text = q.questionText
        txtOpt0.text = q.options[0]
        txtOpt1.text = q.options[1]
        txtOpt2.text = q.options[2]
        txtOpt3.text = q.options[3]
        resetOptionStyles()
    }

    private fun onOptionClicked(index: Int) {
        quizViewModel.selectAnswer(index)
        highlightSelected(index)
    }

    private fun resetOptionStyles() {
        listOf(cardOpt0, cardOpt1, cardOpt2, cardOpt3).forEach {
            it.cardElevation = 2f
        }
    }

    private fun highlightSelected(index: Int) {
        resetOptionStyles()
        val selectedCard = when (index) {
            0 -> cardOpt0
            1 -> cardOpt1
            2 -> cardOpt2
            else -> cardOpt3
        }
        selectedCard.cardElevation = 8f
    }
}
