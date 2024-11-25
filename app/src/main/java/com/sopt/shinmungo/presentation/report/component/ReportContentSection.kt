package com.sopt.shinmungo.presentation.report.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerIconButton
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.CheckButtonWithTextInfoIcon
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.extension.noRippleClickable
import com.sopt.shinmungo.presentation.report.type.ReportSectionType
import com.sopt.shinmungo.presentation.report.ReportViewModel

@Composable
fun ReportContentSection(
    viewModel: ReportViewModel,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Column {
                ReportSectionTitle(
                    text = ReportSectionType.CONTENT.type
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.report_content_hint),
                    style = ShinMunGoTheme.typography.caption3,
                    color = ShinMunGoTheme.color.primary
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            RoundedCornerIconButton(
                icon = R.drawable.ic_report_mic_24px,
                isButtonActive = true,
                onButtonClick = { /* 추후 기능 연결 */ }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        ReportContentTextField(viewModel)
    }
}

@Composable
fun ReportContentTextField(viewModel: ReportViewModel) {
    val content = viewModel.content.collectAsStateWithLifecycle()
    val isRecommendWord = viewModel.isRecommendWord.collectAsStateWithLifecycle()

    Column {
        Box(
            modifier = Modifier
                .border(1.dp, ShinMunGoTheme.color.gray5, RoundedCornerShape(5.dp))
                .background(
                    color = if (content.value.isEmpty()) ShinMunGoTheme.color.gray3 else ShinMunGoTheme.color.gray1
                )
                .padding(12.dp)
        ) {
            BasicTextField(
                value = content.value,
                onValueChange = { viewModel.updateContent(it) },
                textStyle = ShinMunGoTheme.typography.body9,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )

            if (content.value.isEmpty()) {
                Text(
                    text = stringResource(R.string.report_content_placeholder),
                    style = ShinMunGoTheme.typography.body9,
                    color = ShinMunGoTheme.color.opacityGray13Per40,
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckButtonWithTextInfoIcon(
                text = stringResource(R.string.report_recommend_word),
                isChecked = isRecommendWord.value,
                isIconApplied = false,
                onButtonClick = { viewModel.updateIsRecommendWord() }
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.noRippleClickable { /* 내용 복사 기능 */ },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_report_copy_16px),
                    contentDescription = stringResource(R.string.report_copy_icon_content_description),
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(R.string.report_content_copy),
                    style = ShinMunGoTheme.typography.caption3,
                    color = ShinMunGoTheme.color.gray13
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportContentSectionPreview(modifier: Modifier = Modifier) {
    val viewModel = ReportViewModel()
    ShinMunGoTheme {
        ReportContentSection(viewModel)
    }
}