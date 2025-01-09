package com.example.vp_alp.view

import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.uiStates.UserDataStatusUIState
import com.example.vp_alp.viewmodel.AuthenticationViewModel
import com.example.vp_alp.viewmodel.UserViewModel


@Composable
fun ProfileView(
    userViewModel: UserViewModel,
    token : String,
    navController: NavHostController,
    context: Context
) {
    val username = userViewModel.username.collectAsState()
    val logoutStatus = userViewModel.logoutStatus

//    LaunchedEffect (token) {
//        if (token != "Unknown") {
//
//        }
//    }

    LaunchedEffect(logoutStatus) {
        if (logoutStatus is UserDataStatusUIState.Failed) {
            Toast.makeText(context, "LOGOUT ERROR: ${logoutStatus.errorMessage}", Toast.LENGTH_SHORT).show()
            userViewModel.clearLogoutErrorMessage()
        }
    }

    Column (
        modifier = Modifier
    ) {
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
                            .offset(y = (107.dp), x = 2.dp)
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
                            .width(376.dp)
                            .height(610.dp)
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
//                                    "",
                                    text = username.value,
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
                                            .offset(y = (-20.dp), x = 2.dp)
                                    )
                                    Text(
                                        "Beginner",
                                        fontSize = 8.sp,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(top = 1.dp)
                                            .offset(x = (-48.dp))
                                    )
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.line_1),
                                    contentDescription = "line_1",
                                    modifier = Modifier
                                        .size(355.dp)
                                        .offset(y = (-215.dp))
                                        .clickable { }
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
                                                .clickable {
                                                    navController.navigate(listScreen.Account.name)
                                                }
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
                                                .clickable {
                                                    navController.navigate(listScreen.UserFlashcard.name)
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
                                                .clickable {
                                                    userViewModel.logoutUser(token, navController)
                                                }
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
    ProfileView(
        userViewModel = viewModel(factory = UserViewModel.Factory),
        navController = rememberNavController(),
        token = "",
        context = LocalContext.current
    )
}