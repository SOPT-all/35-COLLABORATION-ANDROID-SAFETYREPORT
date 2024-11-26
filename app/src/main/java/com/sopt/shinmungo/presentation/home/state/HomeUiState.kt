package com.sopt.shinmungo.presentation.home.state

import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.HomeInformation

data class HomeUiState(
    val loadState: UiState<HomeInformation> = UiState.Loading
)
