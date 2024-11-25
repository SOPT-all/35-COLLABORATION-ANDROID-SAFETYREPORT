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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerIconButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.R
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import com.sopt.shinmungo.presentation.report.ReportViewModel
import com.sopt.shinmungo.presentation.report.type.ReportSectionType

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ReportPhotoSection(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    val photoItems = viewModel.photoList.collectAsStateWithLifecycle(initialValue = emptyList())
    val cameraCooldownTime = viewModel.cameraCooldownTime.collectAsStateWithLifecycle(0)
    val isCameraButtonActive = viewModel.isCameraButtonActive.collectAsStateWithLifecycle(true)

    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Column {
                ReportSectionTitle(
                    text = ReportSectionType.PHOTO.type,
                    onInfoIconClick = { /* 관련 다이얼로그 연결 */ }
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (!isCameraButtonActive.value) {
                    Row() {
                        Text(
                            text = stringResource(R.string.report_to_next_photo_apply),
                            style = ShinMunGoTheme.typography.caption3,
                            color = ShinMunGoTheme.color.primary
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = formatTime(cameraCooldownTime.value),
                            style = ShinMunGoTheme.typography.caption3,
                            color = ShinMunGoTheme.color.primary
                        )
                    }
                }
            }

            Spacer(modifier = modifier.weight(1f))

            RoundedCornerIconButton(
                icon = R.drawable.ic_report_camera_24px,
                isButtonActive = isCameraButtonActive.value,
                onButtonClick = {
                    viewModel.startCameraCooldown(300)
                }
            )

            Spacer(modifier = modifier.width(10.dp))

            RoundedCornerIconButton(
                icon = R.drawable.ic_folder_line_black_24px,
                isButtonActive = true,
                onButtonClick = {
                    /* 갤러리 화면으로 이동 */
                    val newPhotoList = arrayListOf( // 임시로 값 연결
                        ReportPhotoItem(1, "https://via.placeholder.com/70"),
                        ReportPhotoItem(2, "https://via.placeholder.com/70"),
                        ReportPhotoItem(3, "https://via.placeholder.com/70"),
                        ReportPhotoItem(4, "https://via.placeholder.com/70"),
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

@SuppressLint("DefaultLocale")
fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%d분 %02d초", minutes, remainingSeconds)
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