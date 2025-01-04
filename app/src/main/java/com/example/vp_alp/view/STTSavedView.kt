package com.example.vp_alp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    viewModel: STTViewModel = viewModel()
) {
    // Collect the saved texts state
    val savedTexts by viewModel.text.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6F8FF)) // Light blue background
            .padding(16.dp)
    ) {
        // Header Section with enhanced styling
        Text(
            text = "Saved Texts",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5C469C),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Check if there are saved texts
        if (savedTexts.isNotEmpty()) {
            STTSavedList(savedTexts = listOf(savedTexts))
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
        STTSavedView()
    }
}