package com.example.vp_alp.view

import com.example.vp_alp.R
import com.example.vp_alp.viewModel.GameViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun QuizView(navController: NavController, viewModel: GameViewModel = viewModel()) {
    val question = viewModel.questions[viewModel.currentQuestionIndex.value]
    val selectedAnswerIndex = viewModel.selectedAnswerIndex.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagequiz),
            contentDescription = "Image Quiz",
            modifier = Modifier
                .padding(40.dp)
                .height(170.dp)
                .width(360.dp)
                .clip(RoundedCornerShape(30.dp))
                .border(15.dp, Color(0xFFA35FEC), RoundedCornerShape(30.dp))
        )
        Text(
            text = question.question,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )

        question.answers.forEachIndexed { index, answer ->
            val backgroundColor = when {
                selectedAnswerIndex == -1 -> Color(0xFFA35FEC)
                index == question.correctAnswerIndex -> Color.Green
                index == selectedAnswerIndex -> Color.Red
                else -> Color(0xFFA35FEC)
            }
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(80.dp)
                    .background(backgroundColor)
                    .clickable { viewModel.submitAnswer(index) },
                contentAlignment = Alignment.Center,
            ) {
                Text(text = answer)
            }
        }
        if (selectedAnswerIndex != -1) {
            Button(
                onClick = { navController.navigate("result") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Lanjut")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizViewPreview() {
    QuizView(navController = rememberNavController())
}
