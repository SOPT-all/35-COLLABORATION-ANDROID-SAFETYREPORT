package com.sopt.shinmungo.presentation.allcategory.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            title = stringResource(id = R.string.all_category_title),
            onLeftContent = {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = onNavigateBack) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = stringResource(id = R.string.back_button_description),
                        tint = ShinMunGoTheme.color.gray1
                    )
                }
            }
        )

//        Text(
//            text = stringResource(id = R.string.all_category_title),
//            style = ShinMunGoTheme.typography.heading2,
//            color = ShinMunGoTheme.color.gray1,
//            modifier = Modifier.align(Alignment.Center)
//        )
    }
}

@Preview(showBackground = true, name = "All Category Top Bar")
@Composable
fun PreviewAllCategoryTopBar() {
    ShinMunGoTheme {
        AllCategoryTopBar(
            onNavigateBack = { /* 뒤로가기 버튼 클릭 시 동작 */ }
        )
    }
}
