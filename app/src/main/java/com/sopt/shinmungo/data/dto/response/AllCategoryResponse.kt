package com.sopt.shinmungo.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CategoryDetailListResponse(
    @SerialName("categoryDetailList") val categoryDetails: List<CategoryDetailResponse>
) {
    @Serializable
    data class CategoryDetailResponse(
        @SerialName("categoryId") val id: Int,
        @SerialName("categoryName") val name: String,
        @SerialName("categoryDescription") val description: String
    )
}