package com.example.vp_alp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.vp_alp.Repository.UserRepository
import com.example.vp_alp.SilenceApplication
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.model.Error
import com.example.vp_alp.model.GeneralResponseModel
import com.example.vp_alp.uiStates.ProfileDataStatusUIState
import com.example.vp_alp.uiStates.UserDataStatusUIState
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class UserViewModel (
    private val userRepository: UserRepository
): ViewModel() {
    var dataStatus: ProfileDataStatusUIState by mutableStateOf(ProfileDataStatusUIState.Start)
        private set
    var logoutStatus: UserDataStatusUIState by mutableStateOf(UserDataStatusUIState.Start)
        private set
    var deleteStatus: UserDataStatusUIState by mutableStateOf(UserDataStatusUIState.Start)
        private set
    var updateStatus: UserDataStatusUIState by mutableStateOf(UserDataStatusUIState.Start)
        private set
    var passwordInput by mutableStateOf("")
        private set


//    private val _userDataStatusUIState = MutableStateFlow(UserDataStatusUIState())
//
//    val userDataStatusUIState: StateFlow<UserDataStatusUIState>
//        get() {
//            return _userDataStatusUIState.asStateFlow()
//        }

    val username: StateFlow<String> = userRepository.currentUsername.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )

    val email: StateFlow<String> = userRepository.currentUsername.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )

    val token: StateFlow<String> = userRepository.currentUserToken.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )



    fun logoutUser(token: String, navController: NavHostController) {
        viewModelScope.launch {
            logoutStatus = UserDataStatusUIState.Loading

            Log.d("token-logout", "LOGOUT TOKEN: ${token}")

            try {
                val call = userRepository.logout(token)

                call.enqueue(object: Callback<GeneralResponseModel> {
                    override fun onResponse(call: Call<GeneralResponseModel>, res: Response<GeneralResponseModel>) {
                        if (res.isSuccessful) {
                            logoutStatus = UserDataStatusUIState.Success(data = res.body()!!.data)

                            saveUsernameToken("Unknown", "Unknown")

                            navController.navigate(listScreen.Login.name) {
                                popUpTo(listScreen.Profile.name) {
                                    inclusive = true
                                }
                            }
                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                Error::class.java
                            )

                            logoutStatus = UserDataStatusUIState.Failed(errorMessage.errors)
                            // set error message toast
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        logoutStatus = UserDataStatusUIState.Failed(t.localizedMessage)
                        Log.d("logout-failure", t.localizedMessage)
                    }
                })
            } catch (error: IOException) {
                logoutStatus = UserDataStatusUIState.Failed(error.localizedMessage)
                Log.d("logout-error", error.localizedMessage)
            }
        }
    }

    fun deleteUser(token: String, navController: NavHostController) {
        viewModelScope.launch {
            deleteStatus = UserDataStatusUIState.Loading

            try {
                val call = userRepository.deleteUser(token)

                call.enqueue(object: Callback<GeneralResponseModel> {
                    override fun onResponse(
                        call: Call<GeneralResponseModel>,
                        res: Response<GeneralResponseModel>
                    ) {
                        if (res.isSuccessful) {
                            deleteStatus = UserDataStatusUIState.Success(res.body()!!.data)

                            Log.d("delete-status", "Delete status: ${res.body()!!.data}")

                            navController.navigate(listScreen.Login.name) {
                                popUpTo(listScreen.Profile.name) {
                                    inclusive = true
                                }
                            }
                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                Error::class.java
                            )

                            deleteStatus = UserDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        deleteStatus = UserDataStatusUIState.Failed(t.localizedMessage)
                    }

                })
            } catch (error: IOException) {
                deleteStatus = UserDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    fun changePasswordInput(password: String) {
        passwordInput = password
    }

    fun updateUser(token: String, navController: NavHostController) {
        viewModelScope.launch {
            updateStatus = UserDataStatusUIState.Loading

            try {
                val call = userRepository.updateUser(token, passwordInput)

                call.enqueue(object: Callback<GeneralResponseModel> {
                    override fun onResponse(
                        call: Call<GeneralResponseModel>,
                        res: Response<GeneralResponseModel>
                    ) {
                        if (res.isSuccessful) {
                            updateStatus = UserDataStatusUIState.Success(res.body()!!.data)

                            navController.navigate(listScreen.Profile.name) {
                                popUpTo(listScreen.Profile.name) {
                                    inclusive = false
                                }
                            }

                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                Error::class.java
                            )

                            updateStatus = UserDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GeneralResponseModel>, t: Throwable) {
                        updateStatus = UserDataStatusUIState.Failed(t.localizedMessage)
                    }

                })
            } catch (error: IOException) {
                updateStatus = UserDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SilenceApplication)
                val userRepository = application.container.userRepository
//                val todoRepository = application.container.todoRepository
                UserViewModel(userRepository)
            }
        }
    }

    fun saveUsernameToken(token: String, username: String) {
        viewModelScope.launch {
            userRepository.saveUserToken(token)
            userRepository.saveUsername(username)
        }
    }

    fun clearLogoutErrorMessage() {
        logoutStatus = UserDataStatusUIState.Start
    }

    fun clearErrorMessage() {
        deleteStatus = UserDataStatusUIState.Start
    }

    fun clearErrorMessage1() {
        updateStatus = UserDataStatusUIState.Start
    }
}