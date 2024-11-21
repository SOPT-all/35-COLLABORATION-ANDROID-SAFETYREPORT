package com.sopt.shinmungo.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 둥근테두리+아이콘 버튼 컴포저블
 *
 * @param icon 아이콘 이미지
 * @param isButtonActive 버튼의 활성화 여부
 * @param modifier 수정자
 */

@Composable
fun RoundedCornerIconButton(
    @DrawableRes icon: Int,
    isButtonActive: Boolean,
    modifier: Modifier = Modifier,
) {
    val borderLineColor =
        if (isButtonActive) ShinMunGoTheme.color.gray7 else ShinMunGoTheme.color.gray5
    val iconLineColor =
        if (isButtonActive) ShinMunGoTheme.color.gray8 else ShinMunGoTheme.color.gray6

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(size = 8.dp))
            .background(ShinMunGoTheme.color.gray1)
            .border(width = 1.dp, color = borderLineColor, shape = RoundedCornerShape(size = 8.dp))
            .padding(horizontal = 14.dp, vertical = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = "아이콘버튼",
            tint = iconLineColor,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview
@Composable
fun RoundedCornerIconButtonPreview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerIconButton(
            modifier = Modifier,
            icon = R.drawable.ic_report_camera_24px,
            isButtonActive = false
        )
    }
}

@Preview
@Composable
fun RoundedCornerIconButtonActivePreview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerIconButton(
            modifier = Modifier,
            icon = R.drawable.ic_report_camera_24px,
            isButtonActive = true
        )
    }
}