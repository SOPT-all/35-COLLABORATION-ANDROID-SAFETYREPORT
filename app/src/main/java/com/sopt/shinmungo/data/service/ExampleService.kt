package com.sopt.shinmungo.data.service

import com.sopt.shinmungo.data.dto.BaseResponse
import com.sopt.shinmungo.data.dto.request.ExampleRequest
import com.sopt.shinmungo.data.dto.response.ExampleResponse
import retrofit2.http.Body
import retrofit2.http.GET

/**TODO: 이해를 위한 예시 서비스 인터페이스 (삭제될 예정)*/
interface ExampleService {
    @GET("/example")
    suspend fun fetchExampleData(
        @Body request: ExampleRequest
    ): BaseResponse<ExampleResponse>
}