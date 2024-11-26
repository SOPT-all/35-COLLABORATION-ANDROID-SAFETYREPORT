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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import com.sopt.shinmungo.presentation.report.component.DropdownCategory
import com.sopt.shinmungo.presentation.report.component.ReportContentSection
import com.sopt.shinmungo.presentation.report.component.ReportLocationSection
import com.sopt.shinmungo.presentation.report.component.ReportPhoneNumberSection
import com.sopt.shinmungo.presentation.report.component.ReportPhotoSection

@Composable
fun ReportScreen(
    viewModel: ReportViewModel = ReportViewModel(),
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
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
    val cameraCooldownTime = viewModel.cameraCooldownTime.collectAsStateWithLifecycle()
    val isCameraButtonActive = viewModel.isCameraButtonActive.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CommonTopBar(
            title = stringResource(R.string.report_illegal_parking),
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = onBackClick
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
                modifier = modifier
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
                        onCameraButtonClick = { viewModel.startCameraCooldown(300) },
                        onGalleryButtonClick = {
                            /* 갤러리 화면으로 이동 */
                            val newPhotoList = arrayListOf(
                                // 임시로 값 연결
                                ReportPhotoItem(1, "https://via.placeholder.com/70"),
                                ReportPhotoItem(2, "https://via.placeholder.com/70"),
                                ReportPhotoItem(3, "https://via.placeholder.com/70"),
                                ReportPhotoItem(4, "https://via.placeholder.com/70"),
                            )
                            viewModel.updatePhotoList(newPhotoList)
                        },
                        onDeleteButtonClick = { viewModel.deletePhotoFromList(it) },
                        showDeleteIcons = showDeleteIcons.value,
                        onClickShowDeleteIcon = { viewModel.showDeleteIconForPhoto(it) }
                    )

                    ReportLocationSection(viewModel = viewModel)

                    ReportContentSection(viewModel = viewModel)

                    ReportPhoneNumberSection(viewModel = viewModel)

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
                            backgroundColor = ShinMunGoTheme.color.primary,
                            roundedCornerShape = RoundedCornerShape(10.dp),
                            onButtonClick = { /* POST API */ },
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
}

@Preview
@Composable
fun ReportScreenPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ReportScreen(
            viewModel = viewModel,
            onBackClick = { },
            modifier,
        )
    }
}