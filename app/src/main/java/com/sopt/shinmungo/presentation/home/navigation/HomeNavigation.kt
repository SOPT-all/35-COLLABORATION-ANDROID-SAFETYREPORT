package com.sopt.shinmungo.presentation.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.core.navigation.MainTabRoute
import kotlinx.serialization.Serializable

fun NavHostController.navigateToHome(navOptions: NavOptions? = null) = navigate(Home)

fun NavGraphBuilder.homeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<Home> {

    }
}

@Serializable
data object Home: MainTabRoute