package com.sopt.shinmungo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.core.exception.EmptyThrowable
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.HomeInformation
import com.sopt.shinmungo.domain.repository.HomeRepository
import com.sopt.shinmungo.domain.repository.RepositoryPool
import com.sopt.shinmungo.presentation.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeViewModel : ViewModel() {
    private val repository: HomeRepository = RepositoryPool.homeRepository

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun getHomeInformation() = viewModelScope.launch {
        Timber.tag("HomeViewModel").d("GetHomeInformation Called")
        repository.getHomeInformation()
            .onSuccess { homeInformation ->
                Timber.tag("HomeViewModel").d("${homeInformation.mileage}, ${homeInformation.userId}")
                updateLoadState(loadState = UiState.Success(homeInformation))
            }
            .onFailure { exception ->
                Timber.tag("HomeViewModel").d("${exception.printStackTrace()}")
                if (exception.cause == EmptyThrowable()) {
                    updateLoadState(loadState = UiState.Empty)
                } else {
                    updateLoadState(loadState = UiState.Error(ERROR_MESSAGE))
                }
            }
    }

    private fun updateLoadState(loadState: UiState<HomeInformation>) =
        _uiState.update { currentState ->
            currentState.copy(
                loadState = loadState
            )
        }

    companion object {
        private const val ERROR_MESSAGE = "에러가 발생했습니다."
    }
}