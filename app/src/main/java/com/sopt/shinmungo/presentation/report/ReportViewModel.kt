package com.sopt.shinmungo.presentation.report

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReportViewModel : ViewModel() {
    val photoList: StateFlow<ArrayList<PhotoItem>>
        field = MutableStateFlow(arrayListOf())

    fun updatePhotoList(newPhotoList: ArrayList<PhotoItem>) {
        photoList.value.addAll(newPhotoList)
    }

    fun deletePhotoFromList(deletePhoto: PhotoItem) {
        photoList.value.remove(deletePhoto)
    }
}