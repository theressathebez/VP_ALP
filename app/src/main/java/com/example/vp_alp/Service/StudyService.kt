package com.example.todolistapp.services

import com.example.vp_alp.model.GetAllCategoriesResponse
import com.example.vp_alp.model.GetAllTopicResponse
import com.example.vp_alp.model.GetAllVideoResponse
import com.example.vp_alp.model.GetVideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface StudyService {
    @GET("api/categories")
    fun getCategories(): Call<GetAllCategoriesResponse>

    @GET("api/categories/{categoryId}/topics")
    fun getTopics(@Path("categoryId") categoryId: Int): Call<GetAllTopicResponse>

    @GET("api/getVideos/{topicId}")
    fun getVideos(@Path("topicId") topicId: Int): Call<GetAllVideoResponse>

    @GET("api/video/{videoId}")
    fun getVideo(@Path("videoId") videoId: Int): Call<GetVideoResponse>

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