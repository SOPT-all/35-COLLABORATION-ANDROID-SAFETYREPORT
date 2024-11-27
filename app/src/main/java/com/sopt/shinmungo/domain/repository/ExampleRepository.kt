package com.sopt.shinmungo.domain.repository

import com.sopt.shinmungo.data.remote.ServicePool
import com.sopt.shinmungo.domain.entity.Example
import com.sopt.shinmungo.domain.mapper.toExample
import com.sopt.shinmungo.domain.mapper.toExampleRequest

///**TODO: 이해를 위한 예시 레포지토리 구현 (삭제될 예정)*/
//class ExampleRepository {
//    private val service = ServicePool.exampleService
//
//    suspend fun getExample(token: String): Result<Example> = runCatching {
//        val response = service.fetchExampleData(token.toExampleRequest())
//
//        response.data?.toExample() ?: throw Exception("response data is null")
//    }
//}