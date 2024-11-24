package com.sopt.shinmungo.presentation.home.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.indicator.PageIndicator
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import kotlinx.coroutines.delay

@Composable
fun HomeIssueExamplePager(
    imagePairs: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier,
    autoScrollDelay: Long = 5000,
    tweenSpec: Int = 300
) {
    val pagerState = rememberPagerState { Integer.MAX_VALUE }

    LaunchedEffect(true) {
        while (true) {
            delay(autoScrollDelay)
            pagerState.animateScrollToPage(
                pagerState.currentPage + 1,
                animationSpec = tween(tweenSpec)
            )
        }
    }

    if(imagePairs.isNotEmpty()) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 16.dp
            ) { page ->
                val currentImagePair = imagePairs[page % imagePairs.size]
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(9.dp)
                ) {
                    val imageModifier = Modifier
                        .weight(1f)
                        .aspectRatio(160 / 105f)
                    HomeIssueExampleImage(
                        painter = painterResource(currentImagePair.first),
                        chipText = stringResource(R.string.main_example_chip_before),
                        modifier = imageModifier
                    )
                    HomeIssueExampleImage(
                        painter = painterResource(currentImagePair.second),
                        chipText = stringResource(R.string.main_example_chip_after),
                        modifier = imageModifier
                    )
                }
            }

            PageIndicator(
                pagerState = pagerState,
                imageCount = imagePairs.size,
                backgroundColor = ShinMunGoTheme.color.gray1,
                selectedColor = ShinMunGoTheme.color.gray13,
                unselectedColor = ShinMunGoTheme.color.gray3,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun HomeIssueExampleImage(
    painter: Painter,
    chipText: String,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = ShinMunGoTheme.color.gray1
        ),
        modifier = modifier
    ) {
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )

            Box(
                Modifier
                    .padding(top = 8.dp, start = 8.dp)
                    .background(
                        color = ShinMunGoTheme.color.gray6,
                        shape = CircleShape
                    )
                    .size(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = chipText,
                    style = ShinMunGoTheme.typography.caption8,
                    color = ShinMunGoTheme.color.gray1,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeIssueExamplePreview() {
    ShinMunGoTheme {
        Column {
            HomeIssueExamplePager(
                imagePairs = listOf(
                    Pair(
                        R.drawable.img_cases_1_before,
                        R.drawable.img_cases_1_after
                    ),
                    Pair(
                        R.drawable.img_cases_2_before,
                        R.drawable.img_cases_2_after
                    ),
                ),
                modifier = Modifier
            )
        }
    }
}