package com.sopt.shinmungo.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.sopt.shinmungo.core.designsystem.color.LocalColorProvider
import com.sopt.shinmungo.core.designsystem.color.ShinMunGoColors

object ShinMunGoTheme {
    val color: ShinMunGoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current
}