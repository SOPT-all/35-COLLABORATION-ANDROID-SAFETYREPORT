package com.sopt.shinmungo.data.service

import com.sopt.shinmungo.data.dto.BaseResponse
import com.sopt.shinmungo.data.dto.response.CategoryDetailListResponse
import retrofit2.http.GET

interface AllCategoryService {
    @GET("/api/v1/report/category")
    suspend fun fetchAllCategories(): BaseResponse<CategoryDetailListResponse>
}