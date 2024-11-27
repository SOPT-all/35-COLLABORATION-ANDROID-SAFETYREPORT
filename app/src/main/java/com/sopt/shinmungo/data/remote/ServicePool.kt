package com.sopt.shinmungo.data.remote

import com.sopt.shinmungo.data.service.AllCategoryService

object ServicePool {
    val allCategoryService: AllCategoryService by lazy {
        ApiFactory.create<AllCategoryService>()
    }
}