package com.sopt.shinmungo.presentation.home.component.pager

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sopt.shinmungo.core.designsystem.component.indicator.PageIndicator
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun HomeIssueExamplePager(
    imagePairUrls: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState { Integer.MAX_VALUE }
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
            val currentImagePair = imagePairUrls[page % imagePairUrls.size]
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                val imageModifier = Modifier
                    .weight(1f)
                    .aspectRatio(160 / 105f)
                HomeIssueExampleImage(
                    imageUrl = currentImagePair.first,
                    chipText = "전",
                    modifier = imageModifier
                )
                HomeIssueExampleImage(
                    imageUrl = currentImagePair.second,
                    chipText = "후",
                    modifier = imageModifier
                )
            }
        }

        PageIndicator(
            pagerState = pagerState,
            imageCount = imagePairUrls.size,
            backgroundColor = ShinMunGoTheme.color.gray1,
            selectedColor = ShinMunGoTheme.color.gray13,
            unselectedColor = ShinMunGoTheme.color.gray3,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Composable
private fun HomeIssueExampleImage(
    imageUrl: String,
    chipText: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(imageUrl)
                    .build(),
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
                imagePairUrls = listOf(
                    Pair(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp"
                    ),
                    Pair(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp"
                    ),
                    Pair(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp"
                    )
                ),
                modifier = Modifier
            )
        }
    }
}