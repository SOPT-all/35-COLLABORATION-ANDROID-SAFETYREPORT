package com.sopt.shinmungo.domain.repository

import com.sopt.shinmungo.data.remote.ServicePool
import com.sopt.shinmungo.domain.entity.Photo
import com.sopt.shinmungo.domain.mapper.toPhoto

class GalleryRepository {
    private val service = ServicePool.galleryService

    suspend fun getPhotos(userId: Long): Result<List<Photo>> = runCatching {
        val response = service.getPhotos(userId)
        response.data?.photoList?.map { it.toPhoto() } ?: throw Exception("response data is null")
    }
}