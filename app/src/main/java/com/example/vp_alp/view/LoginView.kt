package com.example.vp_alp.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.uiStates.AuthenticationStatusUIState
import com.example.vp_alp.viewmodel.AuthenticationViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView (
    authenticationViewModel: AuthenticationViewModel,
    navController: NavHostController,
    context: Context
) {
    var username by remember { mutableStateOf("") }

    LaunchedEffect(authenticationViewModel.dataStatus) {
        val dataStatus = authenticationViewModel.dataStatus
        if (dataStatus is AuthenticationStatusUIState.Failed) {
            Toast.makeText(context, dataStatus.errorMessage, Toast.LENGTH_SHORT).show()
            authenticationViewModel.clearErrorMessage()
        }
    }

    Column (

    ) {
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
                contentDescription = "gambar_1",
                modifier = Modifier
                    .size(545.dp)
                    .offset(x = 70.dp, y = 132.dp),
            )
            Row (

            ) {
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
                        .width(375.dp)
                        .height(485.dp)
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
                            value = authenticationViewModel.emailInput,
                            onValueChange = {
                                authenticationViewModel.changeEmailInput(it)
                                authenticationViewModel.checkLoginForm()
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5C469C),
                                unfocusedBorderColor = Color(0xFF5C469C)
                            ),
                            textStyle = TextStyle(fontSize = 14.sp),
                            modifier = Modifier
                                .width(265.dp)
                                .height(55.dp)
                                .padding(top = 5.dp, bottom = 5.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )
                        Text(
                            "Password",
                            fontSize = 18.sp,
                        )
                        OutlinedTextField(
                            value = authenticationViewModel.passwordInput,
                            onValueChange = {
                                authenticationViewModel.changePasswordInput(it)
                                authenticationViewModel.checkLoginForm()
                                username = it
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5C469C),
                                unfocusedBorderColor = Color(0xFF5C469C)
                            ),
                            textStyle = TextStyle(fontSize = 14.sp),
                            modifier = Modifier
                                .width(265.dp)
                                .height(55.dp)
                                .padding(top = 5.dp, bottom = 5.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )
                        Button (
                            onClick = {
                                authenticationViewModel.loginUser(navController)
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
                                authenticationViewModel.loginUser(navController)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF5C469C)
                            ),
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
                                    .offset(x = (-15.dp))
                            ) {
                                Text(
                                    "Don’t have an account?",
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                )
                                Button (
                                    onClick = {
                                        navController.navigate(route = listScreen.Register.name)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color(0xFF45A6FF),
                                        containerColor = Color.Transparent
                                    ),
                                    modifier = Modifier
                                        .height(35.dp)
                                        .offset(x = (-20).dp, y = 5.dp)
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
    LoginView(
        authenticationViewModel = viewModel(),
        navController = rememberNavController(),
        context = LocalContext.current
    )
}