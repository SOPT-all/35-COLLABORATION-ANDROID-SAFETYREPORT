package com.sopt.shinmungo.data.service

import com.sopt.shinmungo.data.dto.BaseResponse
import com.sopt.shinmungo.data.dto.response.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface GalleryService {
    @GET("report/photo")
    suspend fun getPhotos(
        @Header("userId") userId: Long
    ): BaseResponse<PhotoResponse>
}