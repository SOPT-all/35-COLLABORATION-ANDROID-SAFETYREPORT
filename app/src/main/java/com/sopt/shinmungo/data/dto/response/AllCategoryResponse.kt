package com.sopt.shinmungo.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CategoryDetailListResponse(
    @SerialName("categoryDetailList") val categoryDetails: List<CategoryDetailResponse> // 카테고리 상세 목록
) {
    @Serializable
    data class CategoryDetailResponse(
        @SerialName("categoryId") val id: Int, // 카테고리 ID
        @SerialName("categoryName") val name: String, // 카테고리 이름
        @SerialName("categoryDescription") val description: String // 카테고리 설명
    )
}