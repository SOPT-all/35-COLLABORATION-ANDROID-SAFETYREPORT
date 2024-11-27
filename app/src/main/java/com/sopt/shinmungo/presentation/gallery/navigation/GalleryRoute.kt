package com.sopt.shinmungo.presentation.gallery.navigation

import com.sopt.shinmungo.core.navigation.Route
import kotlinx.serialization.Serializable

@Serializable
data object Gallery : Route

@Serializable
data class GalleryDetail(val photoId: Int) : Route