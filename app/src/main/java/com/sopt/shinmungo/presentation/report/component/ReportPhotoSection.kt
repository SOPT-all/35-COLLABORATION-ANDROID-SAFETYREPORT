package com.sopt.shinmungo.presentation.report.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    val photoItems = viewModel.photoList.collectAsStateWithLifecycle(initialValue = emptyList())

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
                onButtonClick = {
                    /* 갤러리 화면으로 이동 */
                    val newPhotoList = arrayListOf( /* 임시로 값 연결 */
                        PhotoItem(1, "https://via.placeholder.com/70"),
                        PhotoItem(2, "https://via.placeholder.com/70"),
                        PhotoItem(3, "https://via.placeholder.com/70"),
                        PhotoItem(4, "https://via.placeholder.com/70"),
                        PhotoItem(5, "https://via.placeholder.com/70"),
                        PhotoItem(6, "https://via.placeholder.com/70"),
                        PhotoItem(7, "https://via.placeholder.com/70"),
                        PhotoItem(8, "https://via.placeholder.com/70"),
                        PhotoItem(9, "https://via.placeholder.com/70"),
                    )
                    viewModel.updatePhotoList(newPhotoList)
                }
            )
        }

        Spacer(modifier = Modifier.height(11.dp))

        if (photoItems.value.isEmpty()) {
            BoxWhenPhotoListEmpty()
        } else {
            ShowPhotoList(viewModel)
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