package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun PhotoSizeLimitDialog(
    onDismissRequest: () -> Unit
) {
    CustomDialog(
        title = stringResource(id = R.string.alert_title),
        icon = Icons.Default.Close,
        onDismissRequest = onDismissRequest,
        onIconClick = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.photo_size_limit_prefix))
                    withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                        append(stringResource(id = R.string.photo_size_limit_each))
                    }
                    withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                        append(stringResource(id = R.string.photo_size_limit_total))
                    }
                    append(stringResource(id = R.string.photo_size_limit_suffix))
                },
                style = ShinMunGoTheme.typography.body3,
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }

        RoundedCornerTextButton(
            text = stringResource(id = R.string.ok),
            textStyle = ShinMunGoTheme.typography.body4,
            textColor = ShinMunGoTheme.color.gray8,
            backgroundColor = ShinMunGoTheme.color.gray1,
            roundedCornerShape = RoundedCornerShape(10.dp),
            borderLineColor = ShinMunGoTheme.color.gray5,
            onButtonClick = onDismissRequest,
            modifier = Modifier
                .width(281.dp)
                .height(48.dp)
                .padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhotoSizeLimitDialog() {
    ShinMunGoTheme {
        PhotoSizeLimitDialog(
            onDismissRequest = {}
        )
    }
}