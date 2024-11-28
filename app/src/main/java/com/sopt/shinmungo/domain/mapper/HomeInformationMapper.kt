package com.sopt.shinmungo.domain.mapper

import com.sopt.shinmungo.data.dto.response.HomeInformationResponse
import com.sopt.shinmungo.domain.entity.BannerImage
import com.sopt.shinmungo.domain.entity.HomeInformation

fun HomeInformationResponse.toHomeInformation(): HomeInformation = HomeInformation(
    userId = this.userId,
    name = "수민",
    yearReportCount = yearReportCount,
    monthReportCount = yearReportCount,
    mileage = mileage.toString(),
    bannerImages = bannerList.map {
        BannerImage(
            bannerId = it.bannerId,
            bannerImageUrl = it.bannerUrl
        )
    }
)