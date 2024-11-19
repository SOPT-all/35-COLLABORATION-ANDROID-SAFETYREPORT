package com.sopt.shinmungo.core.designsystem.type

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

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