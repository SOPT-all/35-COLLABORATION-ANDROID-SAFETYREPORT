package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun PhotoSizeLimitDialog(
    onDismissRequest: () -> Unit
) {
    CustomDialog(
        title = "알림",
        icon = Icons.Default.Close,
        onDismissRequest = onDismissRequest,
        onIconClick = onDismissRequest
    ) {
        Text(
            text = buildAnnotatedString {
                append("사진은 ")
                withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                    append("각 30MB")
                }
                append(", ")
                withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                    append("총 180MB")
                }
                append("까지만 첨부 가능합니다.")
            },
            style = ShinMunGoTheme.typography.body2,
            color = ShinMunGoTheme.color.gray13,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = { onDismissRequest() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = ShinMunGoTheme.color.gray1,
                contentColor = ShinMunGoTheme.color.gray9
            ),
            border = BorderStroke(1.dp, ShinMunGoTheme.color.gray9)
        ) {
            Text(
                text = "확인",
                style = ShinMunGoTheme.typography.body6
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhotoSizeLimitDialog() {
    ShinMunGoTheme {
        PhotoSizeLimitDialog(
            onDismissRequest = {}
        )
    }
}