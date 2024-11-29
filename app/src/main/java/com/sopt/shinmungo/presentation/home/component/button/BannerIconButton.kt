package com.sopt.shinmungo.presentation.home.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
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
        contentDescription = EMPTY_DESCRIPTION,
        tint = ShinMunGoTheme.color.gray1,
        modifier = modifier
            .background(
                color = ShinMunGoTheme.color.opacityGray13Per40,
                shape = RoundedCornerShape(5.dp)
            )
            .noRippleClickable(onClick),
    )
}

private const val EMPTY_DESCRIPTION = ""

@Preview(showBackground = true)
@Composable
private fun BannerIconButtonPreview() {
    ShinMunGoTheme {
        BannerIconButton(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_24),
            onClick = {}
        )
    }
}