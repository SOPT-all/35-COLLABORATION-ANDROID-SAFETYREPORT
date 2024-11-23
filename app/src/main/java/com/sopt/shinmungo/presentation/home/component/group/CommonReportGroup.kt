package com.sopt.shinmungo.presentation.home.component.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.Gray1
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.core.extension.showIf

@Composable
fun CommonReportGroup(
    title: String,
    modifier: Modifier = Modifier,
    onClickRight: (() -> Unit)? = null,
    onClickLeft: (() -> Unit)? = null,
    content: @Composable () -> Unit = {},
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Gray1
        ),
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier.wrapContentSize()
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_previous_home_10),
                    contentDescription = title,
                    tint = ShinMunGoTheme.color.gray8,
                    modifier = Modifier.showIf(onClickLeft != null)
                        .noRippleClickable(onClick = onClickLeft ?: {})
                )

                Text(
                    text = title,
                    style = ShinMunGoTheme.typography.caption5,
                    color = ShinMunGoTheme.color.gray13
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_next_home_10),
                    contentDescription = "",
                    tint = ShinMunGoTheme.color.gray8,
                    modifier = Modifier.showIf(onClickRight != null)
                        .noRippleClickable(onClick = onClickRight ?: {})
                )
            }

            content()
        }
    }
}