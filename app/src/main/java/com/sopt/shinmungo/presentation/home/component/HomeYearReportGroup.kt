package com.sopt.shinmungo.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.progress.CommonProgressIndicator
import com.sopt.shinmungo.core.designsystem.component.text.ColorAnnotatedText
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.home.component.group.CommonReportGroup

@Composable
fun HomeYearReportGroup(
    title: String,
    reportCount: String,
    reportProgress: Float,
    replyProgress: Float,
    totalProgress: Float,
    modifier: Modifier = Modifier,
) {
    val reportTextList = listOf(
        Pair(
            stringResource(R.string.main_year_report_report_text_1),
            ShinMunGoTheme.color.gray13
        ),
        Pair(reportCount, ShinMunGoTheme.color.primary),
        Pair(
            stringResource(R.string.main_year_report_report_text_2),
            ShinMunGoTheme.color.gray13
        )
    )

    val reportDescriptionTextList = listOf(
        Pair(
            stringResource(R.string.main_year_report_report_description_1),
            ShinMunGoTheme.color.primary
        ),
        Pair(
            stringResource(R.string.main_year_report_report_description_2),
            ShinMunGoTheme.color.gray8
        ),
    )


    CommonReportGroup(
        title = title,
        modifier = modifier,
    ) {
        ColorAnnotatedText(
            pairList = reportTextList,
            style = ShinMunGoTheme.typography.body2.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp)
        )
        ColorAnnotatedText(
            pairList = reportDescriptionTextList,
            style = ShinMunGoTheme.typography.caption9.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
        )

        CommonProgressIndicator(
            progress = reportProgress,
            modifier = Modifier
                .padding(top = 12.dp, start = 5.dp, end = 5.dp)
                .fillMaxWidth()
                .height(20.dp)
        )

        HomeReportGroupTextWithProgress(
            progress = replyProgress,
            style = ShinMunGoTheme.typography.caption7,
            text = stringResource(R.string.main_year_report_progress_reply),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )

        HomeReportGroupTextWithProgress(
            progress = totalProgress,
            style = ShinMunGoTheme.typography.caption9,
            text = stringResource(R.string.main_year_report_progress_total),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        )
    }
}

@Composable
private fun HomeReportGroupTextWithProgress(
    text: String,
    style: TextStyle,
    progress: Float,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End)
    ) {
        Text(
            text = text,
            style = style,
            color = ShinMunGoTheme.color.gray13,
        )
        CommonProgressIndicator(
            progress = progress,
            trackColor = ShinMunGoTheme.color.gray4,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 28.dp, height = 4.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeYearReportItemPreview(
    modifier: Modifier = Modifier
) {
    ShinMunGoTheme {
        HomeYearReportGroup(
            title = "나의 올해 신고",
            reportCount = "25",
            reportProgress = 0.7f,
            replyProgress = 1f,
            totalProgress = 0f,
            modifier = Modifier.size(width = 160.dp, height = 156.dp)
        )
    }
}