package com.example.vp_alp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R

@Composable
fun BottomNavigationBar(
    modifier: Modifier,
    currentScreen: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top= 8.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(
                    if (currentScreen == "study")
                        R.drawable.study_selected
                    else
                        R.drawable.study
                ),
                contentDescription = "study",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Study",
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(
                    if (currentScreen == "transcript")
                        R.drawable.transcript_selected
                    else
                        R.drawable.transcript
                ),
                contentDescription = "transcript",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Transcript",
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(
                    if (currentScreen == "game")
                        R.drawable.game_selected
                    else
                        R.drawable.game
                ),
                contentDescription = "game",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Game",
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(
                    if (currentScreen == "profile")
                        R.drawable.profile_selected
                    else
                        R.drawable.profile__2_
                ),
                contentDescription = "profile",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Profile",
                fontSize = 12.sp,
                color = Color.Black
            )
        }
    }
}