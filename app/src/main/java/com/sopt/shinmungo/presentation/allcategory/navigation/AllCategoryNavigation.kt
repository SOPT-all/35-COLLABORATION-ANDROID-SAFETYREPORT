package com.sopt.shinmungo.presentation.allcategory.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.core.navigation.MainTabRoute
import com.sopt.shinmungo.presentation.allcategory.AllCategoryScreen
import com.sopt.shinmungo.presentation.report.navigation.navigateToReport
import kotlinx.serialization.Serializable

fun NavHostController.navigateToAllCategory(navOptions: NavOptions? = null) =
    navigate(
        route =  AllCategory,
        navOptions = navOptions
    )

fun NavGraphBuilder.allCategoryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<AllCategory> {
        AllCategoryScreen(
            onNavigateBack = navController::navigateUp,
            onNavigateToReport = { navController.navigateToReport() }, // ReportScreen으로 이동
            modifier = modifier
        )
    }
}


@Serializable
data object AllCategory: MainTabRoute