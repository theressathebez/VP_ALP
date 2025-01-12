package com.example.vp_alp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vp_alp.route.AppRouting
import com.example.vp_alp.ui.theme.VP_ALPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VP_ALPTheme {
                AppRouting()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    VP_ALPTheme {
        AppRouting()
    }
}



