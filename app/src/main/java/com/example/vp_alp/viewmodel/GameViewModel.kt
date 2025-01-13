package com.example.vp_alp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.vp_alp.model.AnswerState
import com.example.vp_alp.model.Question

class GameViewModel : ViewModel() {
    val questions = listOf(
        Question(
            "Berikut merupakan bahasa isyarat dari?",
            listOf("Bertemu", "Terima Kasih", "Bertatap", "Minta Maaf"),
            0
        )
    )

    var currentQuestionIndex = mutableStateOf(0)
    var selectedAnswerIndex = mutableStateOf(-1)
    var answerState = mutableStateOf(AnswerState.NONE)
    var score = mutableStateOf(0)

    fun submitAnswer(selectedIndex: Int) {
        selectedAnswerIndex.value = selectedIndex
        if (selectedIndex == questions[currentQuestionIndex.value].correctAnswerIndex) {
            answerState.value = AnswerState.CORRECT
            score.value = 100
        } else {
            answerState.value = AnswerState.INCORRECT
        }
    }

    fun resetQuiz() {
        currentQuestionIndex.value = 0
        selectedAnswerIndex.value = -1
        answerState.value = AnswerState.NONE
        score.value = 0
    }
}
