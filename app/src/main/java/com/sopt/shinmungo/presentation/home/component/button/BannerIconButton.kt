package com.sopt.shinmungo.presentation.home.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable

@Composable
fun BannerIconButton(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = "",
        tint = ShinMunGoTheme.color.gray1,
        modifier = modifier
            .background(
                color = ShinMunGoTheme.color.opacityGray13Per40,
                shape = RoundedCornerShape(5.dp)
            )
            .noRippleClickable(onClick),
    )
}