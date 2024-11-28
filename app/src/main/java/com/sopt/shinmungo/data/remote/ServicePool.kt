package com.sopt.shinmungo.data.remote

import com.sopt.shinmungo.data.service.AllCategoryService
import com.sopt.shinmungo.data.service.GalleryService

object ServicePool {
    val allCategoryService: AllCategoryService by lazy {
        ApiFactory.create<AllCategoryService>()
    }

    /** GalleryService Retrofit Service 생성 */
    val galleryService by lazy {
        ApiFactory.create<GalleryService>()
    }
}