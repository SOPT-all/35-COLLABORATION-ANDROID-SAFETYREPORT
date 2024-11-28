package com.sopt.shinmungo.data.dto.response

import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReportResponse(
    @SerialName("reportId")
    val reportId: Int,
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