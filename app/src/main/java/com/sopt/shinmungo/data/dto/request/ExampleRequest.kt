package com.sopt.shinmungo.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**TODO: 이해를 위한 예시 요청 dto (삭제될 예정)*/
@Serializable
data class ExampleRequest(
    @SerialName("token")
    val token: String
)
