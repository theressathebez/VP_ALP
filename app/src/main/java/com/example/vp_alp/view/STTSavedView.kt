package com.example.vp_alp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.viewModel.STTViewModel

@Composable
fun STTSavedView(
    viewModel: STTViewModel = viewModel(),
    onBack: () -> Unit
) {
    // Collect the saved texts state
    val savedTexts by viewModel.text.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F8FF)) // Light blue background
            .padding(16.dp)
    ) {
        // Header Section with Back Button and enhanced styling
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Saved Texts",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5C469C),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        if (viewModel.hasSavedTexts()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                items(listOf(savedTexts)) { text ->
                    Card(
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFF9AAEF8))
                    ) {
                        Box(
                            modifier = Modifier
                                .background(color = Color(0xFFF6F8FF))
                                .padding(16.dp)
                        ) {
                            Column {
                                Text(
                                    text = text,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit",
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else {
            // Empty state
            Text(
                text = "No texts saved yet. Start saving to see them here!",
                fontSize = 16.sp,
                color = Color(0xFF6C757D),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun STTSavedViewPreview() {
    VP_ALPTheme {
        STTSavedView(onBack = {})
    }
}