package com.sopt.shinmungo.presentation.report.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.TextWithInfoIcon
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.report.ReportViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun DropdownCategory(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    val selectedCategory = viewModel.selectedCategory.collectAsStateWithLifecycle()
    val isDropdownOpen = viewModel.isDropdownOpen.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
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
        Column {
            Row {
                val text = if (selectedCategory.value.isEmpty()) stringResource(R.string.report_select_report_type) else selectedCategory.value
                val textStyle =
                    if (selectedCategory.value.isEmpty()) ShinMunGoTheme.typography.body6 else ShinMunGoTheme.typography.body4
                val textColor =
                    if (selectedCategory.value.isEmpty()) ShinMunGoTheme.color.primary else ShinMunGoTheme.color.gray13
                val spacerModifier = Modifier.width(if (selectedCategory.value.isEmpty()) 10.dp else 8.dp)

                TextWithInfoIcon(
                    text = text,
                    textStyle = textStyle,
                    textColor = textColor,
                    spacerModifier = spacerModifier
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_line_black_24px),
                    contentDescription = stringResource(R.string.report_chevron_down_content_description),
                    tint = Color.Unspecified
                )
            }

            if (isDropdownOpen.value) {
                CategoryGrid(viewModel)
            }
        }
    }
}


@Preview
@Composable
fun DropdownCategoryPreview(modifier: Modifier = Modifier) {
    val viewModel: ReportViewModel = ReportViewModel()
    DropdownCategory(
        viewModel = viewModel
    )
}