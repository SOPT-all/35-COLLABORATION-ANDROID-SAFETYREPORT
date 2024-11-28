package com.sopt.shinmungo.domain.repository

import com.sopt.shinmungo.data.dto.request.ReportRequest
import com.sopt.shinmungo.data.dto.response.ReportResponse
import com.sopt.shinmungo.data.remote.ServicePool

class ReportRepository {
    private val service = ServicePool.reportService

    suspend fun postReport(userId: Long, request: ReportRequest): Result<ReportResponse> = runCatching {
        val response = service.postReport(userId, request)
        response.data ?: throw Throwable("Failed to post report")
    }
}