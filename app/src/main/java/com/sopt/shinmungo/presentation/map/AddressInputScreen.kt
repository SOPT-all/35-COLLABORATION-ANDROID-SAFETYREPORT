package com.sopt.shinmungo.presentation.map

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.designsystem.component.button.RoundedCornerTextButton
import com.sopt.shinmungo.core.designsystem.component.topbar.CommonTopBar
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun AddressInputScreen(
    modifier : Modifier = Modifier,
    onBackClick: () -> Unit,
    onConfirmClick: (String) -> Unit,
    viewModel: AddressInputViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ShinMunGoTheme.color.gray1),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CommonTopBar(
            title = "주소 입력",
            onLeftContent = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_white_24),
                        contentDescription = "뒤로 가기",
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
                contentDescription = "지도 사진",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
            )

            AddressCard(
                address = "서울특별시 마포구 땡땡로12로 3"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ){
                    RoundedCornerTextButton(
                        text = "키워드 검색",
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
                        text = "주소 검색",
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
                    text = "위치 선택",
                    textStyle = ShinMunGoTheme.typography.body4,
                    textColor = ShinMunGoTheme.color.gray1,
                    borderLineColor = null,
                    backgroundColor = ShinMunGoTheme.color.primary,
                    roundedCornerShape = RoundedCornerShape(10.dp),
                    onButtonClick = {
                        val selectedLocation = "서울특별시 마포구 땡땡로12로 3"
                        onConfirmClick(selectedLocation)
                    }
                )
            }
        }
    }
}

@Composable
fun AddressCard(
    modifier: Modifier = Modifier,
    address: String,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = ShinMunGoTheme.color.gray5
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_line_black_16px),
                contentDescription = "위치",
                tint = ShinMunGoTheme.color.primary,
                modifier = Modifier.size(16.dp)
            )

            Text(
                text = address,
                style = ShinMunGoTheme.typography.body8,
                color = ShinMunGoTheme.color.primary
            )
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

