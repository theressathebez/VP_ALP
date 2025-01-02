package com.example.vp_alp.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Locale

class STTViewModel : ViewModel() {

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> get() = _text

    private var speechResultLauncher: ActivityResultLauncher<Intent>? = null

    fun setSpeechResultLauncher(launcher: ActivityResultLauncher<Intent>) {
        speechResultLauncher = launcher
    }

    fun askSpeechInput(context: Context) {
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            Toast.makeText(context, "Speech not Available", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.US)
                putExtra(RecognizerIntent.EXTRA_PROMPT, "Talk Something")
            }
            speechResultLauncher?.launch(intent)
        }
    }

    fun handleActivityResult(data: Intent?) {
        val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
        _text.value = result?.get(0).toString()
    }
}