import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.shinmungo.R

@Composable
fun CustomDialog(
    title: String,
    message: String,
    buttons: List<Pair<String, () -> Unit>>,
    onIconClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(335.dp)
                .wrapContentHeight()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(12.dp),
        ) {
            Column(
                modifier = Modifier.background(Color.White)
            ) {
                // Title Section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(Color(0xFFFF6F00))
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
                            painter = painterResource(id = R.drawable.ic_close_24),
                            contentDescription = "Close Dialog",
                            tint = Color.White
                        )
                    }
                }

                // Message Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
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
                            append("까지만\n첨부 가능합니다")
                        },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 22.sp
                        ),
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Confirm Button Section
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                    ) {
                        buttons.forEach { (buttonText, onClick) ->
                            Button(
                                onClick = onClick,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(50.dp),
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Gray
                                ),
                                border = BorderStroke(1.dp, Color.Gray)
                            ) {
                                Text(
                                    text = buttonText,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomDialogSingleButton() {
    CustomDialog(
        title = "알림",
        message = "사진은 각 30MB, 총 180MB까지만 첨부 가능합니다",
        buttons = listOf(
            "확인" to { /* 확인 버튼 동작 */ }
        ),
        onIconClick = { /* X 버튼 동작 */ }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomDialogTwoButtons() {
    CustomDialog(
        title = "알림",
        message = "사진은 각 30MB, 총 180MB까지만 첨부 가능합니다",
        buttons = listOf(
            "취소" to { /* 취소 버튼 동작 */ },
            "확인" to { /* 확인 버튼 동작 */ }
        ),
        onIconClick = { /* X 버튼 동작 */ }
    )
}