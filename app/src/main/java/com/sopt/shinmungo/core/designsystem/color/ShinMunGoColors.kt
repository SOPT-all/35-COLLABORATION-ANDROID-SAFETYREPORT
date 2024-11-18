package com.sopt.shinmungo.core.designsystem.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorProvider = staticCompositionLocalOf<ShinMunGoColors> {
    error("No colors provided")
}

@Immutable
data class ShinMunGoColors(
    //Primary
    val primary: Color,
    val primaryLight: Color,
    val primaryRed: Color,

    //Grey Scale Colors
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,
    val gray7: Color,
    val gray8: Color,
    val gray9: Color,
    val gray10: Color,
    val gray11: Color,
    val gray12: Color,
    val gray13: Color,

    //Translucent Colors
    val opacityGray13Per60: Color,
    val opacityGray13Per40: Color,
    val opacityGray13Per10: Color,
    val opacityGray13Per5: Color,
    val opacityGray1Per30: Color,
    val opacityGray1Per10: Color,
)

val defaultShinMunGoColors = ShinMunGoColors(
    primary = Orange,
    primaryLight = Beige,
    primaryRed = Red,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    gray6 = Gray6,
    gray7 = Gray7,
    gray8 = Gray8,
    gray9 = Gray9,
    gray10 = Gray10,
    gray11 = Gray11,
    gray12 = Gray12,
    gray13 = Gray13,
    opacityGray13Per60 = OpacityGray13_60,
    opacityGray13Per40 = OpacityGray13_40,
    opacityGray13Per10 = OpacityGray13_10,
    opacityGray13Per5 = OpacityGray13_5,
    opacityGray1Per30 = OpacityGray1_30,
    opacityGray1Per10 = OpacityGray1_10
)
