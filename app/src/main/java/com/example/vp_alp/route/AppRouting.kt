package com.example.vp_alp.route

import StudyScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vp_alp.view.FlashcardView
import com.example.vp_alp.view.TopicScroll
import com.example.vp_alp.view.VideoView
import com.example.vp_alp.viewmodel.StudyViewModel


enum class listScreen {
    Study,
    Topic,
    Video,
    Flashcard
}

@Composable
fun AppRouting(
    navController: NavHostController = rememberNavController(),
    studyViewModel: StudyViewModel = viewModel(factory = StudyViewModel.Factory)
) {
    NavHost(
        navController = navController,
        //layar pertama yg dimunculkan
        startDestination = listScreen.Study.name
    ) {
        composable(route = listScreen.Study.name) {
            StudyScroll(
                navController = navController,
                viewModel = studyViewModel
            )
        }

        // Topic screen
        composable(
            route = "${listScreen.Topic.name}/{topicId}",
            arguments = listOf(navArgument("topicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val topicId = backStackEntry.arguments?.getInt("topicId") ?: 0
            TopicScroll(
                topicId = topicId,
                navController = navController,
                viewModel = studyViewModel,
                onClick = { navController.popBackStack() }
            )
        }

        // Video screen
        composable(
            route = "${listScreen.Video.name}/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: 0
            VideoView(
                videoId = videoId,
                navController = navController,
                viewModel = studyViewModel,
                onClick = { navController.popBackStack() }
            )
        }

        composable(
            route = "${listScreen.Flashcard.name}/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: 0
            FlashcardView(
                videoId = videoId,
                navController = navController,
                viewModel = studyViewModel,
                onClick = { navController.popBackStack() }
            )
        }
    }
}


