package com.sopt.shinmungo.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeInformationResponse(
    @SerialName("userId")
    val userId: Long,
    @SerialName("yearReportCount")
    val yearReportCount: Int,
    @SerialName("monthReportCount")
    val monthReportCount: Int,
    @SerialName("mileage")
    val mileage: Int,
    @SerialName("bannerList")
    val bannerList: List<HomeBannerResponse>
) {
    @Serializable
    data class HomeBannerResponse(
        @SerialName("bannerId")
        val bannerId: Long,
        @SerialName("bannerUrl")
        val bannerUrl: String
    )
}
