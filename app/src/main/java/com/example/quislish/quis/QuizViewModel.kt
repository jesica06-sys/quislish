package com.example.quislish.quis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quislish.data.model.LevelViewModel
import com.example.quislish.data.model.Question
import com.example.quislish.data.repository.QuizRepository

class QuizViewModel(
    private val levelId: Int,
    private val levelViewModel: LevelViewModel
) : ViewModel() {

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

    fun nextQuestion(): Pair<Boolean, Boolean> {
        val idx = _currentIndex.value ?: 0

        val selected = _selectedAnswerIndex.value
        var isCorrect = false

        if (selected != null) {
            val correct = questions[idx].correctIndex
            if (selected == correct) {
                _score.value = (_score.value ?: 0) + 1
                isCorrect = true
            }
        }

        return if (idx < questions.size - 1) {
            val next = idx + 1
            levelViewModel.updateProgress(levelId, next)

            _currentIndex.value = next
            _currentQuestion.value = questions[next]
            _selectedAnswerIndex.value = null

            Pair(true, isCorrect)
        } else {
            levelViewModel.updateProgress(levelId, questions.size)

            Pair(false, isCorrect)
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
