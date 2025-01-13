package com.example.vp_alp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.zIndex
import com.example.vp_alp.R


@Composable
fun ProfileView() {
    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background5),
                contentDescription = "background5",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(745.dp)
                    .offset(y = (-2).dp)
            )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.group_410),
                        contentDescription = "group_410",
                        modifier = Modifier
                            .size(105.dp)
                            .offset(y = (107.dp))
                    )
                }
                Surface (
                    shadowElevation = 5.dp,
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .padding(start = 19.dp, top = 150.dp, bottom = 25.dp)
                ) {
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .background(Color(0xFFF4F4F4))
                            .width(355.dp)
                            .height(550.dp)
                    ) {
                        Box (
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .offset(y = 62.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Leon Smith",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                Row (
                                    modifier = Modifier
                                        .padding(start = 35.dp)
                                        .offset(y = (-2.dp))
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.frame_370),
                                        contentDescription = "frame_370",
                                        modifier = Modifier
                                            .size(65.dp)
                                            .offset(y = (-20.dp))
                                    )
                                    Text(
                                        "Beginner",
                                        fontSize = 8.sp,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .offset(x = (-48.dp))
                                    )
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.line_1),
                                    contentDescription = "line_1",
                                    modifier = Modifier
                                        .size(355.dp)
                                        .offset(y = (-215.dp))
                                )
                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .offset(y = 20.dp)
                                ) {
                                    Row (
                                        modifier = Modifier
                                            .padding(bottom = 10.dp)
                                    ) {
                                        Row (
                                            modifier = Modifier
                                                .offset(x = (10.dp), y = (-380.dp))
                                                .width(300.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.account),
                                                contentDescription = "account",
                                                modifier = Modifier
                                                    .size(30.dp)
                                            )
                                            Text(
                                                "Account",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color(0xFF666666),
                                                modifier = Modifier
                                                    .padding(top = 5.dp, start = 15.dp)
                                            )
                                        }
                                        Image(
                                            painter = painterResource(id = R.drawable.arrow_right),
                                            contentDescription = "arrow_right",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .offset(y = (-380.dp))
                                        )
                                    }
                                    Row (
                                        modifier = Modifier
                                            .padding(bottom = 10.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .offset(x = (10.dp), y = (-370.dp))
                                                .width(300.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.flashcard),
                                                contentDescription = "flashcard",
                                                modifier = Modifier
                                                    .size(30.dp)
                                            )
                                            Text(
                                                "Flashcard",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color(0xFF666666),
                                                modifier = Modifier
                                                    .padding(top = 4.dp, start = 15.dp)
                                            )
                                        }
                                        Image(
                                            painter = painterResource(id = R.drawable.arrow_right),
                                            contentDescription = "arrow_right",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .offset(y = (-370.dp))
                                        )
                                    }
                                    Row (

                                    ) {
                                        Row (
                                            modifier = Modifier
                                                .offset(x = (10.dp), y = (-360.dp))
                                                .width(300.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.logout),
                                                contentDescription = "logout",
                                                modifier = Modifier
                                                    .size(30.dp)
                                            )
                                            Text(
                                                "Log Out",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color(0xFF666666),
                                                modifier = Modifier
                                                    .padding(top = 3.dp, start = 15.dp)
                                            )
                                        }
                                        Image(
                                            painter = painterResource(id = R.drawable.arrow_right),
                                            contentDescription = "arrow_right",
                                            modifier = Modifier
                                                .size(25.dp)
                                                .offset(y = (-360.dp))
                                        )
                                    }

                                }

                            }
                        }
                    }
                }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    ProfileView()
}