package com.sopt.shinmungo.core.designsystem.component.progress

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 프로그래스 표시를 위한 컴포저블입니다.
 *
 * @param progress 프로그래스의 진행 정도입니다.
 * @param modifier 컴포저블의 수정자입니다.
 * @param color 프로그래스의 진행 정도의 색상입니다.
 * @param trackColor 프로그래스의 뒷 배경 색상입니다.
 * @param strokeCap 프로그래스의 선 종류입니다.
 */

@Composable
fun CommonProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = ShinMunGoTheme.color.primary,
    trackColor: Color = ShinMunGoTheme.color.gray3,
    strokeCap: StrokeCap = StrokeCap.Round
) {
    LinearProgressIndicator(
        progress = { progress },
        color = color,
        trackColor = trackColor,
        strokeCap = strokeCap,
        modifier = modifier
    )
}

@Preview
@Composable
private fun CommonProgressIndicatorPreview() {
    ShinMunGoTheme {
        CommonProgressIndicator(
            progress = 0.7f,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(start = 5.dp, end = 5.dp)
        )
    }
}