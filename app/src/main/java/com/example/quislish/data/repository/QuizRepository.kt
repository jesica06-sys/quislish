package com.example.quislish.data.repository



import com.example.quislish.data.model.Question

object QuizRepository {
    fun getQuestionsForLevel(levelId: Int): List<Question> {
        return when(levelId) {
            1 -> listOf(
                Question(1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry?", listOf("option 1","option 2","option 3","option 4"), 0),
                Question(2, "2 + 2 = ?", listOf("1","2","4","3"), 2),
                // ... total 10 questions
                Question(3, "Q3 ...", listOf("a","b","c","d"), 1),
                Question(4, "Q4 ...", listOf("a","b","c","d"), 2),
                Question(5, "Q5 ...", listOf("a","b","c","d"), 0),
                Question(6, "Q6 ...", listOf("a","b","c","d"), 3),
                Question(7, "Q7 ...", listOf("a","b","c","d"), 1),
                Question(8, "Q8 ...", listOf("a","b","c","d"), 2),
                Question(9, "Q9 ...", listOf("a","b","c","d"), 0),
                Question(10,"Q10 ...", listOf("a","b","c","d"), 3)
            )
            2 -> listOf(
                Question(1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry?", listOf("option 1","option 2","option 3","option 4"), 0),
                Question(2, "2 + 3 = ?", listOf("1","2","4","3"), 2),
                // ... total 10 questions
                Question(3, "Q3 ...", listOf("a","b","c","d"), 1),
                Question(4, "Q4 ...", listOf("a","b","c","d"), 2),
                Question(5, "Q5 ...", listOf("a","b","c","d"), 0),
                Question(6, "Q6 ...", listOf("a","b","c","d"), 3),
                Question(7, "Q7 ...", listOf("a","b","c","d"), 1),
                Question(8, "Q8 ...", listOf("a","b","c","d"), 2),
                Question(9, "Q9 ...", listOf("a","b","c","d"), 0),
                Question(10,"Q10 ...", listOf("a","b","c","d"), 3)
            )
            else -> emptyList()
        }
    }
}
