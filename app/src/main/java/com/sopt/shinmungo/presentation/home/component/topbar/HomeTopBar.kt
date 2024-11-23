package com.sopt.shinmungo.presentation.home.component.topbar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable

@Composable
fun HomeTopBar(
    onClickChatButton: () -> Unit = {},
    onClickMenuButton: () -> Unit = {},
) {
    CommonTopBar(
        title = "",
        onLeftContent = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_logo_24),
                contentDescription = stringResource(R.string.main_top_bar_logo),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )
        },
        onRightContent = {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat_line_white_24),
                contentDescription = stringResource(R.string.main_top_bar_button_chat),
                tint = ShinMunGoTheme.color.gray1,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(24.dp)
                    .noRippleClickable(onClick = onClickChatButton),
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_hammenu_line_white_24),
                contentDescription = stringResource(R.string.main_top_bar_button_chat),
                tint = ShinMunGoTheme.color.gray1,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
                    .noRippleClickable(onClick = onClickMenuButton),
            )
        }
    )
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    ShinMunGoTheme {
        HomeTopBar()
    }
}