package com.sopt.shinmungo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.HomeInformation
import com.sopt.shinmungo.domain.repository.HomeRepository
import com.sopt.shinmungo.domain.repository.RepositoryPool
import com.sopt.shinmungo.presentation.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {
    private val repository: HomeRepository = RepositoryPool.homeRepository

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun getHomeInformation() = viewModelScope.launch {
        repository.getHomeInformation()
            .onSuccess { homeInformation ->
                updateLoadState(loadState = UiState.Success(homeInformation))
            }
            .onFailure { exception ->
                updateLoadState(loadState = UiState.Empty)
                exception.printStackTrace()
            }
    }

    private fun updateLoadState(loadState: UiState<HomeInformation>) =
        _uiState.update { currentState ->
            currentState.copy(
                loadState = loadState
            )
        }
}