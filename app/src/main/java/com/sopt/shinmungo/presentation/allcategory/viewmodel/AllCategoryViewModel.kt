package com.sopt.shinmungo.presentation.allcategory.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.sopt.shinmungo.domain.entity.AllCategoryEntity

class AllCategoryViewModel : ViewModel() {
    private val _categories = MutableStateFlow(
        listOf(
            AllCategoryEntity(
                title = "안전",
                description = "가로등 점검사항, 도로/시설물 파손 및 고장 등.",
                reportableItems = listOf("가로등 고장", "도로 표지판 손상", "건물 외벽 위험 요소")
            ),
            AllCategoryEntity(
                title = "불법 주정차",
                description = "장애인 전용 구역, 소화전 근처 등.",
                reportableItems = listOf("장애인 전용 구역 위반", "소화전 주변 주차", "횡단보도 위 주정차")
            ),
            AllCategoryEntity(
                title = "자동차/교통위반",
                description = "교통사고, 불법 유턴 등.",
                reportableItems = listOf("불법 유턴", "신호 위반", "속도 위반")
            ),
            AllCategoryEntity(
                title = "생활불편",
                description = "쓰레기 무단투기, 불법 광고물 등.",
                reportableItems = listOf("무단 투기 쓰레기", "불법 광고물 게시", "공공장소 방치물")
            )
        )
    )
    val categories: StateFlow<List<AllCategoryEntity>> = _categories

    private val _expandedStates = MutableStateFlow(List(_categories.value.size) { false })
    val expandedStates: StateFlow<List<Boolean>> = _expandedStates

    fun toggleCategoryExpanded(index: Int) {
        _expandedStates.update { states ->
            states.mapIndexed { i, isExpanded ->
                if (i == index) !isExpanded else isExpanded
            }
        }
    }
}
