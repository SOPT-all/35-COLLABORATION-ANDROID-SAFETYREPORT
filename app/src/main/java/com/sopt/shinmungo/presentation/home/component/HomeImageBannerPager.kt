package com.sopt.shinmungo.presentation.home.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.indicator.PageIndicator
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.domain.entity.BannerImage
import com.sopt.shinmungo.presentation.home.component.button.BannerIconButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeImageBannerPager(
    imageUrls: List<BannerImage>,
    modifier: Modifier = Modifier,
    autoScrollDelay: Long = 5000,
    tweenSpec: Int = 300
) {
    val pagerState = rememberPagerState { Integer.MAX_VALUE }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        while (true) {
            delay(autoScrollDelay)
            pagerState.animateScrollToPage(
                pagerState.currentPage + 1,
                animationSpec = tween(tweenSpec)
            )
        }
    }

    if(imageUrls.isNotEmpty()) {
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(329 / 173f),
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 16.dp
            ) { page ->
                Card(
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = ShinMunGoTheme.color.gray1
                    )
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(imageUrls[page % imageUrls.size].bannerImageUrl)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
            BannerIconButton(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_white_24),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier
                    .padding(start = 29.dp)
                    .align(Alignment.CenterStart)
            )
            BannerIconButton(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_24),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                modifier = Modifier
                    .padding(end = 29.dp)
                    .align(Alignment.CenterEnd)
            )

            PageIndicator(
                pagerState = pagerState,
                imageCount = imageUrls.size,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 4.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeImageBannerPreview() {
    ShinMunGoTheme {
        HomeImageBannerPager(
            imageUrls = listOf(
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
            autoScrollDelay = 2000,
            modifier = Modifier
        )
    }
}
