package com.sopt.shinmungo.presentation.allcategory.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.domain.entity.AllCategoryEntity

/**
 * 개별 카테고리를 화면에 표시하는 컴포저블 함수입니다.
 *
 * @param category 카테고리 정보를 포함하는 데이터 객체입니다.
 * @param isExpanded 카테고리가 확장 상태인지 여부를 나타냅니다.
 * @param reportableItems 해당 카테고리에서 신고 가능한 항목 리스트입니다.
 * @param onClick 카테고리를 클릭했을 때 호출되는 콜백 함수입니다.
 */

@Composable
fun AllCategoryComponent(
    category: AllCategoryEntity,
    isExpanded: Boolean,
    reportableItems: List<String>,
    onClick: () -> Unit,
    onNavigateToReport: () -> Unit
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
                    style = ShinMunGoTheme.typography.body4,
                    color = ShinMunGoTheme.color.gray13,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_info_circle_16px),
                    contentDescription = stringResource(id = R.string.info_icon_description),
                    tint = ShinMunGoTheme.color.gray13,
                    modifier = Modifier.size(16.dp)
                )
            }

            if (isExpanded) {
                RoundedCornerTextButton(
                    text = stringResource(id = R.string.all_category_select_button),
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.gray1,
                    backgroundColor = ShinMunGoTheme.color.primary,
                    roundedCornerShape = RoundedCornerShape(4.dp),
                    onButtonClick = {
                        if (category.title == "불법 주정차") {
                            onNavigateToReport()
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 8.dp)
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
                        text = stringResource(id = R.string.all_category_reportable_hint),
                        style = ShinMunGoTheme.typography.caption3,
                        color = ShinMunGoTheme.color.gray13
                    )

                    if (category.title == "불법 주정차") {
                        val rightAlignedItems = listOf("장애인 전용구역", "소방차 전용구역", "친환경차 전용구역")
                        val leftAlignedItems = reportableItems.filterNot { it in rightAlignedItems }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(5.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                leftAlignedItems.forEach { item ->
                                    Text(
                                        text = "• $item",
                                        style = ShinMunGoTheme.typography.caption3,
                                        color = ShinMunGoTheme.color.gray13
                                    )
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(5.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                rightAlignedItems.forEach { item ->
                                    Text(
                                        text = "• $item",
                                        style = ShinMunGoTheme.typography.caption3,
                                        color = ShinMunGoTheme.color.gray13
                                    )
                                }
                            }
                        }
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            reportableItems.forEach { item ->
                                Text(
                                    text = "• $item",
                                    style = ShinMunGoTheme.typography.caption3,
                                    color = ShinMunGoTheme.color.gray13
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAllCategoryComponent() {
    ShinMunGoTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ShinMunGoTheme.color.gray2)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AllCategoryComponent(
                category = AllCategoryEntity(
                    title = "불법 주정차",
                    description = "불법 주정차 관련 신고 항목",
                    reportableItems = listOf("소화전", "교차로 모퉁이", "횡단보도", "버스 정류소")
                ),
                isExpanded = true,
                reportableItems = listOf("소화전", "교차로 모퉁이", "횡단보도", "버스 정류소"),
                onClick = { println("불법 주정차 클릭") },
                onNavigateToReport = { println("ReportScreen으로 이동") }
            )
            AllCategoryComponent(
                category = AllCategoryEntity(
                    title = "안전",
                    description = "안전 관련 신고 항목",
                    reportableItems = listOf("가로등 고장", "도로 표지판 손상", "건물 외벽 위험 요소")
                ),
                isExpanded = false,
                reportableItems = listOf("가로등 고장", "도로 표지판 손상", "건물 외벽 위험 요소"),
                onClick = { println("안전 카테고리 클릭") },
                onNavigateToReport = { println("ReportScreen으로 이동") }
            )
        }
    }
}


