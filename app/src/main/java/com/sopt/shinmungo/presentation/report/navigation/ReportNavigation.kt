package com.sopt.shinmungo.presentation.report.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.core.navigation.Route
import com.sopt.shinmungo.presentation.report.ReportScreen
import kotlinx.serialization.Serializable

fun NavHostController.navigateToReport(navOptions: NavOptions? = null) =
    navigate(
        route = Report,
        navOptions = navOptions
    )

fun NavGraphBuilder.reportScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<Report> {
        ReportScreen(
            modifier = modifier,
            onBackClick = {}
        )
    }
}


@Serializable
data object Report: Route