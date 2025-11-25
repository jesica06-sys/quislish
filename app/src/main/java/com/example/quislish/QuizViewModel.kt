package com.example.quislish

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quislish.data.model.Question
import com.example.quislish.data.repository.QuizRepository

class QuizViewModel(levelId: Int) : ViewModel() {

    private val questions: List<Question> = QuizRepository.getQuestionsForLevel(levelId)

    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    private val _currentQuestion = MutableLiveData<Question?>().apply {
        value = if (questions.isNotEmpty()) questions[0] else null
    }
    val currentQuestion: LiveData<Question?> = _currentQuestion

    private val _selectedAnswerIndex = MutableLiveData<Int?>()
    val selectedAnswerIndex: LiveData<Int?> = _selectedAnswerIndex

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    fun selectAnswer(index: Int) {
        _selectedAnswerIndex.value = index
    }

    /**
     * Kembalikan true kalau berhasil pindah ke question berikutnya,
     * false kalau sudah soal terakhir.
     * Jika next berhasil, reset selectedAnswerIndex.
     */
    fun nextQuestion(): Boolean {
        val idx = _currentIndex.value ?: 0

        // kalkulasi score: kalau answer dipilih dan benar, tambahkan 1
        val selected = _selectedAnswerIndex.value
        if (selected != null) {
            val correct = questions[idx].correctIndex
            if (selected == correct) {
                _score.value = (_score.value ?: 0) + 1
            }
        }

        if (idx < questions.size - 1) {
            val next = idx + 1
            _currentIndex.value = next
            _currentQuestion.value = questions[next]
            _selectedAnswerIndex.value = null
            return true
        } else {
            // soal habis
            return false
        }
    }

    fun totalQuestions(): Int = questions.size

    fun reset() {
        _currentIndex.value = 0
        _currentQuestion.value = if (questions.isNotEmpty()) questions[0] else null
        _selectedAnswerIndex.value = null
        _score.value = 0
    }
}
