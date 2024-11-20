package com.sopt.shinmungo.data.dto

import kotlinx.serialization.Serializable

/**
 * 서버 통신할 때 사용하는 기본 응답 데이터 클래스.
 *
 * data를 위한 데이터 클래스를 넣어서 사용하면 됨
 */

@Serializable
data class BaseResponse <T> (
    val status: Int,
    val message: String,
    val data: T? = null
)
