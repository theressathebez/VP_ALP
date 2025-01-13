package com.example.vp_alp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.viewModel.GameViewModel

@Composable
fun ResultView(navController: NavController, viewModel: GameViewModel = viewModel()) {
    val score = viewModel.score.value
    val stars = if (score > 0) "⭐️⭐️⭐️" else "✩✩✩"

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Skor Anda: $score",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(text = stars, style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                viewModel.resetQuiz()
                navController.navigate("quiz")
            }) {
                Text("Ulangi")
            }

            Button(onClick = {
                viewModel.resetQuiz()
                navController.navigate("game")
            }) {
                Text("Berikutnya")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultViewPreview() {
    ResultView(navController = rememberNavController())
}
