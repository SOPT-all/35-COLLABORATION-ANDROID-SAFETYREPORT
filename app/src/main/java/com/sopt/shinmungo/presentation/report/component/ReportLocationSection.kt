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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerIconButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.report.type.ReportSectionType
import com.sopt.shinmungo.presentation.report.ReportViewModel

@Composable
fun ReportLocationSection(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    val location = viewModel.location.collectAsStateWithLifecycle("")

    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            ReportSectionTitle(
                text = ReportSectionType.LOCATION.type,
            )

            Spacer(modifier = Modifier.height(8.dp))

            LocationText(location = location.value)
        }

        Spacer(modifier = Modifier.weight(1f))

        RoundedCornerIconButton(
            icon = R.drawable.ic_report_location_24px,
            isButtonActive = true,
            onButtonClick = {
                /* 지도 페이지로 이동 */
                viewModel.updateLocation("서울특별시 마포구 땡땡로12로 3")
            }
        )
    }
}

@Composable
fun LocationText(location: String) {
    val locationText = if (location.isEmpty()) {
        "지역을 입력해주세요"
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
            contentDescription = "위치 아이콘",
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

@Preview(showBackground = true)
@Composable
fun ReportLocationSectionPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ReportLocationSection(viewModel)
    }
}