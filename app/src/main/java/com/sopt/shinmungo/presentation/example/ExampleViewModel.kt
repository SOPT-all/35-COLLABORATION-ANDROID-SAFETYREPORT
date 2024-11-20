package com.sopt.shinmungo.presentation.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.repository.RepositoryPool
import com.sopt.shinmungo.presentation.example.state.ExampleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


/**TODO: 이해를 위한 예시 뷰모델 구현 (삭제될 예정)*/
class ExampleViewModel : ViewModel() {
    private val repository = RepositoryPool.exampleRepository

    private val _uiState = MutableStateFlow(ExampleUiState())
    val uiState = _uiState.asStateFlow()

    fun getExample() = viewModelScope.launch {
        val token = "Example_Token"
        repository.getExample(token)
            .onSuccess {
                //성공한 경우 상태 업데이트
                _uiState.update { currentState ->
                    currentState.copy(
                        loadState = UiState.Success(it)
                    )
                }
            }
            .onFailure { error ->
                //실패한 경우 상태 업데이트
                _uiState.update { currentState ->
                    currentState.copy(
                        loadState = UiState.Error(error.message?: "알 수 없는 오류")
                    )
                }
            }
    }
}