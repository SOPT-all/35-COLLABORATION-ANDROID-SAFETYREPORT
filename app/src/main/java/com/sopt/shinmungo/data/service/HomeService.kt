package com.sopt.shinmungo.data.service

import com.sopt.shinmungo.data.dto.BaseResponse
import com.sopt.shinmungo.data.dto.response.HomeInformationResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface HomeService {
    @GET("home")
    suspend fun fetchHomeInformation(
        @Header("userId") userId: Long
    ): BaseResponse<HomeInformationResponse>
}