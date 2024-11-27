package com.sopt.shinmungo.presentation.gallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.domain.entity.Photo
import com.sopt.shinmungo.domain.repository.RepositoryPool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class GalleryViewModel : ViewModel() {
    private val repository = RepositoryPool.galleryRepository
    private val _state = MutableStateFlow(GalleryState())
    val state = _state.asStateFlow()

    private val _userId = MutableStateFlow(1L)
    val userId = _userId.asStateFlow()

    init {
        loadPhotos()
    }

    fun onEvent(event: GalleryEvent) {
        when (event) {
            is GalleryEvent.LoadPhotos -> loadPhotos()
            is GalleryEvent.SelectPhoto -> selectPhoto(event.photoId)
            is GalleryEvent.DeselectPhoto -> deselectPhoto(event.photoId)
            GalleryEvent.DismissError -> dismissError()
        }
    }

    private fun loadPhotos() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }

        repository.getPhotos(userId.value)
            .onSuccess { photos ->
                val photosByDate = photos.groupBy { it.timestamp.toLocalDate() }
                _state.update { it.copy(
                    photos = photosByDate,
                    isLoading = false
                )}
            }
            .onFailure { error ->
                _state.update { it.copy(
                    error = error.message ?: "알 수 없는 오류",
                    isLoading = false
                )}
                Log.d("GalleryViewModel", "loadPhotos: $error")
            }
    }

    private fun selectPhoto(photoId: Int) {
        _state.update { it.copy(
            selectedPhotos = it.selectedPhotos + photoId
        )}
    }

    private fun deselectPhoto(photoId: Int) {
        _state.update { it.copy(
            selectedPhotos = it.selectedPhotos - photoId
        )}
    }

    private fun dismissError() {
        _state.update { it.copy(error = null) }
    }

}

sealed class GalleryEvent {
    object LoadPhotos : GalleryEvent()
    data class SelectPhoto(val photoId: Int) : GalleryEvent()
    data class DeselectPhoto(val photoId: Int) : GalleryEvent()
    object DismissError : GalleryEvent()
}