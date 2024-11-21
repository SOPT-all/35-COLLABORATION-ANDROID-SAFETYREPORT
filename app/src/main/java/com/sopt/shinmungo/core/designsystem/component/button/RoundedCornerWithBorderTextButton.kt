package com.sopt.shinmungo.core.designsystem.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 테두리가 있는 둥근테두리+텍스트 버튼 컴포저블
 *
 * @param text 버튼에 들어갈 글자
 * @param textStyle 글자 스타일
 * @param textColor 글자 색상
 * @param borderLineColor 테두리 색 (default 값 null)
 * @param backgroundColor 버튼 배경 색
 * @param roundedCornerShape 테두리 둥근 정도
 * @param modifier 수정자
 */

@Composable
fun RoundedCornerWithBorderTextButton(
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    borderLineColor: Color,
    backgroundColor: Color,
    roundedCornerShape: RoundedCornerShape,
    modifier: Modifier = Modifier
) {
    BaseRoundedCornerTextButton(
        text = text,
        textStyle = textStyle,
        textColor = textColor,
        isBorderApplied = true,
        borderLineColor = borderLineColor,
        backgroundColor = backgroundColor,
        roundedCornerShape = roundedCornerShape,
        modifier = modifier
    )
}


@Preview
@Composable
fun RoundedCornerWithBorderTextButton_isActivated_Preview(modifier: Modifier = Modifier) {
    val isActivated = true
    ShinMunGoTheme {
        RoundedCornerWithBorderTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = if (isActivated) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray6,
            borderLineColor = if (isActivated) ShinMunGoTheme.color.primaryLight else ShinMunGoTheme.color.gray6,
            backgroundColor = if (isActivated) ShinMunGoTheme.color.gray1 else ShinMunGoTheme.color.gray4,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}

@Preview
@Composable
fun RoundedCornerWithBorderTextButton_isNotActivated_Preview(modifier: Modifier = Modifier) {
    val isActivated = false
    ShinMunGoTheme {
        RoundedCornerWithBorderTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = if (isActivated) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray6,
            borderLineColor = if (isActivated) ShinMunGoTheme.color.primaryLight else ShinMunGoTheme.color.gray6,
            backgroundColor = if (isActivated) ShinMunGoTheme.color.gray1 else ShinMunGoTheme.color.gray4,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}