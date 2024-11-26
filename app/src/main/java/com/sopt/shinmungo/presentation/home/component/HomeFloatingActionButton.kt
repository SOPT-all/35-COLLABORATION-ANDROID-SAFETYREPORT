package com.sopt.shinmungo.presentation.home.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.core.extension.showIf
import com.sopt.shinmungo.presentation.home.component.group.HomeFloatingActionGroup

@Composable
fun HomeFloatingActionButton(
    modifier: Modifier = Modifier,
    onSafetyClick: () -> Unit = {},
    onParkingClick: () -> Unit = {},
    onTrafficClick: () -> Unit = {},
    onLifeStyleClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onCameraClick: () -> Unit = {},
) {
    var isFabActive by remember { mutableStateOf(false) }
    val fabSize by animateSizeAsState(
        targetValue = if (!isFabActive) Size(100f, 40f) else Size(40f, 40f),
        label = "fab"
    )
    val fabColor by animateColorAsState(
        targetValue = if (!isFabActive) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray1,
        label = "fab"
    )
    val fabShape = if (!isFabActive) RoundedCornerShape(30.dp) else CircleShape

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        HomeFloatingActionGroup(
            modifier = Modifier,
            isFabActive = isFabActive,
            onSafetyClick = onSafetyClick,
            onParkingClick = onParkingClick,
            onTrafficClick = onTrafficClick,
            onLifeStyleClick = onLifeStyleClick,
            onMenuClick = onMenuClick,
            onCameraClick = onCameraClick
        )

        Box(
            modifier = Modifier
                .size(width = fabSize.width.dp, height = fabSize.height.dp)
                .background(color = fabColor, shape = fabShape)
                .noRippleClickable { isFabActive = !isFabActive },
            contentAlignment = Alignment.Center
        ) {
            ReportFabContent(
                visibility = !isFabActive,
            )
            CloseFabContent(
                visibility = isFabActive,
            )
        }
    }
}

@Composable
private fun ReportFabContent(
    visibility: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .showIf(visibility)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus_16),
            contentDescription = stringResource(R.string.main_fab_report),
            tint = ShinMunGoTheme.color.gray1
        )
        Text(
            text = stringResource(R.string.main_fab_report),
            style = ShinMunGoTheme.typography.body3,
            color = ShinMunGoTheme.color.gray1
        )
    }
}

@Composable
private fun CloseFabContent(
    visibility: Boolean,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_close_24),
        contentDescription = stringResource(R.string.main_fab_report_close),
        tint = ShinMunGoTheme.color.gray13,
        modifier = modifier
            .showIf(visibility)
    )
}


@Preview(showBackground = true)
@Composable
private fun HomeFloatingActionButtonPreview() {
    ShinMunGoTheme {
        HomeFloatingActionButton()
    }
}

@Preview(showBackground = true)
@Composable
private fun ReportFabContentPreview() {
    ShinMunGoTheme {
        ReportFabContent(
            visibility = true,
            modifier = Modifier.size(width = 100.dp, height = 40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CloseFabContentPreview() {
    ShinMunGoTheme {
        CloseFabContent(
            visibility = true,
            modifier = Modifier.size(40.dp)
        )
    }
}