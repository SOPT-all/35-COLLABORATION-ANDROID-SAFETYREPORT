package com.sopt.shinmungo.presentation.gallery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun CustomTabRow(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    tabs: List<String>,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        modifier = modifier.border(0.dp, Color.Transparent),
        selectedTabIndex = selectedTabIndex,
        contentColor = ShinMunGoTheme.color.primary,
        indicator = { },
    ) {
        tabs.forEachIndexed { index, tabName ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        tabName,
                        color = if (selectedTabIndex == index) ShinMunGoTheme.color.primary
                        else ShinMunGoTheme.color.gray1,
                        style = ShinMunGoTheme.typography.body4
                    )
                },
                modifier = Modifier.background(
                    if (selectedTabIndex == index) Color.White
                    else ShinMunGoTheme.color.gray5
                ),
            )
        }
    }
}
