package com.example.quislish

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quislish.R

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    private val levelId: Int by lazy {
        // kalau pakai SafeArgs ganti: QuizFragmentArgs.fromBundle(requireArguments()).levelId
        arguments?.getInt("levelId") ?: 1
    }

    private val viewModel: QuizViewModel by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuizViewModel(levelId) as T
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
        btnNext = view.findViewById(R.id.btnNext)

        // observe current question
        viewModel.currentQuestion.observe(viewLifecycleOwner) { q ->
            if (q != null) {
                bindQuestion(q)
            }
        }

        viewModel.currentIndex.observe(viewLifecycleOwner) { idx ->
            txtQuestionNumber.text = (idx + 1).toString()
            topProgress.max = viewModel.totalQuestions()
            topProgress.progress = idx + 1
        }

        // option clicks
        cardOpt0.setOnClickListener { onOptionClicked(0) }
        cardOpt1.setOnClickListener { onOptionClicked(1) }
        cardOpt2.setOnClickListener { onOptionClicked(2) }
        cardOpt3.setOnClickListener { onOptionClicked(3) }

        btnNext.setOnClickListener {
            // jika belum memilih jawaban, kamu bisa minta konfirmasi atau disable next
            val moved = viewModel.nextQuestion()
            if (!moved) {
                // semua soal selesai -> navigasi ke result (kamu implementasi sendiri)
                // contoh:
                // val action = QuizFragmentDirections.actionQuizToResult(viewModel.score.value ?: 0)
                // findNavController().navigate(action)
                // sementara tampil toast
                val score = viewModel.score.value ?: 0
                // show dialog / toast
                android.widget.Toast.makeText(requireContext(), "Selesai! Score: $score", android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun bindQuestion(q: com.example.quislish.data.model.Question) {
        txtQuestion.text = q.questionText
        txtOpt0.text = q.options[0]
        txtOpt1.text = q.options[1]
        txtOpt2.text = q.options[2]
        txtOpt3.text = q.options[3]

        // reset card background states
        resetOptionStyles()
    }

    private fun onOptionClicked(index: Int) {
        // simpan di ViewModel selected index
        viewModel.selectAnswer(index)
        // update UI highlight
        highlightSelected(index)
    }

    private fun resetOptionStyles() {
        // contoh: ubah elevation / background untuk menandakan unselected
        val cards = listOf(cardOpt0, cardOpt1, cardOpt2, cardOpt3)
        cards.forEach { it.cardElevation = 2f; it.isClickable = true }
    }

    private fun highlightSelected(index: Int) {
        resetOptionStyles()
        val selectedCard = when(index) {
            0 -> cardOpt0
            1 -> cardOpt1
            2 -> cardOpt2
            else -> cardOpt3
        }
        selectedCard.cardElevation = 8f
    }
}
