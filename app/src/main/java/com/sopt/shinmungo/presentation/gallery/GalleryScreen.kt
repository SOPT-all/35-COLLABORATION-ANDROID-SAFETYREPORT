package com.sopt.shinmungo.presentation.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.domain.entity.Photo
import com.sopt.shinmungo.presentation.gallery.component.AlertMessageBox
import com.sopt.shinmungo.presentation.gallery.component.CustomTabRow
import com.sopt.shinmungo.presentation.gallery.component.PhotoCard
import com.sopt.shinmungo.presentation.gallery.component.PhotoDateTitle
import com.sopt.shinmungo.presentation.report.type.ReportDialogType

@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onPhotoClick: (Int) -> Unit,
    onConfirmClick: (List<Photo>) -> Unit,
    viewModel: GalleryViewModel = viewModel(),
){
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    var selectedTab by remember { mutableStateOf(0) }
    val tabTitles = listOf(
        stringResource(R.string.gallery_img_tab),
        stringResource(R.string.gallery_video_tab)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ShinMunGoTheme.color.gray1)
    ) {
        CommonTopBar(
            title = stringResource(R.string.gallery_topbar_title),
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = onBackClick
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = stringResource(R.string.back_screen_text),
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }
        )

        CustomTabRow(
            selectedTabIndex = selectedTab,
            tabs = tabTitles,
            onTabSelected = { selectedTab = it }
        )
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        else {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when(selectedTab) {
                    0 -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp)
                                .padding(top = 8.dp),
                            contentPadding = PaddingValues(1.dp),

                            ) {
                            item(span = { GridItemSpan(3) }) {
                                AlertMessageBox(
                                    message = stringResource(R.string.gallery_alert_caption_text),
                                    iconRes = R.drawable.ic_alert_line_red_16,
                                    backgroundColor = ShinMunGoTheme.color.opacityGray13Per5,
                                    textColor = ShinMunGoTheme.color.primaryRed
                                )
                            }

                            uiState.photos.forEach { (date, photos) ->
                                item(span = { GridItemSpan(3) }) {
                                    PhotoDateTitle(
                                        date = date
                                    )
                                }

                                items(photos.size) { index ->
                                    val photo = photos[index]
                                    PhotoCard(
                                        photo = photo,
                                        isSelected = photo.id in uiState.selectedPhotos,
                                        onPhotoClick = { onPhotoClick(photo.id) },
                                        onCheckboxClick = {
                                            if (photo.id in uiState.selectedPhotos) {
                                                viewModel.onEvent(GalleryEvent.DeselectPhoto(photo.id))
                                            } else {
                                                viewModel.onEvent(GalleryEvent.SelectPhoto(photo.id))
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                    1 -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(R.string.gallery_empty_video_text),
                                style = ShinMunGoTheme.typography.body3,
                                color = ShinMunGoTheme.color.gray6
                            )
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 8.dp, bottom = 32.dp)
        ) {
            RoundedCornerTextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = stringResource(R.string.gallery_use_button_text),
                textStyle = ShinMunGoTheme.typography.heading1,
                textColor = ShinMunGoTheme.color.gray1,
                backgroundColor = ShinMunGoTheme.color.primary,
                roundedCornerShape = RoundedCornerShape(10.dp),
                onButtonClick = {
                    val selectedPhotos = uiState.photos.values
                        .flatten()
                        .filter { it.id in uiState.selectedPhotos }
                    onConfirmClick(selectedPhotos)
                }
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GalleryScreenPreview() {
    val previewViewModel = GalleryViewModel().apply {
        onEvent(GalleryEvent.LoadPhotos)
    }

    ShinMunGoTheme {
        GalleryScreen(
            onBackClick = {},
            onConfirmClick = {},
            viewModel = previewViewModel,
            onPhotoClick = {}
        )
    }
}