package com.sopt.shinmungo.data.dto.response

import com.sopt.shinmungo.data.util.LocalDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class PhotoResponse(
    @SerialName("photoList")
    val photoList: List<PhotoDto>
)

@Serializable
data class PhotoDto(
    @SerialName("photoId") val photoId: Int,
    @SerialName("photoUrl") val photoUrl: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    @SerialName("createdAt") val createdAt: LocalDateTime
)