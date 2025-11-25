package com.example.quislish.data.model

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int
)