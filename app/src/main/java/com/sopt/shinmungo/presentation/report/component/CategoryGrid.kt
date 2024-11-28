package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun CategoryGrid(
    illegalParkingCategory: List<String>,
    selectedCategory: String,
    updateSelectedCategory: (String) -> Unit,
    updateIsDropDownOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        illegalParkingCategory.forEach { category ->
            if (category == "기타") {
                item(span = { GridItemSpan(2) }) {
                    CategoryButton(
                        category = category,
                        isClicked = selectedCategory == category,
                        onCategoryButtonClick = {
                            updateSelectedCategory(category)
                            updateIsDropDownOpen()
                        },
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    HorizontalDivider(
                        color = ShinMunGoTheme.color.opacityGray13Per10,
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
                        isClicked = selectedCategory == category,
                        onCategoryButtonClick = {
                            updateSelectedCategory(category)
                            updateIsDropDownOpen()
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryButton(
    category: String,
    isClicked: Boolean,
    onCategoryButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    RoundedCornerTextButton(
        text = category,
        textStyle = ShinMunGoTheme.typography.body6,
        textColor = if (isClicked) ShinMunGoTheme.color.gray1 else ShinMunGoTheme.color.gray13,
        backgroundColor = if (isClicked) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray1,
        roundedCornerShape = RoundedCornerShape(10.dp),
        onButtonClick = {
            onCategoryButtonClick(category)
        },
        modifier = Modifier.padding(vertical = 16.dp)
    )
}