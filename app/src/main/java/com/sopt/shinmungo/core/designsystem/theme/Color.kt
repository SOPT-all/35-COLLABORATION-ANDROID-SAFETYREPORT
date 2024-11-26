package com.sopt.shinmungo.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//Primary Colors
val Orange = Color(0xFFFE6A00)
val Beige = Color(0xFFFFB987)
val Red = Color(0xFFD60000)

//Grey Scale Colors
val Gray1 = Color(0xFFFFFFFF)
val Gray2 = Color(0xFFFAFAFA)
val Gray3 = Color(0xFFF1F1F1)
val Gray4 = Color(0xFFE7E7E7)
val Gray5 = Color(0xFFCFCFCF)
val Gray6 = Color(0xFFA4A4A4)
val Gray7 = Color(0xFF818181)
val Gray8 = Color(0xFF717171)
val Gray9 = Color(0xFF656565)
val Gray10 = Color(0xFF545454)
val Gray11 = Color(0xFF3F3F3F)
val Gray12 = Color(0xFF282828)
val Gray13 = Color(0xFF121212)

//Opacity
val OpacityGray13_60 = Color(0x99121212)
val OpacityGray13_40 = Color(0x66121212)
val OpacityGray13_10 = Color(0x1A121212)
val OpacityGray13_5 = Color(0x0D121212)
val OpacityGray1_30 = Color(0x4DFFFFFF)
val OpacityGray1_10 = Color(0x1AFFFFFF)

//Shadow
val ShadowColor = Color(0x1A000000)

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

    //Shadow Colors : 디자인시스템에 없어서 임의로 변수명 설정
    val shadowColor: Color,
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
    opacityGray1Per10 = OpacityGray1_10,
    shadowColor = ShadowColor,
)
