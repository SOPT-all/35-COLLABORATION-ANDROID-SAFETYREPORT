package com.sopt.shinmungo.presentation.map

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


open class AddressInputViewModel : ViewModel() {
    protected val _uiState = MutableStateFlow(AddressInputState())
    val uiState: StateFlow<AddressInputState> = _uiState.asStateFlow()

    fun onKeywordSearchClick() {
        _uiState.update { it.copy(isKeywordSearchEnabled = !it.isKeywordSearchEnabled) }
    }

    fun onAddressSearchClick() {
        _uiState.update { it.copy(isAddressSearchEnabled = !it.isAddressSearchEnabled) }
    }

}