package com.sopt.shinmungo.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.core.extension.showIf
import com.sopt.shinmungo.presentation.main.MainTab

/**
 * 안전신문고 전용 바텀바입니다.
 *
 * @param onTabSelect 바텀바의 탭을 선택했을 때 호출되는 콜백입니다.
 * @param selectedTab 현재 선택된 탭입니다.
 * @param tabs 탭 목록입니다.
 * @param visibility 바텀바의 가시성을 결정합니다.
 * @param modifier 수정자 객체입니다.
 * @param containerColor 바텀바의 배경색입니다.
 * @param selectedColor 선택된 탭의 색상입니다.
 * @param unselectedColor 선택되지 않은 탭의 색상입니다.
 */

@Composable
fun MainBottomBars(
    onTabSelect: (MainTab) -> Unit,
    selectedTab: MainTab?,
    tabs: List<MainTab>,
    visibility: Boolean,
    modifier: Modifier = Modifier,
    containerColor: Color = ShinMunGoTheme.color.gray1,
    selectedColor: Color = ShinMunGoTheme.color.primary,
    unselectedColor: Color = ShinMunGoTheme.color.gray6,
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        shape = RectangleShape,
        modifier = Modifier.showIf(visibility)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = containerColor)
                .navigationBarsPadding()
                .padding(start = 37.dp, end = 37.dp, top = 8.dp, bottom = 31.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            tabs.forEach { tab ->
                val selected = tab == selectedTab
                val color = if (selected) selectedColor else unselectedColor
                val icon = if (selected) tab.selectedIconRes else tab.unselectedIconRes
                Column(
                    modifier = Modifier.noRippleClickable { onTabSelect(tab) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = icon),
                        contentDescription = stringResource(id = tab.title),
                        tint = color
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(id = tab.title),
                        style = ShinMunGoTheme.typography.caption6,
                        color = color
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainBottomBarsPreview() {
    ShinMunGoTheme {
        Scaffold(
        bottomBar = {
            MainBottomBars(
                onTabSelect = {},
                selectedTab = MainTab.HOME,
                tabs = MainTab.entries,
                visibility = true
            )
        }
        ){ innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

