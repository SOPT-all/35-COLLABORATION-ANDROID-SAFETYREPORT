package com.sopt.shinmungo.domain.repository

import androidx.compose.material3.TimePicker
import com.sopt.shinmungo.data.remote.ServicePool
import com.sopt.shinmungo.domain.entity.AllCategoryEntity
import timber.log.Timber

class AllCategoryRepository {
    private val service = ServicePool.allCategoryService

    suspend fun fetchDescriptions(): Result<List<AllCategoryEntity>> = runCatching {
        val response = service.fetchAllCategories()
        response.data?.categoryDetails?.map {
            AllCategoryEntity(
                title = it.name,
                description = it.description,
                reportableItems = formatStringToList(it.description)
            )
        }?: emptyList()
    }
}
fun formatStringToList(rawString: String?): List<String> {
    if (rawString.isNullOrEmpty()) return emptyList() // 빈 데이터 처리
    val formatString = rawString.removePrefix("\"").removeSuffix("\"")
    return formatString.split("\\r\\n").map { it.trim().removeSurrounding("\"") }.filter { it.isNotEmpty() }
}
