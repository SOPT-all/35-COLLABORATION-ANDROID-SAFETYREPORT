package com.sopt.shinmungo.presentation.report.state

data class ReportDialogState(
    val isIllegalParkingDialogVisible: Boolean = false,
    val isCameraSelectionDialogVisible: Boolean = false,
    val isGallerySelectionDialogVisible: Boolean = false,
    val isPhotoDeleteDialogVisible: Boolean = false,
    val isPhotoSizeLimitDialogVisible: Boolean = false,
    val isPhotoTimeLimitDialogVisible: Boolean = false,
    val isResetConfirmationDialogVisible: Boolean = false,
    val isSubmitConfirmDialogVisible: Boolean = false,
    val isSubmitCompleteDialogVisible: Boolean = false
)
