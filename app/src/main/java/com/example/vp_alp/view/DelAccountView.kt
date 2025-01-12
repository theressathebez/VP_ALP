package com.example.vp_alp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R


@Composable
fun DelAccountView() {
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
                        .width(355.dp)
                        .height(550.dp)
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
                    Text(
                        "Are you sure you want to\n" +
                                " delete your account?\n" +
                                "\n" +
                                "All data will be deleted \n" +
                                "and can not be restored.",
                        color = Color(0xFF666666),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .offset(x = 25.dp, y = 150.dp)
                    )
                    Button (
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 280.dp, x = 25.dp)
                            .padding(end = 50.dp)
                    ) {
                        Text(
                            "Cancel"
                        )
                    }
                    Button (
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 330.dp, x = 25.dp)
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
    DelAccountView()
}