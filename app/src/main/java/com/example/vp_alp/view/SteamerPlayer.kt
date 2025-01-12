//package com.example.vp_alp.view
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import com.example.vp_alp.viewmodel.StudyViewModel
//import com.example.vp_alp.viewmodel.VideoPlayerViewModel
//
//@Composable
//fun StreamerPlayer(
//    viewModel: VideoPlayerViewModel,
//    isPlaying: Boolean,
//    onPlayerClosed: (isVideoPlaying: Boolean) -> Unit
//) {
//    Box(
//        modifier = Modifier.fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        if (isPlaying) {
//            AndroidView(
//                modifier = Modifier.fillMaxWidth(),
//                factory = { cont ->
//                    viewModel.playerViewBuilder(cont)
//                }
//            )
//
//            IconButton(
//                onClick = {
//                    onPlayerClosed(false)
//                    viewModel.releasePlayer()
//                }
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Close,
//                    contentDescription = "Close",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .size(36.dp)
//                        .align(Alignment.TopEnd)
//
//                )
//            }
//        } else {
//            Text("Loading...")
//        }
//    }
//}
