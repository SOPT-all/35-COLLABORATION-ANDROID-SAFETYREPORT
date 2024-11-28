package com.sopt.shinmungo.presentation.allcategory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.sopt.shinmungo.domain.entity.AllCategoryEntity
import com.sopt.shinmungo.domain.repository.AllCategoryRepository

class AllCategoryViewModel : ViewModel() {
    private val repository = AllCategoryRepository()

    private val _categories = MutableStateFlow<List<AllCategoryEntity>>(emptyList())
    val categories: StateFlow<List<AllCategoryEntity>> = _categories

    private val _expandedStates = MutableStateFlow<List<Boolean>>(emptyList())
    val expandedStates: StateFlow<List<Boolean>> = _expandedStates


    fun fetchCategories() {
        viewModelScope.launch {
            repository.fetchDescriptions().onSuccess { categories ->
                _categories.value = categories
                _expandedStates.value = List(_categories.value.size) { false }

            }
        }
    }

    fun toggleCategoryExpanded(index: Int) {
        _expandedStates.value = _expandedStates.value.mapIndexed { i, isExpanded ->
            if (i == index) !isExpanded else isExpanded
        }
    }
}