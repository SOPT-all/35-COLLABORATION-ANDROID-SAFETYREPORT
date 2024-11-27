package com.sopt.shinmungo.domain.entity

data class HomeInformation(
    val userId: Long,
    val name: String,
    val yearReportCount: Int,
    val monthReportCount: Int,
    val mileage: String,
    val bannerUrls: List<BannerImage>,
)
