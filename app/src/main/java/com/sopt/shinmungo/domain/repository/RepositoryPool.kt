package com.sopt.shinmungo.domain.repository

object RepositoryPool {

    /**TODO: 이해를 위한 예시 레포지토리 객체 (삭제될 예정)*/
    val exampleRepository by lazy {
        ExampleRepository()
    }

    val homeRepository by lazy {
        HomeRepository()
    }
}