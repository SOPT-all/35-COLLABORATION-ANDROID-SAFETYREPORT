package com.sopt.shinmungo.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.sopt.shinmungo.R

val LocalTypographyProvider = staticCompositionLocalOf<ShinMunGoTypography> {
    error("No typography provided")
}

@Immutable
data class ShinMunGoTypography (
    /*Heading styles*/
    val heading1: TextStyle,
    val heading2: TextStyle,

    /*Body styles*/
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val body5: TextStyle,
    val body6: TextStyle,
    val body7: TextStyle,
    val body8: TextStyle,
    val body9: TextStyle,

    /*Caption styles*/
    val caption1: TextStyle,
    val caption2: TextStyle,
    val caption3: TextStyle,
    val caption4: TextStyle,
    val caption5: TextStyle,
    val caption6: TextStyle,
    val caption7: TextStyle,
    val caption8: TextStyle,
    val caption9: TextStyle,
)

val PretendardExtraBold = FontFamily(Font(R.font.pretendard_extrabold))
val PretendardBold = FontFamily(Font(R.font.pretendard_bold))
val PretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val PretendardMedium = FontFamily(Font(R.font.pretendard_medium))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular))

// Set of Material typography styles to start with
val defaultShinMunGoTypography = ShinMunGoTypography(
    heading1 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    heading2 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 18.sp,
        lineHeight = 21.sp
    ),
    body1 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    body3 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body4 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 15.sp,
        lineHeight = 28.sp
    ),
    body5 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 15.sp,
        lineHeight = 18.sp
    ),
    body6 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 14.sp,
        lineHeight = 17.sp
    ),
    body7 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    body8 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
        lineHeight = 17.sp
    ),
    body9 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    caption1 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    caption2 = TextStyle(
        fontFamily = PretendardSemiBold,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    caption3 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 12.sp,
        lineHeight = 20.sp
    ),
    caption4 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp,
        lineHeight = 19.sp
    ),
    caption5 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 10.sp,
        lineHeight = 16.sp
    ),
    caption6 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 10.sp,
        lineHeight = 16.sp
    ),
    caption7 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 10.sp,
        lineHeight = 16.sp
    ),
    caption8 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 8.sp,
        lineHeight = 16.sp
    ),
    caption9 = TextStyle(
        fontFamily = PretendardExtraBold,
        fontSize = 8.sp,
        lineHeight = 16.sp
    )
)