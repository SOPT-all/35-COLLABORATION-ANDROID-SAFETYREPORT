package com.sopt.shinmungo.presentation.report

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import com.sopt.shinmungo.presentation.report.component.DropdownCategory
import com.sopt.shinmungo.presentation.report.component.ReportContentSection
import com.sopt.shinmungo.presentation.report.component.ReportDialogScreen
import com.sopt.shinmungo.presentation.report.component.ReportLocationSection
import com.sopt.shinmungo.presentation.report.component.ReportPhoneNumberSection
import com.sopt.shinmungo.presentation.report.component.ReportPhotoSection
import com.sopt.shinmungo.presentation.report.type.ReportDialogType

@Composable
fun ReportScreen(
    onMoveToGalleryClick: () -> Unit,
    onMoveToMapClick: () -> Unit,
    onMoveToHomeClick: () -> Unit,
    onBackClick: () -> Unit,
    selectedLocation: String,
    selectedPhotoList: List<ReportPhotoItem>,
    modifier: Modifier = Modifier,
    viewModel: ReportViewModel = viewModel(),
) {
    val isCategorySelected = viewModel.isCategorySelected.collectAsStateWithLifecycle()
    val selectedCategory = viewModel.selectedCategory.collectAsStateWithLifecycle()
    val isDropdownOpen = viewModel.isDropdownOpen.collectAsStateWithLifecycle()
    val photoList = viewModel.photoList.collectAsStateWithLifecycle()
    val showDeleteIcons = viewModel.showDeleteIcons.collectAsStateWithLifecycle()
    val location = viewModel.location.collectAsStateWithLifecycle()
    val content = viewModel.content.collectAsStateWithLifecycle()
    val isRecommendWord = viewModel.isRecommendWord.collectAsStateWithLifecycle()
    val phoneNumber = viewModel.phoneNumber.collectAsStateWithLifecycle()
    val showPhoneNumber = viewModel.showPhoneNumber.collectAsStateWithLifecycle()
    val isReportSharingAgreed = viewModel.isReportSharingAgreed.collectAsStateWithLifecycle()
    val cameraCooldownTime = viewModel.cameraCooldownTime.collectAsStateWithLifecycle()
    val isCameraButtonActive = viewModel.isCameraButtonActive.collectAsStateWithLifecycle()
    val isPostButtonActive = viewModel.isPostButtonActive.collectAsStateWithLifecycle()

    val dialogState by viewModel.dialogState.collectAsStateWithLifecycle()

    LaunchedEffect(selectedLocation) {
        viewModel.updateLocation(selectedLocation)
    }

    LaunchedEffect(selectedPhotoList) {
        viewModel.updatePhotoList(selectedPhotoList)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        CommonTopBar(
            title = stringResource(R.string.report_illegal_parking),
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { viewModel.updateDialogVisibility(ReportDialogType.RESET) }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
            },
        )

        Box {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(28.dp),
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                ) {
                    ReportPhotoSection(
                        photoItems = photoList.value,
                        cameraCooldownTime = cameraCooldownTime.value,
                        isCameraButtonActive = isCameraButtonActive.value,
                        onCameraButtonClick = {
                            viewModel.updateDialogVisibility(ReportDialogType.CAMERA_SELECTION)
                        },
                        onGalleryButtonClick = {
                            viewModel.updateDialogVisibility(ReportDialogType.GALLERY_SELECTION)
                        },
                        onDeleteButtonClick = {
                            viewModel.updateDeletePhoto(it)
                            viewModel.updateDialogVisibility(ReportDialogType.PHOTO_DELETE)
                        },
                        showDeleteIcons = showDeleteIcons.value,
                        onClickShowDeleteIcon = { viewModel.showDeleteIconForPhoto(it) },
                        onInfoIconClick = { viewModel.updateDialogVisibility(it) }
                    )

                    ReportLocationSection(
                        location = location.value,
                        onLocationButtonClick = {
                            onMoveToMapClick()
                        }
                    )

                    ReportContentSection(
                        content = content.value,
                        isRecommendWord = isRecommendWord.value,
                        onContentChange = { viewModel.updateContent(it) },
                        onIsRecommendWordClicked = { viewModel.updateIsRecommendWord() }
                    )

                    ReportPhoneNumberSection(
                        showPhoneNumber = showPhoneNumber.value,
                        phoneNumber = phoneNumber.value,
                        isReportSharingAgreed = isReportSharingAgreed.value,
                        onReportSharingAgreedClicked = { viewModel.updateIsReportSharingAgreed() }
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                }

                Surface(
                    shadowElevation = 8.dp,
                    color = ShinMunGoTheme.color.gray1,
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .padding(top = 8.dp, bottom = 32.dp)
                    ) {
                        RoundedCornerTextButton(
                            text = "제출",
                            textStyle = ShinMunGoTheme.typography.heading1,
                            textColor = ShinMunGoTheme.color.gray1,
                            backgroundColor = if (isPostButtonActive.value) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.primaryLight,
                            roundedCornerShape = RoundedCornerShape(10.dp),
                            onButtonClick = {
                                if (isPostButtonActive.value) {
                                    viewModel.updateDialogVisibility(ReportDialogType.SUBMIT_CONFIRM)
                                } else {
                                    /* 클릭 방지 */
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                    }
                }

                if (!isCategorySelected.value) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White.copy(alpha = 0.5f))
                            .clickable(
                                onClick = { /* 클릭 방지 */ },
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            )
                    )
                }
            }

            DropdownCategory(
                selectedCategory = selectedCategory.value,
                isDropdownOpen = isDropdownOpen.value,
                illegalParkingCategory = viewModel.illegalParkingCategory,
                updateSelectedCategory = { viewModel.updateSelectedCategory(it) },
                updateIsDropDownOpen = { viewModel.updateIsDropdownOpen() },
                modifier = Modifier.noRippleClickable {
                    viewModel.updateIsDropdownOpen()
                }
            )
        }
    }

    ReportDialogScreen(
        dialogState = dialogState,
        onDismissRequest = viewModel::updateDialogVisibility,
        onResetReturnConfirm = onBackClick,
        onSubmitComplete = {
            onMoveToHomeClick()
        },
        onResetClick = {
            viewModel.resetContent()
        },
        onPhotoDeleteConfirm = {
            viewModel.deletePhotoFromList()
        },
        onGallerySelectionConfirm = {
            onMoveToGalleryClick()
        },
        onCameraSelectionConfirm = { viewModel.startCameraCooldown(300) },
        onSubmitConfirmClick = {
            // TODO: api 통신 후 성공하면 다이얼로그 띄우기
            viewModel.updateDialogVisibility(ReportDialogType.SUBMIT)
        }
    )
}

@Preview
@Composable
fun ReportScreenPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ReportScreen(
            viewModel = viewModel,
            onBackClick = { },
            onMoveToMapClick = {},
            onMoveToGalleryClick = {},
            onMoveToHomeClick = {},
            selectedPhotoList = emptyList(),
            selectedLocation = "",
            modifier = modifier,
        )
    }
}