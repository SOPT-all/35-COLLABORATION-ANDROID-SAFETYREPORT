package com.sopt.shinmungo.presentation.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.report.component.DropdownCategory
import com.sopt.shinmungo.presentation.report.component.ReportContentSection
import com.sopt.shinmungo.presentation.report.component.ReportLocationSection
import com.sopt.shinmungo.presentation.report.component.ReportPhoneNumberSection
import com.sopt.shinmungo.presentation.report.component.ReportPhotoSection

@Composable
fun ReportScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ReportViewModel = ReportViewModel()

    Column(
        modifier = modifier.fillMaxSize().background(color = ShinMunGoTheme.color.gray1)
    ) {
        CommonTopBar(
            title = "불법주정차",
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
            },
        )

        DropdownCategory(
            viewModel = viewModel
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp),
            modifier = Modifier
                .padding(top = 18.dp)
                .padding(horizontal = 18.dp),
        ) {
            ReportPhotoSection(viewModel = viewModel)

            ReportLocationSection(viewModel = viewModel)

            ReportContentSection(viewModel = viewModel)

            ReportPhoneNumberSection(viewModel = viewModel)

        }
    }
}

@Preview
@Composable
fun ReportScreenPreview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        ReportScreen()
    }
}