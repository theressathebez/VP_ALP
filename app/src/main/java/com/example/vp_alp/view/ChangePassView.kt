package com.example.vp_alp.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.uiStates.UserDataStatusUIState
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.viewmodel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassView(
    userViewModel: UserViewModel,
    navController: NavHostController,
    token: String,
    context: Context
) {
//    val userDataStatusUIState = userViewModel.userDa
    val updateStatus = userViewModel.updateStatus

    LaunchedEffect(userViewModel.updateStatus) {
        val dataStatus = userViewModel.updateStatus
        if (dataStatus is UserDataStatusUIState.Failed) {
            Toast.makeText(context, dataStatus.errorMessage, Toast.LENGTH_SHORT).show()
            userViewModel.clearErrorMessage1()
        }
    }

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
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "password",
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Text(
                            "Change Password",
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
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 145.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "New Password: ",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .offset(x = (-85.dp))
                        )
                        OutlinedTextField(
                            value = userViewModel.passwordInput,
                            onValueChange = {
                                userViewModel.changePasswordInput(it)
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5C469C),
                                unfocusedBorderColor = Color(0xFF5C469C)
                            ),
                            modifier = Modifier
                                .width(305.dp)
                                .height(55.dp)
                                .padding(top = 5.dp, bottom = 5.dp)
                        )
                        Text(
                            "Change New Password: ",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .offset(y = 20.dp, x = (-32.dp))
                        )
//                        OutlinedTextField(
//                            value = username,
//                            onValueChange = { username = it },
//                            shape = RoundedCornerShape(12.dp),
//                            colors = TextFieldDefaults.outlinedTextFieldColors(
//                                focusedBorderColor = Color(0xFF5C469C),
//                                unfocusedBorderColor = Color(0xFF5C469C)
//                            ),
//                            modifier = Modifier
//                                .width(305.dp)
//                                .height(55.dp)
//                                .padding(top = 5.dp, bottom = 5.dp)
//                                .offset(y = 20.dp)
//                        )
                        Button (
                            onClick = {
//                                userViewModel.updateUser(token, navController)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF5C469C)
                            ),
                            modifier = Modifier
                                .width(305.dp)
                                .height(55.dp)
                                .padding(top = 5.dp, bottom = 5.dp)
                                .offset(y = 20.dp)
                        )
                        Button (
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF5C469C)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp)
                                .offset(y = 45.dp)
                                .padding(horizontal = 35.dp)
                        ) {
                            Text(
                                "Change",
                                color = Color(0xFFF6F8FF)
                            )
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
fun ChangePassPreview() {
    ChangePassView(
        userViewModel = viewModel(factory = UserViewModel.Factory),
        navController = rememberNavController(),
        token = "",
        context = LocalContext.current
    )
}
