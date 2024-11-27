package com.sopt.shinmungo.core.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 여러 색상으로 이뤄진 텍스트를 표시하는 컴포저블입니다.
 *
 * @param pairList 텍스트와 색상 쌍의 목록입니다.
 * @param modifier 컴포저블의 수정자입니다.
 * @param style 텍스트 스타일입니다.
 */

@Composable
fun ColorAnnotatedText(
    pairList: List<Pair<String, Color>>,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default,
) {
    Text(
        modifier = modifier,
        style = style,
        text = buildAnnotatedString {
            pairList.forEach { (text, color) ->
                withStyle(style = SpanStyle(color = color)) {
                    append(text)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ColorAnnotatedTextPreview() {
    ShinMunGoTheme {
        ColorAnnotatedText(
            pairList = listOf(
                Pair("Hello", ShinMunGoTheme.color.primary),
                Pair(" World", ShinMunGoTheme.color.gray13)
            ),
            style = ShinMunGoTheme.typography.body3
        )
    }
}