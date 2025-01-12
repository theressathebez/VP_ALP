package com.example.vp_alp.route

import StudyScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.view.AccountView
import com.example.vp_alp.view.ChangePassView
import com.example.vp_alp.view.DelAccountView
import com.example.vp_alp.view.LoginView
import com.example.vp_alp.view.ProfileView
import com.example.vp_alp.view.RegisterPreview
import com.example.vp_alp.view.RegisterView
import com.example.vp_alp.view.TopicScroll
import com.example.vp_alp.view.UserFlashcardView
import com.example.vp_alp.view.VideoView
import com.example.vp_alp.viewmodel.AuthenticationViewModel
import com.example.vp_alp.viewmodel.UserViewModel


@Composable
fun AppRouting(
    navController: NavHostController = rememberNavController(),
    authenticationViewModel: AuthenticationViewModel = viewModel(factory = AuthenticationViewModel.Factory),
    userViewModel: UserViewModel = viewModel(factory = UserViewModel.Factory)

) {
    val localContext = LocalContext.current
    val token = userViewModel.token.collectAsState()

    NavHost(
        navController = navController,
        //layar pertama yg dimunculkan
        startDestination =
        if (token.value != "Unknown" && token.value != "") {
            listScreen.Profile.name
        } else {
            listScreen.Login.name
        }
    ) {
        composable(
            route = listScreen.Study.name
        ) {
            StudyScroll(
                navController = navController
            )
        }

        composable(
            route = listScreen.Register.name
        ) {
            RegisterView(
                authenticationViewModel = authenticationViewModel,
                navController = navController,
                context = localContext
            )
        }

        composable(
            route = listScreen.Login.name
        ) {
            LoginView(
                authenticationViewModel = authenticationViewModel,
                navController = navController,
                context = localContext
            )
        }

        composable(
            route = listScreen.Profile.name
        ) {
            ProfileView(
                userViewModel = userViewModel,
                token = token.value,
                navController = navController,
                context = localContext
            )
        }

        composable(
            route = listScreen.Account.name
        ) {
            AccountView(
                userViewModel = userViewModel,
                navController = navController
            )
        }

        composable(
            route = listScreen.ChangePass.name
        ) {
            ChangePassView(
                userViewModel = userViewModel,
                token = token.value,
                navController = navController,
                context = localContext
            )
        }

        composable(
            route = listScreen.DelAccount.name
        ) {
            DelAccountView(
                userViewModel = userViewModel,
                navController = navController,
                token = token.value,
                context = localContext
            )
        }

        composable(
            route = listScreen.UserFlashcard.name
        ) {
            UserFlashcardView(
                navController = navController,
                token = token.value
            )
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
    }
}