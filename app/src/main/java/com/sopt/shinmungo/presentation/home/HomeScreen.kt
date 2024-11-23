package com.sopt.shinmungo.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.home.component.topbar.HomeTopBar
import com.sopt.shinmungo.presentation.home.component.HomeMileageTitleGroup
import com.sopt.shinmungo.presentation.home.component.HomeMonthReportGroup
import com.sopt.shinmungo.presentation.home.component.HomeYearReportGroup

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ShinMunGoTheme.color.gray1)
    ) {
        HomeTopBar()
        HomeMileageTitleGroup(
            mileage = "5,000,000",
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 23.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            HomeYearReportGroup(
                title = stringResource(R.string.main_year_report_title),
                reportCount = "25",
                reportProgress = 0.7f,
                replyProgress = 1f,
                totalProgress = 0f,
                modifier = Modifier.weight(1f).aspectRatio(1f)
            )

            HomeMonthReportGroup(
                title = stringResource(R.string.main_month_report_title),
                userName = "수민",
                reportCount = "2",
                modifier = Modifier.weight(1f).aspectRatio(1f)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}