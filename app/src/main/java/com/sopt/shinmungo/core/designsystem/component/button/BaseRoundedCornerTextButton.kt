package com.sopt.shinmungo.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 둥근테두리+text 버튼 Base 컴포저블
 *
 * @param text 버튼에 들어갈 글자
 * @param textStyle 글자 스타일
 * @param textColor 글자 색상
 * @param isBorderApplied 테두리 적용 여부
 * @param borderLineColor 테두리 색 (default 값 null)
 * @param backgroundColor 버튼 배경 색
 * @param roundedCornerShape 테두리 둥근 정도
 * @param modifier 수정자
 */

@Composable
fun BaseRoundedCornerTextButton(
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    isBorderApplied: Boolean,
    borderLineColor: Color? = null,
    backgroundColor: Color,
    roundedCornerShape: RoundedCornerShape,
    modifier: Modifier = Modifier
) {
    //테두리 색을 테두리가 있는 경우 테두리 색 적용, 없는 경우 배경색을 적용
    val lineColor = if (isBorderApplied) borderLineColor else backgroundColor

    Box(
        modifier = Modifier
            .clip(roundedCornerShape)
            .background(backgroundColor)
            .border(width = 1.dp, color = lineColor!!, shape = roundedCornerShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun BaseRoundedCornerTextButton_No_Border_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        BaseRoundedCornerTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.gray1,
            isBorderApplied = false,
            borderLineColor = null,
            backgroundColor = ShinMunGoTheme.color.primary,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
        )
    }
}

@Preview
@Composable
fun BaseRoundedCornerTextButton_With_Border_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        BaseRoundedCornerTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.primary,
            isBorderApplied = true,
            borderLineColor = ShinMunGoTheme.color.primaryLight,
            backgroundColor = ShinMunGoTheme.color.gray1,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
        )
    }
}