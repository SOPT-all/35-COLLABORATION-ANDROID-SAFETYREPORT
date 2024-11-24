package com.sopt.shinmungo.presentation.allcategory.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.allcategory.component.ReportCategoryItem
import com.sopt.shinmungo.presentation.main.MainTab
import com.sopt.shinmungo.presentation.main.component.MainBottomBars

@Composable
fun ReportCategoryScreen(
    onNavigateBack: () -> Unit,
    selectedTab: MainTab,
    onTabSelected: (MainTab) -> Unit
) {
    val categories = remember {
        mutableStateListOf(
            ReportCategory("안전", "가로등 점검사항, 도로/시설물 파손 및 고장 등."),
            ReportCategory("불법 주정차", "장애인 전용 구역, 소화전 근처 등."),
            ReportCategory("자동차/교통위반", "교통사고, 불법 유턴 등."),
            ReportCategory("생활불편", "쓰레기 무단투기, 불법 광고물 등.")
        )
    }
    val expandedStates = remember { mutableStateListOf(false, false, false, false) }

    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                CommonTopBar(
                    title = "",
                    onLeftContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            IconButton(onClick = onNavigateBack) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                                    contentDescription = "뒤로가기",
                                    tint = ShinMunGoTheme.color.gray1
                                )
                            }
                        }
                    }
                )

                Text(
                    text = "전체 메뉴",
                    style = ShinMunGoTheme.typography.heading2,
                    color = ShinMunGoTheme.color.gray1,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        bottomBar = {
            MainBottomBars(
                tabs = MainTab.entries,
                selectedTab = selectedTab,
                onTabSelect = onTabSelected,
                visibility = true
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(ShinMunGoTheme.color.gray2)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size) { index ->
                    ReportCategoryItem(
                        category = categories[index],
                        isExpanded = expandedStates[index],
                        onClick = { expandedStates[index] = !expandedStates[index] }
                    )
                }
            }
        }
    }
}


/**
 * 데이터 클래스
 */
data class ReportCategory(
    val title: String,
    val description: String
)

/**
 * ReportCategoryScreen 미리보기
 */
@Preview(showBackground = true)
@Composable
fun PreviewReportCategoryScreen() {
    ShinMunGoTheme {
        ReportCategoryScreen(
            onNavigateBack = { /* 뒤로가기 로직 */ },
            selectedTab = MainTab.HOME,
            onTabSelected = { /* 탭 전환 로직 */ }
        )
    }
}

/**
 * ReportCategoryItem 미리보기
 */
@Preview(showBackground = true)
@Composable
fun PreviewReportCategoryItem() {
    ShinMunGoTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ShinMunGoTheme.color.gray2)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ReportCategoryItem(
                category = ReportCategory(
                    title = "안전",
                    description = "가로등 점검사항, 도로/시설물 파손 및 고장 등."
                ),
                isExpanded = false,
                onClick = {}
            )
            ReportCategoryItem(
                category = ReportCategory(
                    title = "안전",
                    description = "가로등 점검사항, 도로/시설물 파손 및 고장 등."
                ),
                isExpanded = true,
                onClick = {}
            )
        }
    }
}

