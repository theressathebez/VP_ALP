package com.example.vp_alp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.vp_alp.R
import com.example.vp_alp.route.listScreen
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.viewmodel.StudyViewModel

@Composable
fun VideoView(
    videoId: Int,
    navController: NavController,
    viewModel: StudyViewModel = viewModel(factory = StudyViewModel.Factory),
    onClick: () -> Unit
) {
    val video by viewModel.video

    LaunchedEffect(Unit) {
        viewModel.getVideo(videoId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 40.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Color.Black,
            modifier = Modifier
                .size(36.dp)
                .align(Alignment.Start)
                .clickable {
                    navController.popBackStack()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.group_369),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp)
                .height(300.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(
                    color = Color(0xFFF7ECFF), shape = RoundedCornerShape(15.dp)
                )
                .border(
                    border = BorderStroke(1.dp, Color(0xFFA35FED)),
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = Color(0xFFFFD664),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(34.dp)
            )

            Text(
                text = video.data.flashcard,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow Right",
                tint = Color.White,
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        color = Color(0xFFA35FEC), shape = RoundedCornerShape(50)
                    )
                    .padding(4.dp)
                    .align(Alignment.BottomEnd)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp)
                .background(
                    color = Color(0xFFA35FEC), shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .clickable {
                    navController.navigate("${listScreen.Flashcard.name}/${videoId}")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Selanjutnya",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VideoViewPreview() {
    VP_ALPTheme {
//        VideoView()
    }
}