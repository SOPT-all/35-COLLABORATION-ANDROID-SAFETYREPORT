package com.sopt.shinmungo.presentation.allcategory.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.allcategory.screen.ReportCategory

/**
 * 카테고리 항목 컴포넌트
 */
@Composable
fun ReportCategoryItem(
    category: ReportCategory,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ShinMunGoTheme.color.gray3,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = category.title,
                    style = ShinMunGoTheme.typography.heading2.copy(fontSize = 15.sp),
                    color = ShinMunGoTheme.color.gray13,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_info_circle_16px),
                    contentDescription = "Info Icon",
                    tint = ShinMunGoTheme.color.gray13,
                    modifier = Modifier.size(16.dp)
                )
            }

            if (isExpanded) {
                RoundedCornerTextButton(
                    text = "선택하기",
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.gray1,
                    backgroundColor = ShinMunGoTheme.color.primary,
                    roundedCornerShape = RoundedCornerShape(4.dp),
                    onButtonClick = { /* 신고하기 로직 */ },
                    modifier = Modifier
                        .width(92.dp)
                        .padding(vertical = 8.dp)
                )
            }
        }

        if (isExpanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ShinMunGoTheme.color.gray1,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 9.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "아래의 경우 신고할 수 있는 유형입니다.",
                        style = ShinMunGoTheme.typography.body3.copy(lineHeight = 20.sp),
                        color = ShinMunGoTheme.color.gray10
                    )
                    // 다이나믹 리스트 항목
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        listOf(
                            "교통위반(고속도로 포함)",
                            "이륜차 위반",
                            "버스전용차로 위반 (고속도로 제외)",
                            "불법등화, 반사판(지) 기름, 손상",
                            "불법 튜닝, 해체, 조작",
                            "기타 자동차 안전기준 위반"
                        ).forEach { item ->
                            Text(
                                text = "• $item",
                                style = ShinMunGoTheme.typography.body4,
                                color = ShinMunGoTheme.color.gray10
                            )
                        }
                    }
                }
            }
        }
    }
}
