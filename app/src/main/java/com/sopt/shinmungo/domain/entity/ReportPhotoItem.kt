package com.sopt.shinmungo.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReportPhotoItem(
    @SerialName("photoId")
    val photoId: Int,
    @SerialName("photoUrl")
    val photoUrl: String,
)