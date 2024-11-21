import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

/**
 * 사용자가 특정 작업을 수행하거나 메시지를 확인하도록 요청하는 커스텀 다이얼로그입니다.
 *
 * @param title 다이얼로그 상단에 표시될 제목 텍스트입니다.
 * @param icon 제목 오른쪽에 표시될 아이콘의 [ImageVector]입니다. 주로 닫기 버튼으로 사용됩니다.
 * @param onDismissRequest 다이얼로그 외부를 클릭하거나 취소 요청 시 호출되는 콜백 함수입니다.
 * @param onIconClick 아이콘 클릭 시 호출되는 콜백 함수입니다. 기본값은 빈 함수입니다.
 * @param content 다이얼로그의 본문 내용으로 표시될 컴포저블을 제공합니다. [ColumnScope]로 감싸져 있습니다.
 */

@Composable
fun CustomDialog(
    title: String,
    icon: ImageVector,
    onDismissRequest: () -> Unit,
    onIconClick: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .width(335.dp)
                .wrapContentHeight()
                .padding(16.dp)
                .background(
                    color = ShinMunGoTheme.color.gray1,
                    shape = RoundedCornerShape(8.dp)
                )
        ){
                // Title Section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(ShinMunGoTheme.color.primary)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        color = ShinMunGoTheme.color.gray1,
                        style = ShinMunGoTheme.typography.heading1,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = onIconClick,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "Close Dialog",
                            tint = ShinMunGoTheme.color.gray1
                        )
                    }
                }

                // Custom Contetn Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    content = content
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewCustomDialog() {
    ShinMunGoTheme {
        CustomDialog(
            title = "알림",
            icon = Icons.Default.Close,
            onDismissRequest = { /* 닫기 동작 */ },
            onIconClick = { /* 아이콘 클릭 동작 */ }
        ) {
            Text(
                text = buildAnnotatedString {
                    append("사진은 ")
                    withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                        append("각 30MB")
                    }
                    append(", ")
                    withStyle(style = SpanStyle(color = ShinMunGoTheme.color.primary, fontWeight = FontWeight.Bold)) {
                        append("총 180MB")
                    }
                    append("까지만 첨부 가능합니다.")
                },
                style = ShinMunGoTheme.typography.body2,
                color = ShinMunGoTheme.color.gray13,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { /* 취소 버튼 동작 */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ShinMunGoTheme.color.gray1,
                        contentColor = ShinMunGoTheme.color.gray9
                    ),
                    border = BorderStroke(1.dp, ShinMunGoTheme.color.gray9)
                ) {
                    Text(
                        text = "취소",
                        style = ShinMunGoTheme.typography.body6
                    )
                }
                Button(
                    onClick = { /* 확인 버튼 동작 */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ShinMunGoTheme.color.primary,
                        contentColor = ShinMunGoTheme.color.gray1
                    )
                ) {
                    Text(
                        text = "확인",
                        style = ShinMunGoTheme.typography.body6
                    )
                }
            }
        }
    }
}