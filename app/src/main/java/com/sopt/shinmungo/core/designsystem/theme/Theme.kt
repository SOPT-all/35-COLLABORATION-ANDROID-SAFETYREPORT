package com.sopt.shinmungo.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

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

@Composable
fun ShinMunGoTheme(
    customStatusBarColor: Color = Gray13,
    content: @Composable () -> Unit
) {
    ProvideShinMunGoColors(
        colors = defaultShinMunGoColors,
        typography = defaultShinMunGoTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = customStatusBarColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }

        MaterialTheme(
            content = content
        )
    }
}

@Composable
fun ProvideShinMunGoColors(
    colors: ShinMunGoColors,
    typography: ShinMunGoTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides colors,
        LocalTypographyProvider provides typography,
        content = content
    )
}