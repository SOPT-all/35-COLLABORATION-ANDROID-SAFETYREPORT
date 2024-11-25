package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun SubmitCompleteDialog(
    onDismissRequest: () -> Unit,
    onCloseClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    CustomDialog(
        title = "알림",
        icon = Icons.Default.Close,
        onDismissRequest = onDismissRequest,
        onIconClick = onCloseClick
    ) {
        Text(
            text = "신고 내용이 정상적으로 접수되었습니다.",
            style = ShinMunGoTheme.typography.body2,
            color = ShinMunGoTheme.color.gray13,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { onDismissRequest() },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShinMunGoTheme.color.gray1,
                    contentColor = ShinMunGoTheme.color.gray9
                ),
                border = BorderStroke(1.dp, ShinMunGoTheme.color.gray9)
            ) {
                Text(
                    text = "닫기",
                    style = ShinMunGoTheme.typography.body6
                )
            }
            Button(
                onClick = { onHomeClick() },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShinMunGoTheme.color.gray1,
                    contentColor = ShinMunGoTheme.color.gray9
                ),
                border = BorderStroke(1.dp, ShinMunGoTheme.color.gray9)
            ) {
                Text(
                    text = "홈으로",
                    style = ShinMunGoTheme.typography.body6
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewSubmitCompleteDialog() {
    ShinMunGoTheme {
        SubmitCompleteDialog(
            onDismissRequest = {},
            onCloseClick = {},
            onHomeClick = {}
        )
    }
}