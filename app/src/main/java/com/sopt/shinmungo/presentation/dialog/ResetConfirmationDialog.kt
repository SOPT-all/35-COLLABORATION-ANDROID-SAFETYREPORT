package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun ResetConfirmationDialog(
    onDismissRequest: () -> Unit,
    onConfirmClick: () -> Unit
) {
    CustomDialog(
        title = stringResource(id = R.string.alert_title),
        icon = Icons.Default.Close,
        onDismissRequest = onDismissRequest,
        onIconClick = onDismissRequest
    ) {
        Text(
            text = stringResource(id = R.string.reset_confirmation_message),
            style = ShinMunGoTheme.typography.body3,
            color = ShinMunGoTheme.color.gray13,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {

                RoundedCornerTextButton(
                    text = stringResource(id = R.string.cancel),
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.gray8,
                    backgroundColor = ShinMunGoTheme.color.gray1,
                    roundedCornerShape = RoundedCornerShape(10.dp),
                    borderLineColor = ShinMunGoTheme.color.gray5,
                    onButtonClick = onDismissRequest,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RoundedCornerTextButton(
                    text = stringResource(id = R.string.ok),
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.primary,
                    backgroundColor = ShinMunGoTheme.color.gray1,
                    roundedCornerShape = RoundedCornerShape(10.dp),
                    borderLineColor = ShinMunGoTheme.color.primaryLight,
                    onButtonClick = onConfirmClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewResetConfirmationDialog() {
    ShinMunGoTheme {
        ResetConfirmationDialog(
            onDismissRequest = {},
            onConfirmClick = {}
        )
    }
}
