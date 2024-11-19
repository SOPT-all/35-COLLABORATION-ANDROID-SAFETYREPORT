package com.sopt.shinmungo.domain.mapper

import com.sopt.shinmungo.data.dto.request.ExampleRequest
import com.sopt.shinmungo.data.dto.response.ExampleResponse
import com.sopt.shinmungo.domain.entity.Example

fun ExampleResponse.toExample(): Example = Example(
    id = id,
    name = name,
)

fun String.toExampleRequest(): ExampleRequest = ExampleRequest(
    token = this
)