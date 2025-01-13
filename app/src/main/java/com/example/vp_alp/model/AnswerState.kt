package com.example.vp_alp.model

data class Question(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)
