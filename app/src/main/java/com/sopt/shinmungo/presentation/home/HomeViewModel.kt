package com.sopt.shinmungo.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.HomeInformation
import com.sopt.shinmungo.presentation.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    //TODO: 임시로 UiState를 초기화하는 함수 (삭제 예정)
    fun initUiState() = _uiState.update { currentState ->
        currentState.copy(
            loadState = UiState.Success(
                HomeInformation(
                    userId = 1,
                    name = "수민",
                    yearReportCount = 7,
                    monthReportCount = 25,
                    mileage = "5000000",
                    bannerUrls = listOf(
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1731578316860877739.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202411/1732149068770235113.webp",
                        "https://image.wavve.com/v1/thumbnails/2480_1396_20_80/meta/image/202410/1730192950897967795.webp"
                    )
                )
            )
        )
    }
}