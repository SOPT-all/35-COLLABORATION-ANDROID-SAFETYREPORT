package com.sopt.shinmungo.presentation.report

import androidx.compose.runtime.Composable
import com.sopt.shinmungo.presentation.dialog.FireTruckIllegalParkingDialog
import com.sopt.shinmungo.presentation.dialog.MediaSelectionDialog
import com.sopt.shinmungo.presentation.dialog.PhotoDeleteConfirmationDialog
import com.sopt.shinmungo.presentation.dialog.PhotoSizeLimitDialog
import com.sopt.shinmungo.presentation.dialog.PhotoTimeLimitDialog
import com.sopt.shinmungo.presentation.dialog.ResetConfirmationDialog
import com.sopt.shinmungo.presentation.dialog.SubmitCompleteDialog
import com.sopt.shinmungo.presentation.report.state.ReportDialogState
import com.sopt.shinmungo.presentation.report.type.ReportDialogType

/**
 * 신고 화면에서 등장하는 다이얼로그들을 관리하기 위한 스크린 컴포넌트
 *
 * @param dialogState 다이얼로그들의 가시성 관리를 위한 상태 클래스
 * @param onDismissRequest 확인/닫기/외부영역을 터치하면 발생하는 이벤트
 * @param onPhotoDeleteConfirm 사진 삭제 확인 버튼 클릭 시 호출되는 콜백
 * @param onSubmitComplete 신고 완료 후 "홈으로" 버튼 클릭 시 호출되는 콜백
 * @param onResetClick 신고 완료 후 닫기 클릭 시 호출되는 콜백
 */

@Composable
fun ReportDialogScreen(
    dialogState: ReportDialogState,
    onDismissRequest: (ReportDialogType) -> Unit,
    onNavigateToGallery: () -> Unit,
    onPhotoDeleteConfirm: () -> Unit,
    onSubmitComplete: () -> Unit,
    onResetClick: () -> Unit,
) {
    with(dialogState) {
        if (isIllegalParkingDialogVisible) {
            FireTruckIllegalParkingDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.ILLEGAL_PARKING) }
            )
        }

        if (isCameraSelectionDialogVisible) {
            MediaSelectionDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.CAMERA_SELECTION) },
            )
        }

        if (isGallerySelectionDialogVisible) {
            MediaSelectionDialog(
                onDismissRequest = {
                    onNavigateToGallery()
                    onDismissRequest(ReportDialogType.GALLERY_SELECTION)
                },
            )
        }

        if (isPhotoDeleteDialogVisible) {
            PhotoDeleteConfirmationDialog(
                onConfirmClick = {
                    onPhotoDeleteConfirm()
                    onDismissRequest(ReportDialogType.PHOTO_DELETE)
                },
                onDismissRequest = { onDismissRequest(ReportDialogType.PHOTO_DELETE) }
            )
        }

        if (isPhotoSizeLimitDialogVisible) {
            PhotoSizeLimitDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.PHOTO_SIZE_LIMIT) }
            )
        }

        if (isPhotoTimeLimitDialogVisible) {
            PhotoTimeLimitDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.PHOTO_TIME_LIMIT) }
            )
        }

        if (isResetConfirmationDialogVisible) {
            ResetConfirmationDialog(
                onConfirmClick = {},
                onDismissRequest = {}
            )
        }

        if (isSubmitCompleteDialogVisible) {
            SubmitCompleteDialog(
                onHomeClick = onSubmitComplete,
                onCloseClick = onResetClick,
                onDismissRequest = onResetClick,
            )
        }
    }
}