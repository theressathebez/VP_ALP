package com.example.todolistapp.services

import com.example.vp_alp.model.GetAllCategoriesResponse
import com.example.vp_alp.model.GetAllTopicResponse
import com.example.vp_alp.model.GetAllVideoResponse
import com.example.vp_alp.model.GetVideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

//akses API lgsg dari backend

interface StudyService {
    //ambil kategori
    @GET("api/categories")
    suspend fun getCategories(): Response<GetAllCategoriesResponse>

    //ambil topic berdasarkan kategorinya
    @GET("api/categories/{categoryId}/topics")
    suspend fun getTopics(@Path("categoryId") categoryId: Int): Response<GetAllTopicResponse>

    //ambil video berdasarkan topicnya
    @GET("api/getVideos/{topicId}")
    suspend fun getVideos(@Path("topicId") topicId: Int): Response<GetAllVideoResponse>

    //ambil video berdasarkan video yang dipilih
    @GET("api/video/{videoId}")
    suspend fun getVideo(@Path("videoId") videoId: Int): Response<GetVideoResponse>

//
//    @GET("api/users/{id}/videos")
//    fun getFlashcard(@Header("X-API-TOKEN") token: String, @Path("id") todoId: Int): Call<GetTodoResponse>
//
//    @POST("api/users/{id}/videos/{id}")
//    fun saveFlashcard(@Header("X-API-TOKEN") token: String, @Body todoModel: TodoRequest): Call<GeneralResponseModel>
//
//    @DELETE("api/users/{id}/videos/{id}")
//    fun deleteFlashcard(@Header("X-API-TOKEN") token: String, @Path("id") todoId: Int): Call<GeneralResponseModel>
}