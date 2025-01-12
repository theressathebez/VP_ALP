package com.example.vp_alp.route

import StudyScroll
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vp_alp.view.STTSavedView
import com.example.vp_alp.view.STTView
import com.example.vp_alp.view.TopicScroll
import com.example.vp_alp.view.VideoView
import com.example.vp_alp.viewmodel.STTViewModel

enum class listScreen {
    STT,
    SavedTexts,
    Study,
    Topic,
    Video,
    Flashcard
}

@Composable
fun AppRouting(activity: Activity, viewModel: STTViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = listScreen.STT.name
    ) {
        composable(
            route = listScreen.STT.name
        ) {
            STTView(navController = navController, activity = activity, viewModel = viewModel)
        }

        composable(
            route = listScreen.Study.name
        ) {
            StudyScroll(navController = navController)
        }

        composable(
            "topicScroll/{topicId}",
            arguments = listOf(navArgument("topicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val topicId = backStackEntry.arguments?.getInt("topicId") ?: 0
            TopicScroll(topicId = topicId, navController = navController,
                onClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            "videoView/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: 0
            VideoView(
                videoId = videoId,
                navController = navController,
                onClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = listScreen.SavedTexts.name
        ) {
            STTSavedView(navController = navController)
        }
    }
}