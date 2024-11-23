package com.sopt.shinmungo.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

@Composable
fun HomeMileageTitleGroup(
    mileage: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.main_title_my_report),
            color = ShinMunGoTheme.color.gray13,
            style = ShinMunGoTheme.typography.body2
        )

        MileageText(mileage)
    }
}

@Composable
private fun MileageText(
    mileage: String,
    textStyle: TextStyle = ShinMunGoTheme.typography.caption7,
    textColor: Color = ShinMunGoTheme.color.gray13
) {
    Row {
        Text(
            text = stringResource(R.string.main_mileage_title),
            color = textColor,
            style = textStyle
        )
        Text(
            text = mileage,
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(start = 6.dp)
        )
        Text(
            text = stringResource(R.string.main_mileage_point),
            color = textColor,
            style = textStyle,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MileageTitleGroupPreview() {
    ShinMunGoTheme {
        HomeMileageTitleGroup(
            mileage = "5,000,000",
            modifier = Modifier.fillMaxWidth()
        )
    }
}