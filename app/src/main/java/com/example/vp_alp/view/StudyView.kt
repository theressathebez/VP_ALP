import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R
import com.example.vp_alp.ui.theme.VP_ALPTheme

@Composable
fun StudyView(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.group_410),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(75.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Good Afternoon!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text("Leon Smith", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFFFA726), // Orange color
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Beginner",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Dropdown Icon",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFDCEEFF),
                    shape = RoundedCornerShape(15.dp),
                )
                .border(
                    border = BorderStroke(1.dp, Color(0xFFBDCBFF)),
                    shape = RoundedCornerShape(15.dp)
                )

                .padding(18.dp)
        ) {
            // Text Section
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 90.dp)
            ) {
                Text(
                    text = "Today's lesson",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text(
                    text = "\"Every journey starts with hello!\"",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Start Button
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Start",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2196F3) // Blue
                        )
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Start Icon",
                            tint = Color(0xFF2196F3),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Lesson Image
            Image(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Lesson Image",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = 18.dp) // Push the image slightly down to "stick" to the box
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF7ECFF),
                    shape = RoundedCornerShape(15.dp)
                )
                .border(
                    border = BorderStroke(1.dp, Color(0xFFA35FED)),
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Pelajaran terakhir:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text(
                    text = "Menyapa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .background(
                            color = Color(0xFFDCEEFF),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()
                            .background(
                                color = Color(0xFFA35FEC), // Blue Progress
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .background(
                        color = Color(0xFFA35FEC),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Lanjutkan",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier

                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieCardPreview() {
    VP_ALPTheme {
        StudyView()
    }
}