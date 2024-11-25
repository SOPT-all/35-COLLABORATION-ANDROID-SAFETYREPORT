package com.sopt.shinmungo.presentation.map

data class AddressInputState(
    val address: String = "서울특별시 마포구 땡땡로12로 3",
    val isKeywordSearchEnabled: Boolean = false,
    val isAddressSearchEnabled: Boolean = false
)