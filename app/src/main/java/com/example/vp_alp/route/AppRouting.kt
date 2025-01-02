package com.example.vp_alp.route

import StudyScroll
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vp_alp.view.TopicScroll
import com.example.vp_alp.view.VideoView

enum class listScreen {
    Study,
    Topic,
    Video,
    Flashcard
}

@Composable
fun AppRouting() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        //layar pertama yg dimunculkan
        startDestination = listScreen.Study.name
    ) {
        composable(
            route = listScreen.Study.name
        ) {
            StudyScroll(navController = navController)
        }

        composable("topicScroll/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toInt() ?: 0
            TopicScroll(
                categoryId = categoryId,
                navController = navController,
                onClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("videoView/{topicId}") { backStackEntry ->
            val topicId = backStackEntry.arguments?.getString("topicId")?.toInt() ?: 0
            VideoView(
                topicId = topicId,  // Pastikan menggunakan topicId di sini
                navController = navController,
                onClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}