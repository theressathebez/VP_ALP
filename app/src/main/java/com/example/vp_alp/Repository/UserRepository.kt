package com.example.vp_alp.Repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.vp_alp.Service.UserAPIService
import com.example.vp_alp.model.GeneralResponseModel
import com.example.vp_alp.model.UserModel
//import com.example.vp_alp.model.UserRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Call


interface UserRepository {
    val currentUserToken: Flow<String>
    val currentUsername: Flow<String>
    val currentEmail: Flow<String>

    fun logout(token: String): Call<GeneralResponseModel>
    //    fun updateUser(token: String, password: String): Call<GeneralResponseModel>
    fun deleteUser(token: String): Call<GeneralResponseModel>

    suspend fun saveUserToken(token: String)
    suspend fun saveUsername(username: String)
    suspend fun saveEmail(email: String)
}

class NetworkUserRepository(
    private val userDataStore: DataStore<Preferences>,
    private val userAPIService: UserAPIService
): UserRepository {
    private companion object {
        val USER_TOKEN = stringPreferencesKey("token")
        val USERNAME = stringPreferencesKey("username")
        val EMAIL = stringPreferencesKey("email")

    }

    override val currentUserToken: Flow<String> = userDataStore.data.map{ preferences ->
        preferences[USER_TOKEN] ?: "Unkown"
    }

    override val currentUsername: Flow<String> = userDataStore.data.map{ preferences ->
        preferences[USERNAME] ?: "Unkown"
    }

    override val currentEmail: Flow<String> = userDataStore.data.map{ preferences ->
        preferences[EMAIL] ?: "Unkown"
    }

    override suspend fun saveUserToken(token: String) {
        userDataStore.edit { preferences ->
            preferences[USER_TOKEN] = token
        }
    }

    override suspend fun saveUsername(username: String){
        userDataStore.edit { preferences ->
            preferences[USERNAME] = username
        }
    }

    override suspend fun saveEmail(email: String){
        userDataStore.edit { preferences ->
            preferences[EMAIL] = email
        }
    }

//    override fun updateUser(token: String, password: String): Call<GeneralResponseModel> {
//        return userAPIService.updateUser(token, UserModel(password))
//    }

    override fun logout(token: String): Call<GeneralResponseModel> {
        return userAPIService.logout(token)
    }

    override fun deleteUser(token: String): Call<GeneralResponseModel> {
        return userAPIService.deleteUser(token)
    }

}