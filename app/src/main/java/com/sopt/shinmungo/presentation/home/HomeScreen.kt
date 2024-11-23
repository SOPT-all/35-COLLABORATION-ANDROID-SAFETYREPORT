package com.sopt.shinmungo.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.home.component.HomeImageBannerPager
import com.sopt.shinmungo.presentation.home.component.HomeIssueExamplePager
import com.sopt.shinmungo.presentation.home.component.HomeMonthReportGroup
import com.sopt.shinmungo.presentation.home.component.HomeYearReportGroup
import com.sopt.shinmungo.presentation.home.component.topbar.HomeTopBar

@Composable
fun HomeScreen(
    mileage: String = "5,000,000",
    yearReportCount: String = "25",
    monthReportCount: String = "7",
    userName: String = "수민",
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
    ) {
        HomeTopBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ShinMunGoTheme.color.gray1)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 23.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.main_title_my_report),
                    color = ShinMunGoTheme.color.gray13,
                    style = ShinMunGoTheme.typography.body2
                )

                Text(
                    text = stringResource(R.string.main_title_mileage, mileage),
                    style = ShinMunGoTheme.typography.caption7,
                    color = ShinMunGoTheme.color.gray13
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                HomeYearReportGroup(
                    title = stringResource(R.string.main_year_report_title),
                    reportCount = yearReportCount,
                    reportProgress = 0.7f,
                    replyProgress = 1f,
                    totalProgress = 0f,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(160 / 156f)
                )

                HomeMonthReportGroup(
                    title = stringResource(R.string.main_month_report_title),
                    userName = userName,
                    reportCount = monthReportCount,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(160 / 156f)
                )
            }

            HomeImageBannerPager(
                imageUrls = listOf(
                    "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp",
                    "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp",
                    "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp"
                ),
                modifier = Modifier.padding(top = 24.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.main_example_title),
                    color = ShinMunGoTheme.color.gray13,
                    style = ShinMunGoTheme.typography.body2
                )

                RoundedCornerTextButton(
                    text = stringResource(R.string.main_example_btn_more),
                    textStyle = ShinMunGoTheme.typography.caption7,
                    textColor = ShinMunGoTheme.color.gray13,
                    backgroundColor = ShinMunGoTheme.color.gray3,
                    roundedCornerShape = RoundedCornerShape(15.dp),
                    onButtonClick = {},
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                )
            }

            HomeIssueExamplePager(
                imagePairUrls = listOf(
                    Pair(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp"
                    ),
                    Pair(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp"
                    ),
                ),
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}