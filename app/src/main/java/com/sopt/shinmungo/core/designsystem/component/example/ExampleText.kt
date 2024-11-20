package com.sopt.shinmungo.core.designsystem.component.example

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 컴포넌트 예시를 위한 텍스트 컴포저블
 *
 * @param text 텍스트 내용
 * @param style 텍스트 스타일
 * @param modifier 수정자
 */

@Composable
fun ExampleText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = style,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ExampleTextPreview() {
    ShinMunGoTheme {
        ExampleText(
            text = "This is an example text",
            style = ShinMunGoTheme.typography.heading1
        )
    }
}