package com.sopt.shinmungo.presentation.home.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.core.navigation.MainTabRoute
import com.sopt.shinmungo.presentation.allcategory.navigation.navigateToAllCategory
import com.sopt.shinmungo.presentation.home.HomeRoute
import com.sopt.shinmungo.presentation.report.navigation.navigateToReport
import kotlinx.serialization.Serializable

fun NavHostController.navigateToHome(navOptions: NavOptions? = null) =
    navigate(route = Home, navOptions = navOptions)

fun NavGraphBuilder.homeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<Home>(
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        enterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        }
    ) {

        HomeRoute(
            modifier = modifier,
            navigateToCategory = navController::navigateToAllCategory,
            navigateToParkingReport = navController::navigateToReport
        )
    }
}

@Serializable
data object Home : MainTabRoute