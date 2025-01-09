package com.example.vp_alp.view

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.viewmodel.UserViewModel


@Composable
fun DelAccountView(
    userViewModel: UserViewModel,
    navController: NavHostController,
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
                            painter = painterResource(id = R.drawable.remove),
                            contentDescription = "remove",
                            modifier = Modifier
                                .size(50.dp)
                        )
                        Text(
                            "Delete Account",
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
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = (-25.dp), y = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Are you sure you want to\n" +
                                    "delete your account?\n" +
                                    "\n" +
                                    "All data will be deleted \n" +
                                    "and can not be restored.",
                            color = Color(0xFF666666),
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .offset(x = 25.dp, y = 150.dp)
                        )
                    }
                    Button (
                        onClick = {
                            navController.navigate(listScreen.Account.name)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFA09F9F)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 325.dp, x = 25.dp)
                            .padding(end = 50.dp)
                    ) {
                        Text(
                            "Cancel"
                        )
                    }
                    Button (
                        onClick = {
                            userViewModel.delAccount(token, navController)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5C469C)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 375.dp, x = 25.dp)
                            .padding(end = 50.dp)
                    ) {
                        Text(
                            "Delete Account"
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DelAccountPreview() {
    DelAccountView(
        userViewModel = viewModel(factory = UserViewModel.Factory),
        navController = rememberNavController(),
        token = ""
    )
}