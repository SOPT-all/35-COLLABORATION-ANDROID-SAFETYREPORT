package com.sopt.shinmungo.ui.theme

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
}

@Composable
fun ProvideShinMunGoColors(
    colors: ShinMunGoColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides colors,
        content = content
    )
}

@Composable
fun ShinMunGoTheme(
    backgroundColor: Color = Gray1,
    content: @Composable () -> Unit
) {
    ProvideShinMunGoColors(
        colors = defaultShinMunGoColors
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = backgroundColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }

        MaterialTheme(
            content = content
        )
    }
}