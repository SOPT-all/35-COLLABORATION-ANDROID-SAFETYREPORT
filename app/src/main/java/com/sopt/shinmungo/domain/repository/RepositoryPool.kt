package com.sopt.shinmungo.domain.repository

object RepositoryPool {
    val allCategoryRepository by lazy {
        AllCategoryRepository()
    }
}