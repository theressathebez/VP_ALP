package com.example.vp_alp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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
import coil.compose.AsyncImage
import com.example.vp_alp.R
import com.example.vp_alp.route.listScreen
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.viewmodel.StudyViewModel

@Composable
fun TopicScroll(
    topicId: Int,
    navController: NavController,
    viewModel: StudyViewModel = viewModel(factory = StudyViewModel.Factory),
    onClick: () -> Unit
) {
    val videos by viewModel.videos

    LaunchedEffect(Unit) {
        viewModel.fetchVideos(topicId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        navController.popBackStack()

                    })
            Text(
                text = "Kembali",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(videos.data) { video ->
                TopicView(
                    title = video.video_name,
                    foto = video.flashcard,
                    onClick = {
                        // Navigasi ke VideoView dengan videoId
                        navController.navigate("${listScreen.Video.name}/${video.id}")
                    }
                )
            }
        }

//        var isPlaying by remember {
//            mutableStateOf(false)
//        }
//        var videoItemIndex by remember {
//            mutableIntStateOf(0)
//        }
//        val viewModel: VideoPlayerViewModel = viewModel()
//        viewModel.videoList = mainVideoList
//
//        val context = LocalContext.current
//
//        if (videos.data.isEmpty()) {
//            Text(
//                text = "No videos available",
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                color = Color.Gray,
//                fontSize = 16.sp
//            )
//        } else {
//            StreamerPlayer(
//                viewModel = viewModel,
//                isPlaying = isPlaying,
//                onPlayerClosed = { isVideoPlaying ->
//                    isPlaying = isVideoPlaying
//                }
//            )

        // Topic Content
//            LazyColumn(
//                modifier = Modifier.padding(horizontal = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                itemsIndexed(items = mainVideoList) { index, item ->
//                    Row(
//                        Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                if (videoItemIndex != index) isPlaying = false
//                                viewModel.index = index
//                                videoItemIndex = viewModel.index
//                            },
//                        horizontalArrangement = Arrangement.spacedBy(16.dp),
//                        verticalAlignment = Alignment.Bottom
//                    ) {
//                        AsyncImage(
//                            model = item.thumbnail,
//                            contentDescription = "Thumbnail",
//                            modifier = Modifier.size(75.dp)
//                        )
//                        Text(
//                            text = "Video ${index + 1}",
//                            Modifier
//                                .fillMaxSize()
//                                .weight(1f)
//                        )
//
//                        Divider(
//                            Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 6.dp)
//                        )
//                    }
//                }
//            }
//
//            LaunchedEffect(key1 = videoItemIndex) {
//                isPlaying = true
//                viewModel.apply {
//                    releasePlayer()
//                    initializePlayer(context)
//                    playVideo()
//                }
//            }


    }
}


@Composable
fun TopicView(
    title: String, foto: String, onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(
                color = Color(0xFFE9F5FF), shape = RoundedCornerShape(15.dp)
            )
            .border(
                border = BorderStroke(1.dp, Color(0xFFB2DAFF)), shape = RoundedCornerShape(15.dp)
            )
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.image_removebg_preview__2_),
            contentDescription = "preview",
            modifier = Modifier.size(75.dp)
        )

//        AsyncImage(
//            model = foto,
//            contentDescription = "Thumbnail",
//            modifier = Modifier.size(75.dp)
//        )

        // Text Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title, fontSize = 14.sp, fontWeight = FontWeight.Normal, color = Color.Gray
            )
        }

        // Continue Button with Icon
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF3AAFFE), shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 4.dp, vertical = 4.dp), contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow Right",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopicViewPreview() {
    VP_ALPTheme {
//        TopicScroll()
    }
}