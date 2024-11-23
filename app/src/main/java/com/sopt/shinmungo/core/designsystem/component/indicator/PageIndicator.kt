package com.sopt.shinmungo.core.designsystem.component.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun PageIndicator(
    imageCount: Int,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    backgroundColor: Color = ShinMunGoTheme.color.opacityGray13Per40,
    selectedColor: Color = ShinMunGoTheme.color.gray1,
    unselectedColor: Color = ShinMunGoTheme.color.opacityGray1Per30
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = backgroundColor)
            .wrapContentSize()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(imageCount) { iteration ->
            val color =
                if (pagerState.currentPage % imageCount == iteration) selectedColor else unselectedColor
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PageIndicatorPreview() {
    ShinMunGoTheme {
        PageIndicator(
            imageCount = 3,
            pagerState = rememberPagerState{3}
        )
    }
}