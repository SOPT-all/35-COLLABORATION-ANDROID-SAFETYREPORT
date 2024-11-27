package com.sopt.shinmungo.presentation.gallery

import com.sopt.shinmungo.domain.entity.Photo
import java.time.LocalDate

data class GalleryState(
    val photos: Map<LocalDate, List<Photo>> = emptyMap(),
    val selectedPhotos: Set<Int> = emptySet(),
    val isLoading: Boolean = false,
    val error: String? = null
)
