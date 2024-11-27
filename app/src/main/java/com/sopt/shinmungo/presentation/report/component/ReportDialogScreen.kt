package com.sopt.shinmungo.presentation.report.component

import androidx.compose.runtime.Composable
import com.sopt.shinmungo.presentation.dialog.FireTruckIllegalParkingDialog
import com.sopt.shinmungo.presentation.dialog.MediaSelectionDialog
import com.sopt.shinmungo.presentation.dialog.PhotoDeleteConfirmationDialog
import com.sopt.shinmungo.presentation.dialog.PhotoSizeLimitDialog
import com.sopt.shinmungo.presentation.dialog.PhotoTimeLimitDialog
import com.sopt.shinmungo.presentation.dialog.ResetConfirmationDialog
import com.sopt.shinmungo.presentation.dialog.SubmitCompleteDialog
import com.sopt.shinmungo.presentation.dialog.SubmitConfirmDialog
import com.sopt.shinmungo.presentation.report.state.ReportDialogState
import com.sopt.shinmungo.presentation.report.type.ReportDialogType

/**
 * 신고 화면에서 등장하는 다이얼로그들을 관리하기 위한 스크린 컴포넌트
 *
 * @param dialogState 다이얼로그들의 가시성 관리를 위한 상태 클래스
 * @param onDismissRequest 확인/닫기/외부영역을 터치하면 발생하는 이벤트
 * @param onCameraSelectionConfirm 사진 안내 다이얼로그의 확인 버튼을 누르면 발생하는 이벤트
 * @param onGallerySelectionConfirm 갤러리 선택 다이얼로그의 확인 버튼을 누르면 발생하는 이벤트
 * @param onResetReturnConfirm 뒤로 가기 다이얼로그의 확인 버튼을 누르면 발생하는 이벤트
 * @param onPhotoDeleteConfirm 사진 삭제 확인 버튼 클릭 시 호출되는 콜백
 * @param onSubmitComplete 신고 완료 후 "홈으로" 버튼 클릭 시 호출되는 콜백
 * @param onResetClick 신고 완료 후 닫기를 클릭하여 입력들을 초기화시키기 이벤트
 */

@Composable
fun ReportDialogScreen(
    dialogState: ReportDialogState,
    onDismissRequest: (ReportDialogType) -> Unit,
    onCameraSelectionConfirm: () -> Unit,
    onGallerySelectionConfirm: () -> Unit,
    onResetReturnConfirm: () -> Unit,
    onPhotoDeleteConfirm: () -> Unit,
    onResetClick: () -> Unit,
    onSubmitConfirmClick: () -> Unit,
    onSubmitComplete: () -> Unit,
) {
    with(dialogState) {
        if (isIllegalParkingDialogVisible) {
            FireTruckIllegalParkingDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.ILLEGAL_PARKING) }
            )
        }

        if (isCameraSelectionDialogVisible) {
            MediaSelectionDialog(
                onDismissRequest = {
                    onCameraSelectionConfirm()
                    onDismissRequest(ReportDialogType.CAMERA_SELECTION)
                },
            )
        }

        if (isGallerySelectionDialogVisible) {
            MediaSelectionDialog(
                onDismissRequest = {
                    onGallerySelectionConfirm()
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
                onConfirmClick = onResetReturnConfirm,
                onDismissRequest = { onDismissRequest(ReportDialogType.RESET) }
            )
        }

        if (isSubmitConfirmDialogVisible) {
            SubmitConfirmDialog(
                onDismissRequest = { onDismissRequest(ReportDialogType.SUBMIT_CONFIRM) },
                onConfirmClick = {
                    onDismissRequest(ReportDialogType.SUBMIT_CONFIRM)
                    onSubmitConfirmClick()
                }
            )
        }

        if (isSubmitCompleteDialogVisible) {
            SubmitCompleteDialog(
                onHomeClick = onSubmitComplete,
                onCloseClick = {
                    onDismissRequest(ReportDialogType.SUBMIT)
                    onResetClick()
                },
                onDismissRequest = {
                    onDismissRequest(ReportDialogType.SUBMIT)
                    onResetClick()
                }
            )
        }
    }
}
