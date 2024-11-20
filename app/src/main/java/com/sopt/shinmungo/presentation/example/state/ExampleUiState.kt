package com.sopt.shinmungo.presentation.example.state

import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.Example

data class ExampleUiState(
    val loadState: UiState<Example> = UiState.Loading
)
