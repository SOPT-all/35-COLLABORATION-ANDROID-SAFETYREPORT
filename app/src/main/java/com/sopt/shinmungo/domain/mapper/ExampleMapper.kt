package com.sopt.shinmungo.domain.mapper

import com.sopt.shinmungo.data.dto.request.ExampleRequest
import com.sopt.shinmungo.data.dto.response.ExampleResponse
import com.sopt.shinmungo.domain.entity.Example

/**TODO: 이해를 위한 예시 매퍼 구현 (삭제될 예정)*/
fun ExampleResponse.toExample(): Example = Example(
    id = id,
    name = name,
)

fun String.toExampleRequest(): ExampleRequest = ExampleRequest(
    token = this
)