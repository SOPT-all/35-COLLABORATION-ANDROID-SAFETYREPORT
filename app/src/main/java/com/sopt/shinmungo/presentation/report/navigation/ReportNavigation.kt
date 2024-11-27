package com.sopt.shinmungo.presentation.report.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.core.navigation.Route
import com.sopt.shinmungo.domain.entity.Photo
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import com.sopt.shinmungo.presentation.gallery.navigation.navigateToGallery
import com.sopt.shinmungo.presentation.home.navigation.Home
import com.sopt.shinmungo.presentation.map.navigation.navigateToAddressInput
import com.sopt.shinmungo.presentation.report.ReportScreen
import kotlinx.serialization.Serializable
import timber.log.Timber

fun NavHostController.navigateToReport(navOptions: NavOptions? = null) =
    navigate(
        route = Report,
        navOptions = navOptions
    )

fun NavGraphBuilder.reportScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    composable<Report> { backStackEntry ->
        val selectedPhotoList = remember(backStackEntry) {
            backStackEntry.savedStateHandle.get<Array<Photo>>("selected_photos")?.toList()?.map { ReportPhotoItem(it.id, it.url) } ?: emptyList()
        }
        val selectedAddress = remember(backStackEntry) {
            backStackEntry.savedStateHandle.get<String>("selected_address") ?: ""
        }

        ReportScreen(
            modifier = modifier,
            selectedPhotoList = selectedPhotoList,
            selectedLocation = selectedAddress,
            onBackClick = navController::navigateUp,
            onMoveToMapClick = navController::navigateToAddressInput,
            onMoveToGalleryClick = navController::navigateToGallery,
            onMoveToHomeClick = {
                navController.popBackStack(
                    route = Home,
                    inclusive = false
                )
            }
        )
    }
}


@Serializable
data object Report: Route