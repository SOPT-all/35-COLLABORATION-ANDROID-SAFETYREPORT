package com.sopt.shinmungo.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 텍스트+Info 아이콘 컴포저블
 *
 * @param text 왼쪽에 나타낼 글자
 * @param textStyle 글자 스타일
 * @param textColor 글자 색
 * @param spacerModifier 글자와 아이콘 사이 간격
 * @param icon 버튼 아이콘 이미지 (default 값 ic_info_circle_16px)
 * @param modifier 수정자
 */

@Composable
fun TextWithInfoIcon(
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    spacerModifier: Modifier,
    @DrawableRes icon: Int = R.drawable.ic_info_circle_16px,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
        Spacer(modifier = spacerModifier)
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = "Info아이콘"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextWithInfoIconPreview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        TextWithInfoIcon(
            text = "소방차 전용구역",
            textStyle = ShinMunGoTheme.typography.body1,
            textColor = ShinMunGoTheme.color.gray13,
            spacerModifier = Modifier.width(8.dp)
        )
    }
}