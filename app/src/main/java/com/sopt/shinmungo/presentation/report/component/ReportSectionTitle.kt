package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.presentation.report.type.ReportSectionType
import com.sopt.shinmungo.presentation.report.type.ReportSectionType.Companion.toContentTypeOrThrow

@Composable
fun ReportSectionTitle(
    text: String,
    isIconApplied: Boolean = true,
    onInfoIconClick: (ReportSectionType) -> Unit = { },
    modifier: Modifier = Modifier
) {
    Row {
        Text(
            text = text,
            style = ShinMunGoTheme.typography.body4,
            color = ShinMunGoTheme.color.gray13
        )
        Spacer(modifier = Modifier.width(1.dp))
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_report_orange_star),
            contentDescription = stringResource(R.string.report_orange_star_content_description),
            tint = Color.Unspecified,
            modifier = Modifier.padding(vertical = 1.dp)
        )
        if (isIconApplied) {
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_info_circle_16px),
                contentDescription = stringResource(R.string.report_info_icon_content_description),
                tint = Color.Unspecified,
                modifier = Modifier.noRippleClickable {
                    val type = text.toContentTypeOrThrow()
                    onInfoIconClick(type)
                }
            )
        }
    }
}

@Preview
@Composable
fun ReportSectionTitlePreview(modifier: Modifier = Modifier) {
    ShinMunGoTheme {
        ReportSectionTitle(
            text = "사진",
        )
    }
}