package com.sopt.shinmungo.presentation.home.component.fab

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.home.type.FloatingActionType

@Composable
fun HomeFloatingActionGroup(
    isFabActive: Boolean = false,
    modifier: Modifier = Modifier,
    onSafetyClick: () -> Unit = {},
    onParkingClick: () -> Unit = {},
    onTrafficClick: () -> Unit = {},
    onLifeStyleClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onCameraClick: () -> Unit = {},
) {
    val height by animateDpAsState(
        targetValue = if (isFabActive) Dp.Unspecified else 0.dp,
        animationSpec = spring(stiffness = Spring.StiffnessMedium),
        label = "fab",
    )

    Column(
        modifier = modifier
            .width(158.dp)
            .height(height)
            .padding(bottom = 9.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        HomeFloatingActionTypeListColumn(
            types = FloatingActionType.entries.subList(0, 4),
            onClickList = listOf(
                onSafetyClick,
                onParkingClick,
                onTrafficClick,
                onLifeStyleClick
            )
        )
        HomeFloatingActionTypeListColumn(
            types = FloatingActionType.entries.subList(4, 6),
            onClickList = listOf(
                onMenuClick,
                onCameraClick
            )
        )
    }
}

@Composable
private fun HomeFloatingActionTypeListColumn(
    types: List<FloatingActionType>,
    onClickList: List<() -> Unit>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = ShinMunGoTheme.color.gray1)
            .padding(vertical = 9.dp, horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        types.forEachIndexed { index, type ->
            CommonFloatingActionGroup(
                imageVector = ImageVector.vectorResource(id = type.icon),
                title = stringResource(id = type.title),
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickList[index]
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun HomeFloatingActionGroupPreview() {
    ShinMunGoTheme {
        HomeFloatingActionGroup()
    }
}