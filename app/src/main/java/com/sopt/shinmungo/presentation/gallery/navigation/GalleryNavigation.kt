package com.sopt.shinmungo.presentation.gallery.navigation

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sopt.shinmungo.presentation.gallery.GalleryDetailScreen
import com.sopt.shinmungo.presentation.gallery.GalleryScreen
import com.sopt.shinmungo.presentation.gallery.GalleryViewModel


fun NavHostController.navigateToGallery(navOptions: NavOptions? = null) =
    navigate(route = Gallery, navOptions = navOptions)

fun NavHostController.navigateToGalleryDetail(photoId: Int, navOptions: NavOptions? = null) =
    navigate(route = GalleryDetail(photoId), navOptions = navOptions)

fun NavGraphBuilder.galleryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<Gallery> {
        GalleryScreen(
            modifier = modifier,
            onBackClick = { navController.popBackStack() },
            onPhotoClick = { photoId ->
                navController.navigate(GalleryDetail(photoId))
            },
            onConfirmClick = { selectedPhotos ->
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "selected_photos",
                    selectedPhotos.toTypedArray()
                )
                navController.popBackStack()
            },
        )
    }

    composable<GalleryDetail> { backStackEntry ->
        val galleryDetail: GalleryDetail = backStackEntry.toRoute()
        val parentEntry = remember(navController.currentBackStackEntry) {
            navController.getBackStackEntry(Gallery)
        }
        val viewModel = viewModel<GalleryViewModel>(viewModelStoreOwner = parentEntry)
        GalleryDetailScreen(
            modifier = modifier,
            photoId = galleryDetail.photoId,
            onBackClick = { navController.popBackStack() },
            viewModel = viewModel
        )
    }
}
