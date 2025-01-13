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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.vp_alp.route.AppRouting
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.viewmodel.STTViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: STTViewModel

    private val speechResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                viewModel.handleActivityResult(102, result.resultCode, result.data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(STTViewModel::class.java)
        viewModel.setSpeechResultLauncher(speechResultLauncher)
        setContent {
            VP_ALPTheme {
                AppRouting(activity = this, viewModel = viewModel)
            }
        }
    }
}
