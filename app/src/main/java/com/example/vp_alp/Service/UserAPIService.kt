package com.example.vp_alp.Service

import com.example.vp_alp.model.GeneralResponseModel
//import com.example.vp_alp.model.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserAPIService {
    @POST("api/logout")
    fun logout(@Header("X-API-TOKEN") token: String): Call<GeneralResponseModel>

    @DELETE("api/delete-user")
    fun deleteUser(@Header("X-API-TOKEN") token: String): Call<GeneralResponseModel>

//    @PUT("api/update-user")
//    fun updateUser(@Header("X-API-TOKEN") token: String, @Body User: UserRequest): Call<GeneralResponseModel>
}