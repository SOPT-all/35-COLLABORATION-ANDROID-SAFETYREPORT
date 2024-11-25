package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

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