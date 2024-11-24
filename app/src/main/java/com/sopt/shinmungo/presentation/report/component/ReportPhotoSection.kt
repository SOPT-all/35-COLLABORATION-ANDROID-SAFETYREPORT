package com.sopt.shinmungo.presentation.report.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerIconButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.R
import com.sopt.shinmungo.presentation.report.PhotoItem
import com.sopt.shinmungo.presentation.report.ReportViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ReportPhotoSection(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Column {
                ReportSectionTitle(
                    text = "사진",
                    onInfoIconClick = { /* 관련 다이얼로그 연결 */ }
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row() {
                    Text(
                        text = "다음 사진 첨부까지 :",
                        style = ShinMunGoTheme.typography.caption3,
                        color = ShinMunGoTheme.color.primary
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "4분 59초",
                        style = ShinMunGoTheme.typography.caption3,
                        color = ShinMunGoTheme.color.primary
                    )
                }
            }

            Spacer(modifier = modifier.weight(1f))

            RoundedCornerIconButton(
                icon = R.drawable.ic_report_camera_24px,
                isButtonActive = true,
                onButtonClick = { /* 초 카운트 다운 시작 */ }
            )

            Spacer(modifier = modifier.width(10.dp))

            RoundedCornerIconButton(
                icon = R.drawable.ic_folder_line_black_24px,
                isButtonActive = true,
                onButtonClick = { /* 갤러리 화면으로 이동 */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportPhotoSectionPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ReportPhotoSection(
            viewModel = viewModel
        )
    }
}