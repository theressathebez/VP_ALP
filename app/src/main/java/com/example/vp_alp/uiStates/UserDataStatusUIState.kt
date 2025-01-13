package com.example.vp_alp.uiStates

import com.example.vp_alp.model.UserModel

sealed interface UserDataStatusUIState {
    data class Success(val data: String): UserDataStatusUIState
    data class Failed(val errorMessage: String): UserDataStatusUIState
    object Loading: UserDataStatusUIState
    object Start: UserDataStatusUIState
}