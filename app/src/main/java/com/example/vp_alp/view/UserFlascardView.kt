package com.example.vp_alp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R


@Composable
fun UserFlashcardView(
    navController: NavController,
    token: String
) {
    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background5),
                contentDescription = "background5",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp)
                    .offset(y = (-5).dp),
                contentScale = ContentScale.Crop
            )

            Surface (
                shadowElevation = 5.dp,
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .padding(start = 19.dp, top = 150.dp, bottom = 25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color(0xFFF4F4F4))
                        .width(376.dp)
                        .height(610.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.flashcard),
                            contentDescription = "flashcard",
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Text(
                            "Flashcard",
                            fontSize = 20.sp,
                            color = Color(0xFF666666),
                            fontWeight = FontWeight.SemiBold,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.line_1),
                            contentDescription = "line_1",
                            modifier = Modifier
                                .size(355.dp)
                                .offset(y = (-160.dp))
                        )
                        Box (
                            modifier = Modifier
                                .offset(y = 20.dp)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp)
                                    .offset(y = (-318.dp)),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button (
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE3CAFF),
                                        contentColor = Color(0xFF263238)
                                    ),
                                    border = BorderStroke(1.dp, Color(0xFFD7B4FF)),
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(350.dp),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Text(
                                        "B b",
                                        modifier = Modifier
                                            .offset(y = 65.dp)
                                    )
                                }
                                Button (
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFFE18E),
                                        contentColor = Color(0xFF263238)
                                    ),
                                    border = BorderStroke(1.dp, Color(0xFFFFD664)),
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(350.dp),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Text(
                                        "Terima Kasih",
                                        modifier = Modifier
                                            .offset(y = 65.dp)
                                    )
                                }
                            }
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp)
                                    .offset(y = (-110.dp)),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button (
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFDCEEFF),
                                        contentColor = Color(0xFF263238)
                                    ),
                                    border = BorderStroke(1.dp, Color(0xFFB2DAFF)),
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(350.dp),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Text(
                                        "Halo",
                                        modifier = Modifier
                                            .offset(y = 65.dp)
                                    )
                                }
                                Button (
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFFC890),
                                        contentColor = Color(0xFF263238)
                                    ),
                                    border = BorderStroke(1.dp, Color(0xFFFFAD59)),
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(350.dp),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Text(
                                        "8",
                                        modifier = Modifier
                                            .offset(y = 65.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        BottomNavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 16.dp)
                .navigationBarsPadding(),
            currentScreen = "profile",
            navController = navController
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserFlashcardPreview() {
    UserFlashcardView(
        navController = rememberNavController(),
        token = ""
    )
}