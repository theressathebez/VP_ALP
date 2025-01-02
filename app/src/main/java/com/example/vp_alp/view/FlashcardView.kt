package com.example.vp_alp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R
import com.example.vp_alp.ui.theme.VP_ALPTheme

@Composable
fun FlashcardView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly // Membuat elemen memiliki jarak proporsional
    ) {
        Text(
            text = "FLASHCARD",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Arrow Right",
                tint = Color.Gray,
                modifier = Modifier
                    .size(40.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(350.dp)
                    .background(
                        color = Color(0xFFF7ECFF), shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFA35FED)),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.group_369),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(220.dp)
                            .padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Senang bertemu denganmu",
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.Gray,
                modifier = Modifier
                    .size(40.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFA35FEC), shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 4.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Kembali ke Home",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FlashcardViewPreview() {
    VP_ALPTheme {
        FlashcardView()
    }
}