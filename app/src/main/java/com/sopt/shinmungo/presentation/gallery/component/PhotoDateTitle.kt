package com.sopt.shinmungo.presentation.gallery.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun PhotoDateTitle(date: LocalDate) {
    Text(
        text = date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")),
        style = ShinMunGoTheme.typography.body2,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}
