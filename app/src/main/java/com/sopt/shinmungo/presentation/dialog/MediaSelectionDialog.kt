package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun MediaSelectionDialog(
    onDismissRequest: () -> Unit
) {
    CustomDialog(
        title = "미디어 선택",
        modifier = Modifier.width(321.dp),
        icon = ImageVector.vectorResource(id = R.drawable.icn_sound_white_24px),
        onDismissRequest = onDismissRequest
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ShinMunGoTheme.color.opacityGray13Per5,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_alert_line_red_16px),
                        contentDescription = "경고 아이콘",
                        tint = ShinMunGoTheme.color.primaryRed,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "불법주차 5분 이상인 사진 2장 이상 첨부",
                        style = ShinMunGoTheme.typography.caption2,
                        color = ShinMunGoTheme.color.primaryRed
                    )
                }
            }

            // 두 번째 메시지
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .background(
                        color = ShinMunGoTheme.color.opacityGray13Per5,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)// 위 박스와 간격
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_alert_line_red_16px),
                        contentDescription = "경고 아이콘",
                        tint = ShinMunGoTheme.color.gray10,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "사진 각 30MB, 총 180MB까지 첨부 가능",
                        style = ShinMunGoTheme.typography.body6.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 14.sp
                        ),
                        color = ShinMunGoTheme.color.gray10
                    )
                }
            }
            // 신고 방법 이미지
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mediaselection2), // 신고 방법 이미지
                    contentDescription = "신고 방법 이미지",
                    modifier = Modifier
                        .width(291.dp) // 사진의 정확한 너비 설정
                        .height(252.dp) // 사진의 정확한 높이 설정
                        .background(
                            color = ShinMunGoTheme.color.gray1,
                            shape = RoundedCornerShape(5.dp)
                        )
                )
            }

            // 확인 버튼
            RoundedCornerTextButton(
                text = "확인",
                textStyle = ShinMunGoTheme.typography.body4,
                textColor = ShinMunGoTheme.color.gray8,
                borderLineColor = ShinMunGoTheme.color.gray5,
                backgroundColor = ShinMunGoTheme.color.gray1,
                roundedCornerShape = RoundedCornerShape(10.dp),
                onButtonClick = onDismissRequest,
                modifier = Modifier
                    .width(281.dp)
                    .height(48.dp)
                    .padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMediaSelectionDialog() {
    ShinMunGoTheme {
        MediaSelectionDialog(
            onDismissRequest = { /* 닫기 동작 */ }
        )
    }
}
