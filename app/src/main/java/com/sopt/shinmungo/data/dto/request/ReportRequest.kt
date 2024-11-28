package com.sopt.shinmungo.data.dto.request

import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReportRequest(
    @SerialName("photoList")
    val photoList: List<ReportPhotoItem>,
    @SerialName("address")
    val address: String,
    @SerialName("content")
    val content: String,
    @SerialName("phoneNumber")
    val phoneNumber: String,
    @SerialName("category")
    val category: String,
)