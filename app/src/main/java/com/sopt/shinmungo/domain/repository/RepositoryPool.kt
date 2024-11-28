package com.sopt.shinmungo.domain.repository

object RepositoryPool {
    val allCategoryRepository by lazy {
        AllCategoryRepository()
    }

    /** GalleryRepository 레포지토리 객체 */
    val galleryRepository by lazy {
        GalleryRepository()
    }

    val homeRepository by lazy {
        HomeRepository()
    }
}