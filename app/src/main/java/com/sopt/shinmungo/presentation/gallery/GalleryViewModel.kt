package com.sopt.shinmungo.presentation.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.domain.entity.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

sealed class GalleryEvent {
    object LoadPhotos : GalleryEvent()
    data class SelectPhoto(val photoId: Int) : GalleryEvent()
    data class DeselectPhoto(val photoId: Int) : GalleryEvent()
    object DismissError : GalleryEvent()
}

class GalleryViewModel : ViewModel() {

    // Dummy Data 생성 - 삭제 예정
    val dummyPhotos = (0..9).map { index ->
        Photo(
            id = index,
            url = "https://picsum.photos/200/300?random=$index",
            timestamp = if (index < 5) {
                LocalDateTime.now()
            } else {
                LocalDateTime.now().minusDays(1L)
            }
        )
    }

    private val _state = MutableStateFlow(GalleryState())
    val state = _state.asStateFlow()

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

    private fun loadPhotos() {
        _state.update { it.copy(isLoading = true) }

        val photosByDate = dummyPhotos.groupBy { it.timestamp.toLocalDate() }

        _state.update { it.copy(
            photos = photosByDate,
            isLoading = false
        )}
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