package com.sopt.shinmungo.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.dialog.CustomDialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun FireTruckIllegalParkingDialog(
    onDismissRequest: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val dialogWidth = screenWidth * 0.8f

    CustomDialog(
        title = stringResource(id = R.string.fire_truck_illegal_parking_title),
        modifier = Modifier.width(dialogWidth),
        icon = ImageVector.vectorResource(id = R.drawable.icn_sound_white_24px),
        onDismissRequest = onDismissRequest
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ShinMunGoTheme.color.opacityGray13Per5,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_alert_line_red_16px),
                        contentDescription = stringResource(id = R.string.alert_icon_description),
                        tint = ShinMunGoTheme.color.primaryRed,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.illegal_parking_warning),
                        style = ShinMunGoTheme.typography.caption2,
                        color = ShinMunGoTheme.color.primaryRed
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.parking4),
                    contentDescription = stringResource(id = R.string.illegal_parking_example_1),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(143.dp)
                        .height(109.dp)
                        .padding(end = 4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.parking3),
                    contentDescription = stringResource(id = R.string.illegal_parking_example_2),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(143.dp)
                        .height(109.dp)
                        .padding(start = 4.dp)
                )
            }


            Text(
                text = stringResource(id = R.string.illegal_parking_description),
                style = ShinMunGoTheme.typography.body9,
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = stringResource(id = R.string.illegal_parking_details),
                style = ShinMunGoTheme.typography.body9,
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(top = 19.dp, bottom = 30.dp)
            )

            RoundedCornerTextButton(
                text = stringResource(id = R.string.ok),
                textStyle = ShinMunGoTheme.typography.body4,
                textColor = ShinMunGoTheme.color.gray8,
                borderLineColor = ShinMunGoTheme.color.gray5,
                backgroundColor = ShinMunGoTheme.color.gray1,
                roundedCornerShape = RoundedCornerShape(10.dp),
                onButtonClick = onDismissRequest,
                modifier = Modifier
                    .width(281.dp)
                    .height(48.dp)
                    .padding(top = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFireTruckIllegalParkingDialog() {
    ShinMunGoTheme {
        FireTruckIllegalParkingDialog(
            onDismissRequest = { /* 닫기 동작 */ }
        )
    }
}
