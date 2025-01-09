package com.example.vp_alp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.ui.theme.VP_ALPTheme

@Composable
fun QuizView() {

    Column {
        Text(
            text = "Pertanyaan",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 100.dp, start = 20.dp)
        )


    }
}

@Composable
fun AnswerCard() {
    Box(
        modifier = Modifier
    ) {
        Column {
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Surface(
                        color = Color.Blue,
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Number of Guesses",
                            color = Color.White,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                }
                Row {

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizViewPreview() {
    QuizView()
}