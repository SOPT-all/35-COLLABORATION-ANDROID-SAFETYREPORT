package com.sopt.shinmungo.presentation.allcategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
    viewModel: AllCategoryViewModel = hiltViewModel()
) {
    val categories = viewModel.categories.collectAsState()
    val expandedStates = viewModel.expandedStates.collectAsState()

    Scaffold(
        topBar = {
            AllCategoryTopBar(onNavigateBack = onNavigateBack)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(ShinMunGoTheme.color.gray2),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories.value.size) { index ->
                AllCategoryComponent(
                    category = categories.value[index],
                    isExpanded = expandedStates.value[index],
                    reportableItems = categories.value[index].reportableItems,
                    onClick = { viewModel.toggleCategoryExpanded(index) }
                )
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


