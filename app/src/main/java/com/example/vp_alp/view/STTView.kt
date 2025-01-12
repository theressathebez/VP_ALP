package com.example.vp_alp.view

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.vp_alp.R
import com.example.vp_alp.route.listScreen

import com.example.vp_alp.viewmodel.STTViewModel

@Composable
fun STTView(
    viewModel: STTViewModel
    = viewModel(),
    activity: Activity,
    navController: NavController
) {
    val text by viewModel.text.collectAsState()
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .width(380.dp)
                    .height(58.dp)
                    .background(color = Color(0xFFF6F8FF)) // Light blue background
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF9AAEF8)), // Dark blue border
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Penyimpanan",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .width(80.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(color = Color(0xFF5C469C))
                            .clickable {
                                navController.navigate(listScreen.SavedTexts.name)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "See All",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                        )
                    }

                }
            }
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .width(380.dp)
                    .height(400.dp)
                    .background(color = Color(0xFFF6F8FF)) // Light blue background
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF9AAEF8)), // Dark blue border
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(16.dp)
                            .width(30.dp)
                            .height(30.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                        .width(380.dp)
                        .height(250.dp)
                        .background(color = Color(0xFFFFFFFF)) // Light blue background
                        .border(
                            border = BorderStroke(1.dp, Color(0xFF9AAEF8)), // Dark blue border
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Text(
                        text = "$text",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_delete_outline_24),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(16.dp)
                            .width(30.dp)
                            .height(30.dp)
                            .clickable {
                                viewModel.clearText()
                            }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(80.dp) // Set size of the circle
                    .clip(shape = RoundedCornerShape(50)) // Make the Box circular
                    .background(color = Color(0xFFDDE4FB)) // Circle color
                    .clickable {
                        viewModel.askSpeechInput(context)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_mic_none_24),
                    contentDescription = "mic",
                    modifier = Modifier.size(50.dp)
                )
            }


        }
        BottomNavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 20.dp)
                .navigationBarsPadding(),
            currentScreen = "transcript",
            navController = navController
        )

    }
}