package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sopt.shinmungo.presentation.report.PhotoItem
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.presentation.report.ReportViewModel
import kotlinx.coroutines.delay

@Composable
fun ShowPhotoList(
    viewModel: ReportViewModel,
) {
    val photoItems = viewModel.photoList.collectAsStateWithLifecycle()
    val showDeleteIcons = viewModel.showDeleteIcons.collectAsStateWithLifecycle()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(photoItems.value) { photoItem ->
            val showDelete = showDeleteIcons.value[photoItem.photoId] == true
            PhotoItem(
                photoItem = photoItem,
                showDeleteIcon = showDelete,
                onDelete = {
                    viewModel.deletePhotoFromList(it)
                },
                onClick = {
                    viewModel.showDeleteIconForPhoto(photoItem.photoId)
                },
            )
        }
    }
}

@Composable
fun PhotoItem(
    photoItem: PhotoItem,
    showDeleteIcon: Boolean,
    onDelete: (PhotoItem) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(showDeleteIcon) {
        if (showDeleteIcon) {
            delay(3000)
            onClick()
        }
    }

    Box(
        modifier = modifier
            .size(70.dp)
            .clip(RoundedCornerShape(5.dp))
            .noRippleClickable {
                onClick()
            }
    ) {
        AsyncImage(
            model = photoItem.photoUrl,
            contentDescription = "사진이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(70.dp)
        )

        if (showDeleteIcon) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x99121212))

            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_report_trashcan_24px),
                    contentDescription = "삭제",
                    modifier = Modifier
                        .size(24.dp)
                        .noRippleClickable { onDelete(photoItem) }
                )
            }
        }
    }
}

@Composable
fun BoxWhenPhotoListEmpty() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ShinMunGoTheme.color.gray3,
                shape = RoundedCornerShape(size = 5.dp)
            )
            .padding(vertical = 25.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "사진을 추가해주세요",
            style = ShinMunGoTheme.typography.body9,
            color = Color(0x66121212)
        )
    }
}

@Preview
@Composable
fun ShowPhotoListPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ShowPhotoList(viewModel)
    }
}