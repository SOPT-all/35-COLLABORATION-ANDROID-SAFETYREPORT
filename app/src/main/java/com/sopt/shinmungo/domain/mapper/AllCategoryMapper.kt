package com.sopt.shinmungo.domain.mapper

import com.sopt.shinmungo.data.dto.response.CategoryDetailListResponse.CategoryDetailResponse
import com.sopt.shinmungo.domain.entity.AllCategoryEntity


fun CategoryDetailResponse.toAllCategoryEntity(): AllCategoryEntity {
    return AllCategoryEntity(
        title = this.name,
        description = this.description,
        reportableItems = formatStringToList(this.description)
    )
}


fun formatStringToList(rawString: String?): List<String> {
    if (rawString.isNullOrEmpty()) return emptyList()
    val formatString = rawString.removePrefix("\"").removeSuffix("\"")
    return formatString.split("\\r\\n")
        .map { it.trim().removeSurrounding("\"") }
        .filter { it.isNotEmpty() }
}
