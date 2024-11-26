package com.sopt.shinmungo.domain.entity

data class AllCategoryEntity(
    val title: String,
    val description: String,
    val reportableItems: List<String>
)