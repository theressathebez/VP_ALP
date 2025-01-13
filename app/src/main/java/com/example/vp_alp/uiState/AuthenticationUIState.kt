package com.example.vp_alp.uiStates

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.vp_alp.R

data class AuthenticationUIState(
    val showPassword: Boolean = false,
//    val showConfirmPassword: Boolean = false,
//    val passwordVisibility: VisualTransformation = PasswordVisualTransformation(),
//    val confirmPasswordVisibility: VisualTransformation = PasswordVisualTransformation(),
//    val passwordVisibilityIcon: Int = R.drawable.ic_password_visible,
//    val confirmPasswordVisibilityIcon: Int = R.drawable.ic_password_visible,
    val buttonEnabled: Boolean = false
)
