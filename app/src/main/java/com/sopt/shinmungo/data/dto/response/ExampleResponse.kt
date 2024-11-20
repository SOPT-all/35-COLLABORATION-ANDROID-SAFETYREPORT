package com.sopt.shinmungo.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**TODO: 이해를 위한 예시 응답 dto (삭제될 예정)*/
@Serializable
data class ExampleResponse(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String
)
