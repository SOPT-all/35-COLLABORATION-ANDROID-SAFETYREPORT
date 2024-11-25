package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.presentation.report.ReportViewModel

@Composable
fun CategoryGrid(viewModel: ReportViewModel, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        viewModel.illegalParkingCategory.forEach { category ->
            if (category == "기타") {
                item(span = { GridItemSpan(2) }) {
                    CategoryButton(
                        category = category,
                        isClicked = false,
                        onCategoryButtonClick = { selectedCategory ->
                            viewModel.updateSelectedCategory(selectedCategory)
                            viewModel.updateIsDropdownOpen()
                        },
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    HorizontalDivider(
                        color = Color(0x1A121212),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            } else {
                item {
                    CategoryButton(
                        category = category,
                        isClicked = false,
                        onCategoryButtonClick = { selectedCategory ->
                            viewModel.updateSelectedCategory(selectedCategory)
                            viewModel.updateIsDropdownOpen()
                        },
                    )
                }

            }
        }
    }
}