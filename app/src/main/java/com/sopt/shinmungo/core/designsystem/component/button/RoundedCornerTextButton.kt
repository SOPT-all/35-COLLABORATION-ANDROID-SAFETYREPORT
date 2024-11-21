package com.sopt.shinmungo.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    //테두리 색을 테두리가 있는 경우 테두리 색 적용, 없는 경우 배경색을 적용
    val lineColor = borderLineColor ?: backgroundColor

    Box(
        modifier = Modifier
            .clip(roundedCornerShape)
            .background(backgroundColor)
            .border(width = 1.dp, color = lineColor, shape = roundedCornerShape)
            .noRippleClickable { buttonOnClick() },
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
                .padding(vertical = 15.dp),
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
                .padding(vertical = 15.dp),
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
                .padding(vertical = 8.dp),
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
                .padding(vertical = 16.dp),
            buttonOnClick = { }
        )
    }
}

@Preview
@Composable
fun RoundedCornerTextButton_isActivated_Preview(modifier: Modifier = Modifier) {
    val isActivated = true
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = if (isActivated) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray6,
            borderLineColor = if (isActivated) ShinMunGoTheme.color.primaryLight else ShinMunGoTheme.color.gray6,
            backgroundColor = if (isActivated) ShinMunGoTheme.color.gray1 else ShinMunGoTheme.color.gray4,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            buttonOnClick = { }
        )
    }
}

@Preview
@Composable
fun RoundedCornerTextButton_isNotActivated_Preview(modifier: Modifier = Modifier) {
    val isActivated = false
    ShinMunGoTheme {
        RoundedCornerTextButton(
            text = "확인",
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = if (isActivated) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray6,
            borderLineColor = if (isActivated) ShinMunGoTheme.color.primaryLight else ShinMunGoTheme.color.gray6,
            backgroundColor = if (isActivated) ShinMunGoTheme.color.gray1 else ShinMunGoTheme.color.gray4,
            roundedCornerShape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            buttonOnClick = { }
        )
    }
}