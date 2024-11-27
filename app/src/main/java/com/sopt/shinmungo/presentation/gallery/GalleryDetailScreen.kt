package com.sopt.shinmungo.presentation.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.domain.entity.Photo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

@Composable
fun GalleryDetailScreen(
    modifier: Modifier = Modifier,
    photoId: Int,
    onBackClick: () -> Unit,
    viewModel: GalleryViewModel = viewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val photo = uiState.photos.values.flatten().find { it.id == photoId }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CommonTopBar(
            title = stringResource(R.string.gallery_detail_topbar_title),
            onLeftContent = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = stringResource(R.string.back_screen_text),
                        tint = Color.White
                    )
                }
            }
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth()){
                AsyncImage(
                    model = photo?.url,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .border(1.dp, ShinMunGoTheme.color.gray3, RoundedCornerShape(4.dp))
                    ){
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = stringResource(
                                id = R.string.gallery_detail_timestamp_prefix_text,
                                photo?.timestamp?.format(DATE_TIME_FORMATTER) ?: "알 수 없음"
                            ),
                            style = ShinMunGoTheme.typography.caption1,
                            color = ShinMunGoTheme.color.gray13
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .border(1.dp, ShinMunGoTheme.color.gray3, RoundedCornerShape(4.dp))
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = stringResource(R.string.gallery_detail_shinmungo),
                            style = ShinMunGoTheme.typography.caption1,
                            color = ShinMunGoTheme.color.gray13
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .size(36.dp)
                    .align(Alignment.TopEnd)
                    .clickable {
                        if (photo != null) {
                            if (photo.id in uiState.selectedPhotos) {
                                viewModel.onEvent(GalleryEvent.DeselectPhoto(photo.id))
                            } else {
                                viewModel.onEvent(GalleryEvent.SelectPhoto(photo.id))
                            }
                        }
                    }
            ) {
                val icon = if (photo?.id in uiState.selectedPhotos) {
                    R.drawable.ic_checkbox_square_selected_white_24
                } else {
                    R.drawable.ic_checkbox_square_unselected_white_24
                }

                Image(
                    modifier = Modifier.size(36.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GalleryDetailScreenPreview() {
    val previewPhoto = Photo(
        id = 1,
        url = "https://placehold.co/200x300",
        timestamp = LocalDateTime.of(2024, 11, 13, 17, 59)
    )

    val previewUiState = GalleryState(
        photos = mapOf(LocalDateTime.now().toLocalDate() to listOf(previewPhoto)),
        selectedPhotos = setOf()
    )

    ShinMunGoTheme {
        GalleryDetailScreen(
            photoId = 1,
            onBackClick = {},
            viewModel = GalleryViewModel()
        )
    }
}