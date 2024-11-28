package com.sopt.shinmungo.data.service

import com.sopt.shinmungo.data.dto.BaseResponse
import com.sopt.shinmungo.data.dto.request.ReportRequest
import com.sopt.shinmungo.data.dto.response.ReportResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ReportService {
    @POST("report")
    suspend fun postReport(
        @Header("userId") userId: Long,
        @Body request: ReportRequest
    ): BaseResponse<ReportResponse>
}