package com.sopt.shinmungo.domain.repository

import com.sopt.shinmungo.data.remote.ServicePool
import com.sopt.shinmungo.domain.entity.HomeInformation
import com.sopt.shinmungo.domain.mapper.toHomeInformation

class HomeRepository {
    private val service = ServicePool.homeService

    suspend fun getHomeInformation(): Result<HomeInformation> = runCatching {
        service.fetchHomeInformation(userId = 1).data?.toHomeInformation() ?: throw Throwable()
    }
}