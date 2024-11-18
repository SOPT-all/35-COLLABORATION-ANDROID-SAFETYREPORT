package com.sopt.shinmungo.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.sopt.shinmungo.core.designsystem.color.Gray1
import com.sopt.shinmungo.core.designsystem.color.LocalColorProvider
import com.sopt.shinmungo.core.designsystem.color.ShinMunGoColors
import com.sopt.shinmungo.core.designsystem.color.defaultShinMunGoColors
import com.sopt.shinmungo.core.designsystem.type.LocalTypographyProvider
import com.sopt.shinmungo.core.designsystem.type.ShinMunGoTypography
import com.sopt.shinmungo.core.designsystem.type.defaultShinMunGoTypography

@Composable
fun ShinMunGoTheme(
    backgroundColor: Color = Gray1,
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