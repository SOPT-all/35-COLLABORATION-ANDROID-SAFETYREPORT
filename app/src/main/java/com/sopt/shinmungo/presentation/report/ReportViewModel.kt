package com.sopt.shinmungo.presentation.report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.shinmungo.domain.entity.ReportPhotoItem
import com.sopt.shinmungo.presentation.report.state.ReportDialogState
import com.sopt.shinmungo.presentation.report.type.ReportDialogType
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class ReportViewModel : ViewModel() {
    val illegalParkingCategory = listOf(
        "소화전",
        "교차로 모퉁이",
        "버스 정류소",
        "횡단보도",
        "어린이 보호구역",
        "인도",
        "기타",
        "장애인 전용구역",
        "소방차 전용구역",
        "친환경차 전용구역"
    )

    private val _dialogState: MutableStateFlow<ReportDialogState> = MutableStateFlow(ReportDialogState())
    val dialogState:StateFlow<ReportDialogState> = _dialogState.asStateFlow()

    private val _deletePhoto: MutableStateFlow<ReportPhotoItem?> = MutableStateFlow(null)
    val deletePhoto: StateFlow<ReportPhotoItem?> get() = _deletePhoto.asStateFlow()

    private val _isCategorySelected = MutableStateFlow<Boolean>(false)
    val isCategorySelected: StateFlow<Boolean> get() = _isCategorySelected
    private val _selectedCategory = MutableStateFlow<String>("")
    val selectedCategory: StateFlow<String> get() = _selectedCategory
    private val _isDropdownOpen = MutableStateFlow<Boolean>(false)
    val isDropdownOpen: StateFlow<Boolean> get() = _isDropdownOpen

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


    private val _cameraCooldownTime = MutableStateFlow(0)
    val cameraCooldownTime: StateFlow<Int> get() = _cameraCooldownTime
    private val _isCameraButtonActive = MutableStateFlow(true)
    val isCameraButtonActive: StateFlow<Boolean> get() = _isCameraButtonActive
    private var countdownJob: Job? = null

    val isPostButtonActive: StateFlow<Boolean> = combine(
        _photoList, _location, _content, _isReportSharingAgreed
    ) { photoList, location, content, isReportSharingAgreed ->
        photoList.isNotEmpty() &&
                location.isNotEmpty() &&
                content.length in MIN_LENGTH_OF_CONTENT..MAX_LENGTH_OF_CONTENT &&
                isReportSharingAgreed
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    fun startCameraCooldown(durationInSeconds: Int) {
        if (!_isCameraButtonActive.value) return

        _cameraCooldownTime.value = durationInSeconds
        _isCameraButtonActive.value = false

        countdownJob?.cancel()
        countdownJob = viewModelScope.launch {
            while (_cameraCooldownTime.value > 0) {
                delay(1000)
                _cameraCooldownTime.value -= 1
            }
            _isCameraButtonActive.value = true
        }
    }

    fun updateIsCategorySelected() {
        _isCategorySelected.value = true
    }

    fun updateSelectedCategory(newCategory: String) {
        _selectedCategory.value = newCategory
        updateIsCategorySelected()
    }

    fun updateIsDropdownOpen() {
        _isDropdownOpen.value = !_isDropdownOpen.value
        if (_isDropdownOpen.value) {
            _selectedCategory.value = "불법 주정차 신고"
        }
    }

    fun updatePhotoList(newPhotoList: List<ReportPhotoItem>) {
        _photoList.value = newPhotoList
    }

    /*fun deletePhotoFromList(deletePhoto: ReportPhotoItem) {
        _photoList.value = _photoList.value.filter { it.photoId != deletePhoto.photoId }
    }*/
    fun deletePhotoFromList() {
        _photoList.value = _photoList.value.filter { it.photoId != deletePhoto.value?.photoId }
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
        val value = _content.value.length >= MIN_LENGTH_OF_CONTENT
        updateShowPhoneNumber(value)
    }

    fun updateIsRecommendWord() {
        _isRecommendWord.value = !_isRecommendWord.value
        if (_isRecommendWord.value) {
            _content.value = RECOMMEND_WORD_CONTEXT
        } else {
            _content.value = _content.value.replace(RECOMMEND_WORD_CONTEXT, "").toString()
        }
    }

    fun updateShowPhoneNumber(value: Boolean) {
        _showPhoneNumber.value = value
        _phoneNumber.value = if (_showPhoneNumber.value) {
            USER_PHONE_NUMBER
        } else {
            DEFAULT_PHONE_NUMBER_MESSAGE
        }
    }

    fun updateIsReportSharingAgreed() {
        _isReportSharingAgreed.value = !_isReportSharingAgreed.value
    }

    fun updateDeletePhoto(deletePhoto: ReportPhotoItem) {
       _deletePhoto.value = deletePhoto
    }

    fun updateDialogVisibility(type: ReportDialogType) {
        when (type) {
            ReportDialogType.ILLEGAL_PARKING -> {
                _dialogState.update {
                    it.copy(isIllegalParkingDialogVisible = !_dialogState.value.isIllegalParkingDialogVisible)
                }
            }

            ReportDialogType.CAMERA_SELECTION -> {
                _dialogState.update {
                    it.copy(isCameraSelectionDialogVisible = !_dialogState.value.isCameraSelectionDialogVisible)
                }
            }

            ReportDialogType.GALLERY_SELECTION -> {
                _dialogState.update {
                    it.copy(isGallerySelectionDialogVisible = !_dialogState.value.isGallerySelectionDialogVisible)
                }
            }

            ReportDialogType.PHOTO_DELETE -> {
                _dialogState.update {
                    it.copy(isPhotoDeleteDialogVisible = !_dialogState.value.isPhotoDeleteDialogVisible)
                }
            }

            ReportDialogType.PHOTO_SIZE_LIMIT -> {
                _dialogState.update {
                    it.copy(isPhotoSizeLimitDialogVisible = !_dialogState.value.isPhotoSizeLimitDialogVisible)
                }
            }

            ReportDialogType.PHOTO_TIME_LIMIT -> {
                _dialogState.update {
                    it.copy(isPhotoTimeLimitDialogVisible = !_dialogState.value.isPhotoTimeLimitDialogVisible)
                }
            }

            ReportDialogType.RESET -> {
                _dialogState.update {
                    it.copy(isResetConfirmationDialogVisible = !_dialogState.value.isResetConfirmationDialogVisible)
                }
            }

            ReportDialogType.SUBMIT_CONFIRM -> {
                _dialogState.update {
                    it.copy(isSubmitConfirmDialogVisible = !_dialogState.value.isSubmitConfirmDialogVisible)
                }
            }

            ReportDialogType.SUBMIT -> {
                _dialogState.update {
                    it.copy(isSubmitCompleteDialogVisible = !_dialogState.value.isSubmitCompleteDialogVisible)
                }
            }
        }
    }

    companion object {
        const val RECOMMEND_WORD_CONTEXT = "소방차 전용구역 불법주차 신고입니다."
        const val USER_PHONE_NUMBER = "010-1234-5678"
        const val DEFAULT_PHONE_NUMBER_MESSAGE = "전화번호를 입력해주세요"
        const val MIN_LENGTH_OF_CONTENT = 5
        const val MAX_LENGTH_OF_CONTENT = 200
    }
}