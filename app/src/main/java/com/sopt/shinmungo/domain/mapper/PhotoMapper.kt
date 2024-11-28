package com.sopt.shinmungo.domain.mapper

import com.sopt.shinmungo.data.dto.response.PhotoDto
import com.sopt.shinmungo.domain.entity.Photo

fun PhotoDto.toPhoto(): Photo = Photo(
    id = photoId,
    url = photoUrl,
    timestamp = createdAt
)