package com.sopt.shinmungo.core.designsystem.type

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.sopt.shinmungo.R

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