package com.sopt.shinmungo.core.designsystem.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 커스터마이징 가능한 상단 앱 바 컴포넌트입니다.
 *
 * @param title 상단 앱 바에 표시될 제목 텍스트입니다.
 * @param onLeftContent 상단 앱 바의 왼쪽에 표시될 컴포저블 콘텐츠입니다. 기본값은 빈 컴포저블입니다.
 * @param onRightContent 상단 앱 바의 오른쪽에 표시될 컴포저블 콘텐츠입니다. 기본값은 빈 컴포저블입니다.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    title: String,
    onLeftContent: @Composable () -> Unit = {},
    onRightContent: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        windowInsets = WindowInsets(0.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ShinMunGoTheme.color.primary,
            titleContentColor = Color.White,
            navigationIconContentColor = ShinMunGoTheme.color.gray1
        ),
        title = {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    onLeftContent()
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    text = title,
                    style = ShinMunGoTheme.typography.heading2,
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    onRightContent()
                }
            }
        },
        navigationIcon = { },
        actions = { },

    )
}

@Preview
@Composable
fun CommonTopBarPreview() {
    ShinMunGoTheme {
        CommonTopBar(
            title = "Preview",
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
            },
            onRightContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_line_white_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hammenu_line_white_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
            }

        )
    }
}