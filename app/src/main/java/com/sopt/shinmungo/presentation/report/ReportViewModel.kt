package com.sopt.shinmungo.presentation.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReportViewModel : ViewModel() {
    private val _photoList = MutableStateFlow<List<PhotoItem>>(emptyList())
    val photoList: StateFlow<List<PhotoItem>> get() = _photoList
    private val _showDeleteIcons = MutableStateFlow<Map<Int, Boolean>>(emptyMap())
    val showDeleteIcons: StateFlow<Map<Int, Boolean>> = _showDeleteIcons

    private val _location = MutableStateFlow<String>("")
    val location: StateFlow<String> get() = _location

    fun updatePhotoList(newPhotoList: ArrayList<PhotoItem>) {
        _photoList.value = newPhotoList
    }

    fun deletePhotoFromList(deletePhoto: PhotoItem) {
        _photoList.value = _photoList.value.filter { it.photoId != deletePhoto.photoId }
    }

    fun showDeleteIconForPhoto(photoId: Int) {
        _showDeleteIcons.value = _showDeleteIcons.value + (photoId to true)

        viewModelScope.launch {
            delay(3000)
            _showDeleteIcons.value = _showDeleteIcons.value - photoId
        }
    }

    fun updateLocation(newLocation: String) {
        _location.value = newLocation
    }
}