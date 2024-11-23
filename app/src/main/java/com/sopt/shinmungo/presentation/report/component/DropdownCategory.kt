package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.TextWithInfoIcon
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun DropdownCategory(
    selectedCategory: String? = null,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .fillMaxWidth()
            .background(
                color = ShinMunGoTheme.color.gray3,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp
                )
            )
            .padding(start = 15.dp, top = 16.dp, end = 15.dp, bottom = 16.dp)
    ) {
        Row{
            TextWithInfoIcon(
                text = selectedCategory ?: stringResource(R.string.report_select_report_type),
                textStyle = if (selectedCategory==null) ShinMunGoTheme.typography.body6 else ShinMunGoTheme.typography.body4,
                textColor = if (selectedCategory==null) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray13,
                spacerModifier = if (selectedCategory==null) Modifier.width(10.dp) else Modifier.width(8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_line_black_24px),
                contentDescription = stringResource(R.string.report_chevron_down_content_description),
                tint = Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
fun DropdownCategoryPreview(modifier: Modifier = Modifier) {
    DropdownCategory(

    )
}