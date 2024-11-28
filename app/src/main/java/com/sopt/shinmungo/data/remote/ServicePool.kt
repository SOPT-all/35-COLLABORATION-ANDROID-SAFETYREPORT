package com.sopt.shinmungo.data.remote

import com.sopt.shinmungo.data.service.ExampleService
import com.sopt.shinmungo.data.service.ReportService

object ServicePool {
    /**TODO: Retrofit 객체 생성 예시 (삭제 예정)*/
    val exampleService by lazy {
        ApiFactory.create<ExampleService>()
    }

    val reportService by lazy {
        ApiFactory.create<ReportService>()
    }
}