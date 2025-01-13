package com.example.vp_alp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.viewmodel.UserViewModel


@Composable
fun AccountView(
    userViewModel: UserViewModel,
    navController: NavHostController
) {
    val email = userViewModel.email.collectAsState()

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
                Box (
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
                            painter = painterResource(id = R.drawable.account),
                            contentDescription = "account",
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Text(
                            "Account",
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
                        Column (
                            modifier = Modifier
                                .fillMaxHeight()
                                .offset(y = 70.dp)
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
                                        painter = painterResource(id = R.drawable.email),
                                        contentDescription = "email",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                    Text(
                                        text = email.value,
                                        textDecoration = TextDecoration.Underline,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color(0xFF666666),
                                        modifier = Modifier
                                            .padding(top = 4.dp, start = 15.dp)
                                    )
                                }
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
                                        painter = painterResource(id = R.drawable.password),
                                        contentDescription = "password",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                    Text(
                                        "Change Password",
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
                                        .offset(y = (-370.dp))
                                        .clickable {
                                            navController.navigate(listScreen.ChangePass.name)
                                        }
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
                                        painter = painterResource(id = R.drawable.remove),
                                        contentDescription = "remove",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                    Text(
                                        "Delete Account",
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
                                        .clickable {
                                            navController.navigate(listScreen.DelAccount.name)
                                        }
                                )
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
fun AccountPreview() {
    AccountView(
        userViewModel = viewModel(factory = UserViewModel.Factory),
        navController = rememberNavController()
    )
}
