package com.sopt.shinmungo.presentation.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReportViewModel : ViewModel() {
    private val _photoList = MutableStateFlow<List<ReportPhotoItem>>(emptyList())
    val photoList: StateFlow<List<ReportPhotoItem>> get() = _photoList
    private val _showDeleteIcons = MutableStateFlow<Map<Int, Boolean>>(emptyMap())
    val showDeleteIcons: StateFlow<Map<Int, Boolean>> = _showDeleteIcons

    private val _location = MutableStateFlow<String>("")
    val location: StateFlow<String> get() = _location

    private val _content = MutableStateFlow<String>("")
    val content: StateFlow<String> get() = _content
    private val _isRecommendWord = MutableStateFlow<Boolean>(false)
    val isRecommendWord: StateFlow<Boolean> get() = _isRecommendWord

    private val _phoneNumber = MutableStateFlow<String>("전화번호를 입력해주세요")
    val phoneNumber: StateFlow<String> get() = _phoneNumber
    private val _showPhoneNumber = MutableStateFlow<Boolean>(false)
    val showPhoneNumber: StateFlow<Boolean> get() = _showPhoneNumber

    private val _isReportSharingAgreed = MutableStateFlow(false)
    val isReportSharingAgreed: StateFlow<Boolean> get() = _isReportSharingAgreed

    fun updatePhotoList(newPhotoList: ArrayList<ReportPhotoItem>) {
        _photoList.value = newPhotoList
    }

    fun deletePhotoFromList(deletePhoto: ReportPhotoItem) {
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

    fun updateContent(newContent: String) {
        _content.value = newContent
        val value = _content.value.length >= 5
        updateShowPhoneNumber(value)
    }

    fun updateIsRecommendWord() {
        _isRecommendWord.value = !_isRecommendWord.value
        if (_isRecommendWord.value) {
            _content.value = _content.value + "소방차 전용구역 불법주차 신고입니다."
        } else {
            _content.value = _content.value.replace("소방차 전용구역 불법주차 신고입니다.", "")
        }
    }

    fun updateShowPhoneNumber(value: Boolean) {
        _showPhoneNumber.value = value
        if (_showPhoneNumber.value) {
            _phoneNumber.value = "010-1234-5678"
        } else {
            _phoneNumber.value = "전화번호를 입력해주세요"
        }
    }

    fun updateIsReportSharingAgreed() {
        _isReportSharingAgreed.value = !_isReportSharingAgreed.value
    }
}