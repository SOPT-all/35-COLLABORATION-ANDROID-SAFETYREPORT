package com.sopt.shinmungo.presentation.home.component.group

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.text.ColorAnnotatedText
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun HomeMonthReportGroup(
    title: String,
    userName: String,
    reportCount: String,
    modifier: Modifier = Modifier,
    onClickPrevious: () -> Unit = {},
    onClickNext: () -> Unit = {},
) {
    val reportTextList = listOf(
        Pair(
            reportCount,
            ShinMunGoTheme.color.primary
        ),
        Pair(stringResource(R.string.main_month_report_report_count), ShinMunGoTheme.color.gray13),
    )

    CommonReportGroup(
        title = title,
        modifier = modifier,
        onClickLeft = onClickPrevious,
        onClickRight = onClickNext
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_graph_home_107),
                contentDescription = stringResource(R.string.main_month_report_description_graph),
                tint = Color.Unspecified
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ColorAnnotatedText(
                    pairList = reportTextList,
                    style = ShinMunGoTheme.typography.body2
                )
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = stringResource(R.string.main_month_report_username, userName),
                    style = ShinMunGoTheme.typography.caption9,
                    textAlign = TextAlign.Center,
                    color = ShinMunGoTheme.color.gray8
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeReportItemPreview(
) {
    ShinMunGoTheme {
        HomeMonthReportGroup(
            title = "2024년 10월",
            userName = "김철수",
            reportCount = "25",
            modifier = Modifier.size(width = 160.dp, height = 156.dp)
        )
    }
}