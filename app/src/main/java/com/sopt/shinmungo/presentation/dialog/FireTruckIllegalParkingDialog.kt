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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun FireTruckIllegalParkingDialog(
    onDismissRequest: () -> Unit
) {
    CustomDialog(
        title = "소방차 전용구역 불법주차",
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.parking4),
                    contentDescription = "Illegal Parking Example 1",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(143.dp) // 폭 143px
                        .height(109.dp) // 높이 109px
                        .padding(end = 4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.parking3),
                    contentDescription = "Illegal Parking Example 2",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(143.dp) // 폭 143px
                        .height(109.dp) // 높이 109px
                        .padding(start = 4.dp)
                )
            }


            Text(
                text = "공동주택 소방차 전용구역에 주차한 차량 전용구역 진입로에 물건들을 쌓는 행위(상시 신고 가능)",
                style = ShinMunGoTheme.typography.body9.copy(
                ),
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "동일한 위치 및 방향 (전면 2장 또는 후면 2장)에서 " +
                        "안전신문고 앱으로 시차가 5분 이상인 사진을 2장 이상 첨부해야 하며 (4장까지 가능), " +
                        "모든 신고 사진에 소방차 전용구역(노면 표시), 전용구역 위치(동수 표시, 특정적인 구조물 표시), " +
                        "차량번호가 식별 가능해야 합니다.",
                style = ShinMunGoTheme.typography.body9.copy(
                ),
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 19.dp, bottom = 30.dp)
            )

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
fun PreviewFireTruckIllegalParkingDialog() {
    ShinMunGoTheme {
        FireTruckIllegalParkingDialog(
            onDismissRequest = { /* 닫기 동작 */ }
        )
    }
}
