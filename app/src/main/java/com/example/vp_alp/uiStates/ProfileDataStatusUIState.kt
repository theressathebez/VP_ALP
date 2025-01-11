package com.example.vp_alp.uiStates

import com.example.vp_alp.model.UserModel

sealed interface ProfileDataStatusUIState {
    data class Success(val data: UserModel): UserDataStatusUIState
    data class Failed(val errorMessage: String): UserDataStatusUIState
    object Loading: UserDataStatusUIState
    object Start: UserDataStatusUIState
}
