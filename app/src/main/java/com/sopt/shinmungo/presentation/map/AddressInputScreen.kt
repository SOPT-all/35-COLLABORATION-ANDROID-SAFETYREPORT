package com.sopt.shinmungo.presentation.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.presentation.map.component.AddressCard
import kotlinx.coroutines.flow.update

/**
 * 주소 입력 화면을 표시하는 Composable
 *
 * @param modifier 화면에 적용될 modifier
 * @param onBackClick 뒤로가기 버튼 클릭 시 실행될 콜백
 * @param onConfirmClick 주소 선택 확인 시 실행될 콜백. 선택된 주소 문자열을 파라미터로 전달
 * @param viewModel 화면에서 사용할 ViewModel
 */
@Composable
fun AddressInputScreen(
    modifier : Modifier = Modifier,
    onBackClick: () -> Unit,
    onConfirmClick: (String) -> Unit,
    viewModel: AddressInputViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val selectedLocation = stringResource(R.string.address_example_text)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ShinMunGoTheme.color.gray1),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CommonTopBar(
            title = stringResource(R.string.address_topbar_text),
            onLeftContent = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = stringResource(R.string.back_screen_text),
                        tint = Color.White
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_map_placeholder),
                contentDescription = stringResource(R.string.address_map_img_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
            )

            AddressCard(
                address = stringResource(R.string.address_example_text)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ){
                    RoundedCornerTextButton(
                        text = stringResource(R.string.address_keyword_search_text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        onButtonClick = viewModel::onKeywordSearchClick,
                        textStyle = ShinMunGoTheme.typography.body4,
                        textColor = if (uiState.isKeywordSearchEnabled)
                            ShinMunGoTheme.color.primary
                        else
                            ShinMunGoTheme.color.gray8,
                        borderLineColor = if (uiState.isKeywordSearchEnabled)
                            ShinMunGoTheme.color.primaryLight
                        else
                            ShinMunGoTheme.color.gray5,
                        backgroundColor = ShinMunGoTheme.color.gray1,
                        roundedCornerShape = RoundedCornerShape(10.dp)
                    )
                }

                Box(
                    modifier = Modifier.weight(1f)
                ){
                    RoundedCornerTextButton(
                        text = stringResource(R.string.address_search_text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        onButtonClick = viewModel::onAddressSearchClick,
                        textStyle = ShinMunGoTheme.typography.body4,
                        textColor = if (uiState.isAddressSearchEnabled)
                            ShinMunGoTheme.color.primary
                        else
                            ShinMunGoTheme.color.gray8,
                        borderLineColor = if (uiState.isAddressSearchEnabled)
                            ShinMunGoTheme.color.primaryLight
                        else
                            ShinMunGoTheme.color.gray5,
                        backgroundColor = ShinMunGoTheme.color.gray1,
                        roundedCornerShape = RoundedCornerShape(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                RoundedCornerTextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = stringResource(R.string.address_location_selection_text),
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.gray1,
                    borderLineColor = null,
                    backgroundColor = ShinMunGoTheme.color.primary,
                    roundedCornerShape = RoundedCornerShape(10.dp),
                    onButtonClick = {
                        onConfirmClick(selectedLocation)
                    }
                )
            }
        }
    }
}

// AddressInputScreen.kt의 Preview 부분
class PreviewAddressInputViewModel : AddressInputViewModel() {
    init {
        _uiState.update {
            AddressInputState(
                address = "서울특별시 마포구 땡땡로12로 3",
                isKeywordSearchEnabled = false,
                isAddressSearchEnabled = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddressInputScreenPreview() {
    ShinMunGoTheme {
        AddressInputScreen(
            onBackClick = {},
            onConfirmClick = {},
            viewModel = PreviewAddressInputViewModel()
        )
    }
}

