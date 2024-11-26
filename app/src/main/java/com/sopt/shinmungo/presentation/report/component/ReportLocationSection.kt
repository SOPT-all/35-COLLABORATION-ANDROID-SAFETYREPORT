package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerIconButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.report.type.ReportSectionType

@Composable
fun ReportLocationSection(
    location: String,
    onLocationButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            ReportSectionTitle(
                text = ReportSectionType.LOCATION.type,
            )

            Spacer(modifier = Modifier.height(8.dp))

            LocationText(location = location)
        }

        Spacer(modifier = Modifier.weight(1f))

        RoundedCornerIconButton(
            icon = R.drawable.ic_report_location_24px,
            isButtonActive = true,
            onButtonClick = {
                /* 지도 페이지로 이동 */
                onLocationButtonClick("서울특별시 마포구 땡땡로12로 3")
            }
        )
    }
}

@Composable
fun LocationText(location: String) {
    val locationText = if (location.isEmpty()) {
        stringResource(R.string.report_location_placeholder)
    } else {
        location
    }

    val locationColor = if (location.isEmpty()) {
        ShinMunGoTheme.color.gray6
    } else {
        ShinMunGoTheme.color.gray11
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_report_location_24px),
            contentDescription = stringResource(R.string.report_location_icon_content_description),
            tint = locationColor,
            modifier = Modifier.size(16.dp)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = locationText,
            style = ShinMunGoTheme.typography.body8,
            color = locationColor
        )
    }
}