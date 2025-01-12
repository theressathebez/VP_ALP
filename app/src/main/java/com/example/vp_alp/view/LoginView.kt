package com.example.vp_alp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.vp_alp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView() {
    var username by remember { mutableStateOf("") }

    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.background3),
                contentDescription = "background3",
                modifier = Modifier
                    .offset(y = (-55).dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.background4),
                contentDescription = "background4",
                modifier = Modifier
                    .offset(y = (-20).dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.gambar_1),
                contentDescription = "gambar_2",
                modifier = Modifier
                    .size(545.dp)
                    .offset(x = 60.dp, y = 132.dp),
            )
            Row {
                Text(
                    "Welcome!",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 25.dp, top = 330.dp)
                )
                Text(
                    "Ready to begin your learning journey?",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .offset(x = (-153).dp)
                        .padding(start = 2.dp, top = 370.dp)
                )
            }
            Surface (
                shadowElevation = 15.dp,
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .padding(start = 19.dp, top = 430.dp, bottom = 25.dp)
            ) {
                Box (
                    modifier = Modifier
                        .clip(RoundedCornerShape(25.dp))
                        .background(Color(0xFFF4F4F4))
                        .width(355.dp)
                        .height(395.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .offset(x = 45.dp, y = 30.dp)
                    ) {
                        Text(
                            "Email",
                            fontSize = 18.sp,
                        )
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5C469C),
                                unfocusedBorderColor = Color(0xFF5C469C)
                            ),
                            modifier = Modifier
                                .width(265.dp)
                                .height(45.dp)
                                .padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text(
                            "Password",
                            fontSize = 18.sp,
                        )
                        OutlinedTextField(
                            value = username,
                            onValueChange = { username = it },
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5C469C),
                                unfocusedBorderColor = Color(0xFF5C469C)
                            ),
                            modifier = Modifier
                                .width(265.dp)
                                .height(45.dp)
                                .padding(top = 5.dp, bottom = 5.dp)
                        )
                        Button (
                            onClick = {
                                println("mantap")
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color(0xFF45A6FF),
                                containerColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .height(35.dp)
                                .offset(x = (-20).dp, y = (-10).dp)
                        ) {
                            Text(
                                "Forgot password?"
                            )
                        }
                        Button (
                            onClick = {
                                println("saya")
                            },
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .width(250.dp)
                                .padding(start = 20.dp)
                        ) {
                            Text(
                                "Login",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier
                                    .padding(top = 5.dp, bottom = 5.dp)
                            )
                        }
                        Box (
                            modifier = Modifier
                                .padding(start = 35.dp, top = 15.dp)
                        ) {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(start = 25.dp)
                            ) {
                                Text(
                                    "Or with"
                                )
                                Row (
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(150.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.logo_apple),
                                        contentDescription = "logo_apple",
                                        modifier = Modifier
                                            .size(35.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.logo_facebook),
                                        contentDescription = "logo_facebook",
                                        modifier = Modifier
                                            .size(35.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.logo_google),
                                        contentDescription = "logo_google",
                                        modifier = Modifier
                                            .size(35.dp)
                                    )
                                }
                            }
                            Row (
                                modifier = Modifier
                                    .padding(top = 70.dp)
                            ) {
                                Text(
                                    "Don’t have an account?",
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                )
                                Button (
                                    onClick = {
                                        println("mantap")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color(0xFF45A6FF),
                                        containerColor = Color.Transparent
                                    ),
                                    modifier = Modifier
                                        .height(35.dp)
                                        .offset(x = (-20).dp)
                                ) {
                                    Text(
                                        "Sign Up"
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
fun LoginPreview() {
    LoginView()
}