package com.sopt.shinmungo.presentation.allcategory.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun AllCategoryTopBar(
    onNavigateBack: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        CommonTopBar(
            title = "",
            onLeftContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                            contentDescription = stringResource(id = R.string.back_button_description),
                            tint = ShinMunGoTheme.color.gray1
                        )
                    }
                }
            }
        )

        Text(
            text = stringResource(id = R.string.all_category_title),
            style = ShinMunGoTheme.typography.heading2,
            color = ShinMunGoTheme.color.gray1,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
