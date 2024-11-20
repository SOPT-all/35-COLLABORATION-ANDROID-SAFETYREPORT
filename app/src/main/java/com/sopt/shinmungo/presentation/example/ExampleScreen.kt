package com.sopt.shinmungo.presentation.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.core.designsystem.component.example.ExampleText
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.state.UiState
import com.sopt.shinmungo.domain.entity.Example


/**TODO: 이해를 위한 예시 화면 컴포저블 구현 (삭제될 예정)*/
@Composable
fun ExampleScreen(
    modifier: Modifier = Modifier,
    viewModel: ExampleViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //화면이 시작될 때 서버 통신이 이뤄지는 경우
    LaunchedEffect(true) {
        viewModel.getExample()
    }

    when (uiState.loadState) {
        is UiState.Loading -> {
            //로딩 화면
        }

        is UiState.Empty -> {
            //빈 없음
        }

        is UiState.Error -> {
            //에러 화면
        }

        is UiState.Success -> {
            val state = uiState.loadState as UiState.Success<Example>
            ExampleText(
                text = state.data.id,
                style = ShinMunGoTheme.typography.body3,
                modifier = modifier
            )
        }
    }
}