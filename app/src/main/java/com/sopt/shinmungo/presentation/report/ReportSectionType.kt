package com.sopt.shinmungo.presentation.report

enum class ReportSectionType(val type: String) {
    PHOTO("사진"),
    LOCATION("발생지역"),
    CONTENT("내용");

    companion object {
        fun String.toContentTypeOrThrow(): ReportSectionType {
            return entries.find { it.type == this }
                ?: throw IllegalArgumentException("Invalid ContentType: $this")
        }
    }
}