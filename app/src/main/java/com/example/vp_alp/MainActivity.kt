package com.example.vp_alp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.view.STTView
import com.example.vp_alp.viewModel.STTViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: STTViewModel

    private val speechResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.handleActivityResult(result.data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(STTViewModel::class.java)
        viewModel.setSpeechResultLauncher(speechResultLauncher)
        setContent {
            VP_ALPTheme {
                STTView(viewModel = viewModel)
            }
        }
    }
}