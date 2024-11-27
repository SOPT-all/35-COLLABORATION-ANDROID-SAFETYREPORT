package com.sopt.shinmungo.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.allcategory.AllCategoryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShinMunGoTheme {
                // AllCategoryScreen을 바로 실행
                AllCategoryScreen(
                    onNavigateBack = { finish() } // 뒤로가기 버튼을 누르면 액티비티 종료
                )
            }
        }
    }
}