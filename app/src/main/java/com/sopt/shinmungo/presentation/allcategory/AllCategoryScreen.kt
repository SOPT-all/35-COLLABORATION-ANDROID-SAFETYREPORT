package com.sopt.shinmungo.presentation.allcategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.allcategory.component.AllCategoryComponent
import com.sopt.shinmungo.presentation.allcategory.component.AllCategoryTopBar
import com.sopt.shinmungo.presentation.allcategory.viewmodel.AllCategoryViewModel

/**
 * 전체 카테고리 화면을 표시하는 컴포저블 함수입니다.
 *
 * @param onNavigateBack 뒤로가기 버튼 클릭 시 호출되는 콜백 함수입니다.
 * @param viewModel 화면에 데이터를 제공하고 비즈니스 로직을 처리하는 ViewModel입니다.
 */
@Composable
fun AllCategoryScreen(
    onNavigateBack: () -> Unit,
    viewModel: AllCategoryViewModel = viewModel()
) {
    val categories = viewModel.categories.collectAsState()
    val expandedStates = viewModel.expandedStates.collectAsState()

    // 화면이 처음 만들어질 때 서버에서 데이터를 가져옴
    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    Scaffold(
        topBar = { AllCategoryTopBar(onNavigateBack = onNavigateBack) }
    ) { innerPadding ->
        if (categories.value.isEmpty()) {
            // 데이터가 없을 때 빈 화면 표시 (로딩 메시지 없음)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ShinMunGoTheme.color.gray2),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "표시할 카테고리가 없습니다.",
                    style = ShinMunGoTheme.typography.body4,
                    color = ShinMunGoTheme.color.gray7
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp, bottom = 16.dp)
                    .padding(innerPadding)
                    .background(ShinMunGoTheme.color.gray2),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.value.size) { index ->
                    val reportableItems = categories.value[index].reportableItems
                    AllCategoryComponent(
                        category = categories.value[index], // 카테고리 데이터 전달
                        isExpanded = expandedStates.value[index], // 확장 상태 전달
                        reportableItems = reportableItems, // 신고 가능한 항목 전달
                        onClick = { viewModel.toggleCategoryExpanded(index) },
                        )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewReportCategoryScreen() {
    ShinMunGoTheme {
        AllCategoryScreen(
            onNavigateBack = { /* 뒤로가기 로직 */ },
        )
    }
}
