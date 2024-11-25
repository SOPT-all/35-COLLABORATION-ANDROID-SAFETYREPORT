package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.core.designsystem.component.button.CheckButtonWithTextInfoIcon
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.report.type.ReportSectionType
import com.sopt.shinmungo.presentation.report.ReportViewModel

@Composable
fun ReportPhoneNumberSection(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    val showPhoneNumber = viewModel.showPhoneNumber.collectAsStateWithLifecycle()
    val phoneNumber = viewModel.phoneNumber.collectAsStateWithLifecycle()
    val isReportSharingAgreed = viewModel.isReportSharingAgreed.collectAsStateWithLifecycle()

    Column {
        ReportSectionTitle(
            text = ReportSectionType.PHONE_NUMBER.type,
            isIconApplied = false
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, ShinMunGoTheme.color.gray5, RoundedCornerShape(5.dp))
                .background(
                    color = ShinMunGoTheme.color.gray3
                )
                .padding(14.dp)
        ) {
            Text(
                text = phoneNumber.value,
                style = ShinMunGoTheme.typography.body9,
                color = if (showPhoneNumber.value) ShinMunGoTheme.color.gray13 else ShinMunGoTheme.color.opacityGray13Per40
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        CheckButtonWithTextInfoIcon(
            text = stringResource(R.string.report_sharing_agreed),
            isChecked = isReportSharingAgreed.value,
            isIconApplied = true,
            onButtonClick = { viewModel.updateIsReportSharingAgreed() }
        )
    }
}