package com.sopt.shinmungo.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.sopt.shinmungo.core.designsystem.color.LocalColorProvider
import com.sopt.shinmungo.core.designsystem.color.ShinMunGoColors
import com.sopt.shinmungo.core.designsystem.type.LocalTypographyProvider
import com.sopt.shinmungo.core.designsystem.type.ShinMunGoTypography

object ShinMunGoTheme {
    val color: ShinMunGoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current

    val typography: ShinMunGoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypographyProvider.current
}