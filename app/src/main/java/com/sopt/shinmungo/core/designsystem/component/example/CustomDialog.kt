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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme

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
                    color = Color.White,
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
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = onIconClick,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "Close Dialog",
                            tint = Color.White
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
    CustomDialog(
        title = "알림",
        icon = Icons.Default.Close,
        onDismissRequest = { /* 닫기 동작 */ },
        onIconClick = { /* 아이콘 클릭 동작 */ }
    ) {
        Text(
            text = buildAnnotatedString {
                append("사진은 ")
                withStyle(style = SpanStyle(color = Color(0xFFFF6F00), fontWeight = FontWeight.Bold)) {
                    append("각 30MB")
                }
                append(", ")
                withStyle(style = SpanStyle(color = Color(0xFFFF6F00), fontWeight = FontWeight.Bold)) {
                    append("총 180MB")
                }
                append("까지만 첨부 가능합니다.")
            },
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 22.sp
            ),
            color = Color.Black,
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
                    containerColor = Color.White,
                    contentColor = Color.Gray
                ),
                border = BorderStroke(1.dp, Color.Gray)
            ) {
                Text(
                    text = "취소",
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Button(
                onClick = { /* 확인 버튼 동작 */ },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6F00),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "확인",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}