package com.sopt.shinmungo.presentation.gallery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.domain.entity.Photo

@Composable
fun PhotoCard(
    photo: Photo,
    isSelected: Boolean,
    onPhotoClick: () -> Unit,
    onCheckboxClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(end = 4.dp, bottom = 4.dp)
            .clickable(onClick = onPhotoClick),
        colors = CardDefaults.cardColors(
            containerColor = ShinMunGoTheme.color.gray3
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            AsyncImage(
                model = photo.url,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            val icon = if (isSelected) {
                R.drawable.ic_checkbox_square_selected_white_24
            } else {
                R.drawable.ic_checkbox_square_unselected_white_24
            }

            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
                    .clickable(onClick = onCheckboxClick)
            ) {
                val icon = if (isSelected) {
                    R.drawable.ic_checkbox_square_selected_white_24
                } else {
                    R.drawable.ic_checkbox_square_unselected_white_24
                }

                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

