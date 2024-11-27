package com.sopt.shinmungo.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.BannerImage
import com.sopt.shinmungo.presentation.home.component.HomeFloatingActionButton
import com.sopt.shinmungo.presentation.home.component.HomeImageBannerPager
import com.sopt.shinmungo.presentation.home.component.HomeIssueExamplePager
import com.sopt.shinmungo.presentation.home.component.HomeTopBar
import com.sopt.shinmungo.presentation.home.component.group.HomeMonthReportGroup
import com.sopt.shinmungo.presentation.home.component.group.HomeYearReportGroup
import com.sopt.shinmungo.presentation.home.state.HomeUiState

@Composable
fun HomeRoute(
    navigateToCategory: () -> Unit,
    navigateToParkingReport: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.initUiState()
    }

    HomeScreen(
        navigateToCategory = navigateToCategory,
        navigateToParkingReport = navigateToParkingReport,
        uiState = uiState,
        reportExamplePairs = listOf(
            Pair(
                R.drawable.img_cases_1_before,
                R.drawable.img_cases_1_after
            ),
            Pair(
                R.drawable.img_cases_2_before,
                R.drawable.img_cases_2_after
            ),
        ),
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    navigateToCategory: () -> Unit,
    navigateToParkingReport: () -> Unit,
    reportExamplePairs: List<Pair<Int, Int>>,
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HomeTopBar()

        when (uiState.loadState) {
            is UiState.Loading -> {
                // 로딩 중 UI 표시
            }

            is UiState.Empty -> {
                // 빈 UI 표시
            }

            is UiState.Error -> {
                // 에러 UI 표시
            }

            is UiState.Success -> {
                with(uiState.loadState.data) {
                    SuccessScreen(
                        mileage = mileage,
                        monthReportCount = monthReportCount.toString(),
                        userName = name,
                        yearReportCount = yearReportCount.toString(),
                        bannerUrls = bannerImages,
                        reportExamplePairs = reportExamplePairs,
                        navigateToCategory = navigateToCategory,
                        navigateToParkingReport = navigateToParkingReport,
                    )
                }
            }
        }
    }
}

@Composable
private fun SuccessScreen(
    mileage: String,
    monthReportCount: String,
    userName: String,
    yearReportCount: String,
    bannerUrls: List<BannerImage>,
    reportExamplePairs: List<Pair<Int, Int>>,
    navigateToParkingReport: () -> Unit,
    navigateToCategory: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Box{
        Column(
            modifier = modifier
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
                imageUrls = bannerUrls,
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
                imagePairs = reportExamplePairs,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 18.dp)
            )
        }
        HomeFloatingActionButton(
            onMenuClick = navigateToCategory,
            onParkingClick = navigateToParkingReport,
            modifier = Modifier
                .padding(bottom = 12.dp, end = 16.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeSuccessScreenPreview() {
    ShinMunGoTheme {
        SuccessScreen(
            mileage = "5000000",
            monthReportCount = "25",
            userName = "수민",
            yearReportCount = "7",
            bannerUrls = listOf(
                BannerImage(
                    bannerId = 1,
                    bannerImageUrl = "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp"
                ),
                BannerImage(
                    bannerId = 2,
                    bannerImageUrl = "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp"
                ),
                BannerImage(
                    bannerId = 3,
                    bannerImageUrl = "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp"
                ),
            ),
            reportExamplePairs = listOf(
                Pair(
                    R.drawable.img_cases_1_before,
                    R.drawable.img_cases_1_after
                ),
                Pair(
                    R.drawable.img_cases_2_before,
                    R.drawable.img_cases_2_after
                ),
            ),
            navigateToParkingReport = {},
            navigateToCategory = {}
        )
    }
}