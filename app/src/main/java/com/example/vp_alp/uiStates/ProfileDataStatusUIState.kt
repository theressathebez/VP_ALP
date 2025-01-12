package com.example.vp_alp.uiStates

import com.example.vp_alp.model.UserModel

sealed interface ProfileDataStatusUIState {
    data class Success(val data: UserModel): ProfileDataStatusUIState
    data class Failed(val errorMessage: String): ProfileDataStatusUIState
    object Loading: ProfileDataStatusUIState
    object Start: ProfileDataStatusUIState
}
