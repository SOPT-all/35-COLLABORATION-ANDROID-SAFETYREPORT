package com.sopt.shinmungo.domain.entity

import java.time.LocalDateTime

data class Photo(
    val id: Int,
    val url: String,
    val timestamp: LocalDateTime,
)