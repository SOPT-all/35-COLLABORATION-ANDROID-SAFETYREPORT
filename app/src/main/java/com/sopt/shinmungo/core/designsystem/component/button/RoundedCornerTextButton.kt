package com.sopt.shinmungo.core.designsystem.component.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable

/**
 * 테두리가 없는 둥근+텍스트 버튼 컴포저블
 *
 * @param text 버튼에 들어갈 글자
 * @param textStyle 글자 스타일
 * @param textColor 글자 색
 * @param borderLineColor 테두리 색 (default 값 null)
 * @param backgroundColor 버튼 배경색
 * @param roundedCornerShape 테두리 둥근 정도
 * @param modifier 수정자
 * @param buttonOnClick 버튼 클릭 시 작동되는 함수
 */

@Composable
fun RoundedCornerTextButton(
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    borderLineColor: Color? = null,
    backgroundColor: Color,
    roundedCornerShape: RoundedCornerShape,
    modifier: Modifier = Modifier,
    buttonOnClick: () -> Unit,
) {
    BaseRoundedCornerTextButton(
        text = text,
        textStyle = textStyle,
        textColor = textColor,
        isBorderApplied = false,
        borderLineColor = borderLineColor,
        backgroundColor = backgroundColor,
        roundedCornerShape = roundedCornerShape,
        modifier = modifier.noRippleClickable { buttonOnClick() }
    )
}

@Preview
@Composable
fun RoundedCornerTextButton_Gray_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "취소",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.gray1,
            borderLineColor = null,
            backgroundColor = ShinMunGoTheme.color.gray9,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .width(135.dp)
                .height(48.dp),
            buttonOnClick = { }
        )
    }
}

@Preview
@Composable
fun RoundedCornerTextButton_Orange_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.gray1,
            borderLineColor = null,
            backgroundColor = ShinMunGoTheme.color.primary,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .width(135.dp)
                .height(48.dp),
            buttonOnClick = { }
        )
    }
}

@Preview
@Composable
fun RoundedCornerTextButton_SelectButton_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "선택하기",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.gray1,
            borderLineColor = null,
            backgroundColor = ShinMunGoTheme.color.primary,
            roundedCornerShape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .width(92.dp)
                .height(34.dp),
            buttonOnClick = { }
        )
    }
}

@Preview
@Composable
fun RoundedCornerTextButton_Category_Preview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "소방차 전용구역",
            textStyle = ShinMunGoTheme.typography.body6,
            textColor = ShinMunGoTheme.color.gray13,
            borderLineColor = null,
            backgroundColor = ShinMunGoTheme.color.gray1,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            buttonOnClick = { }
        )
    }
}