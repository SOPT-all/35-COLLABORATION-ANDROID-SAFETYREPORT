package com.sopt.shinmungo.core.designsystem.component.button

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable

/**
 * 체크 버튼 + 텍스트 + (선택사항)info 아이콘 컴포저블
 *
 * @param text 버튼에 들어갈 글자
 * @param textStyle 글자 스타일
 * @param textColor 글자 색
 * @param isChecked 버튼이 체크 상태인지 표시하는 값
 * @param isIconApplied 아이콘이 우측에 붙는지 표시하는 값
 * @param modifier 수정자
 * @param buttonOnClick 버튼 클릭 시 작동되는 함수
 */

@Composable
fun CheckButtonWithTextInfoIcon(
    text: String,
    textStyle: TextStyle = ShinMunGoTheme.typography.caption3,
    textColor: Color = ShinMunGoTheme.color.gray13,
    isChecked: Boolean,
    isIconApplied: Boolean,
    modifier: Modifier = Modifier,
    buttonOnClick: () -> Unit,
) {
    val icon = if (isChecked) R.drawable.ic_checkbox_selected_16px else R.drawable.ic_checkbox_empty_16px

    Row(
        modifier = modifier
            .noRippleClickable { buttonOnClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = stringResource(R.string.check_button_content_description),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        if (isIconApplied) {
            TextWithInfoIcon(
                text = text,
                textStyle = textStyle,
                textColor = textColor,
                spacerModifier = Modifier.width(4.dp)
            )
        } else {
            Text(
                text = text,
                style = textStyle,
                color = textColor
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CheckButtonWithTextInfoIconPreview(modifier: Modifier = Modifier) {
    val isChecked = true
    ShinMunGoTheme {
        CheckButtonWithTextInfoIcon(
            text = "신고 내용 공유 동의",
            isChecked = isChecked,
            isIconApplied = true,
            modifier = modifier,
            buttonOnClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckButtonWithTextInfoIcon_NoIcon_Preview(modifier: Modifier = Modifier) {
    val isChecked = false
    ShinMunGoTheme {
        CheckButtonWithTextInfoIcon(
            text = "추천 단어",
            isChecked = isChecked,
            isIconApplied = false,
            modifier = modifier,
            buttonOnClick = { }
        )
    }
}