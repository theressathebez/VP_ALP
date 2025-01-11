package com.example.vp_alp.Service

import com.example.vp_alp.model.GeneralResponseModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UserAPIService {
    @POST("api/logout")
    fun logout(@Header("X-API-TOKEN") token: String): Call<GeneralResponseModel>

    @DELETE("api/delete/user")
    fun deleteUser(@Header("X-API-TOKEN") token: String, @Path("id") userId: Int): Call<GeneralResponseModel>
}