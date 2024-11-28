package com.sopt.shinmungo.domain.repository

import com.sopt.shinmungo.data.remote.ServicePool
import com.sopt.shinmungo.domain.entity.AllCategoryEntity
import com.sopt.shinmungo.domain.mapper.toAllCategoryEntity

class AllCategoryRepository {
    private val service = ServicePool.allCategoryService


    suspend fun fetchDescriptions(): Result<List<AllCategoryEntity>> = runCatching {
        val response = service.fetchAllCategories()
        val categoryDetails = response.data?.categoryDetails

        categoryDetails?.map { it.toAllCategoryEntity() } ?: emptyList()
    }
}
