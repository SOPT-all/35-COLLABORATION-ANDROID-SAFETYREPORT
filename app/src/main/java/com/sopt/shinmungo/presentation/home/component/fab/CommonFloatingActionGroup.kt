package com.sopt.shinmungo.presentation.home.component.fab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable

@Composable
fun CommonFloatingActionGroup(
    imageVector: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(start = 6.dp, top = 4.dp, bottom = 5.dp)
            .noRippleClickable(onClick),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = title
        )

        Text(
            text = title,
            style = ShinMunGoTheme.typography.body8,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@Preview
@Composable
fun CommonFloatingActionGroupPreview() {
    ShinMunGoTheme {
        CommonFloatingActionGroup(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_report_camera_24px),
            title = "신고하기",
            onClick = {},
            modifier = Modifier.background(color = ShinMunGoTheme.color.gray1)
        )
    }
}