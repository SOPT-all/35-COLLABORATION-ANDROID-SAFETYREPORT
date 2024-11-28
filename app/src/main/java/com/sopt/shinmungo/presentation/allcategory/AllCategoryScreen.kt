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
 * @param modifier 화면의 Modifier로, 기본값은 Modifier입니다.
 * @param viewModel 화면에 데이터를 제공하고 비즈니스 로직을 처리하는 ViewModel입니다.
 */

@Composable
fun AllCategoryScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AllCategoryViewModel = viewModel()
) {
    val categories = viewModel.categories.collectAsState()
    val expandedStates = viewModel.expandedStates.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    Column(
        modifier = modifier
    ) {
        AllCategoryTopBar(onNavigateBack = onNavigateBack)
        if (categories.value.isEmpty()) {
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
                    .background(ShinMunGoTheme.color.gray2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp)
            ) {
                items(categories.value.size) { index ->
                    val reportableItems = categories.value[index].reportableItems
                    AllCategoryComponent(
                        category = categories.value[index],
                        isExpanded = expandedStates.value[index],
                        reportableItems = reportableItems,
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
