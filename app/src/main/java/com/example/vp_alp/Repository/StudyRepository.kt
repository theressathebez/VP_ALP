package com.example.vp_alp.Repository

import com.example.todolistapp.services.StudyService
import com.example.vp_alp.model.Category
import com.example.vp_alp.model.FlashcardRequest
import com.example.vp_alp.model.GeneralResponseModel
import com.example.vp_alp.model.GetAllCategoriesResponse
import com.example.vp_alp.model.GetAllTopicResponse
import com.example.vp_alp.model.GetAllVideoResponse
import com.example.vp_alp.model.GetVideoResponse
import com.example.vp_alp.model.Topic
import com.example.vp_alp.model.Video
import retrofit2.Call
import retrofit2.Response

//mengolah data dari backend spy bisa dipake di frontend
interface StudyRepository {
    suspend fun getCategories(): Response<GetAllCategoriesResponse>

    suspend fun getTopics(categoryId: Int): Response<GetAllTopicResponse>

    suspend fun getVideos(topicId: Int): Response<GetAllVideoResponse>

    suspend fun getVideo(videoId: Int): Response<GetVideoResponse>

//    fun saveFlashcard(
//        token: String,
//        videoUrl: String,
//        flashcard: String
//    ): Call<GeneralResponseModel>
//
//    fun getFlashcard(token: String, userId: Int): Call<GetVideoResponse>
//
//    fun deleteFlashcard(token: String, userId: Int): Call<GeneralResponseModel>
}


class NetworkStudyRepository(
    private val studyService: StudyService
) : StudyRepository {

    override suspend fun getCategories(): Response<GetAllCategoriesResponse> {
        return studyService.getCategories()
    }

    override suspend fun getTopics(categoryId: Int): Response<GetAllTopicResponse> {
        return studyService.getTopics(categoryId)
    }

    override suspend fun getVideos(topicId: Int): Response<GetAllVideoResponse> {
        return studyService.getVideos(topicId)
    }

    override suspend fun getVideo(videoId: Int): Response<GetVideoResponse> {
        return studyService.getVideo(videoId)
    }

//    override fun getFlashcard(token: String, userId: Int): Call<GetVideoResponse> {
//        return studyService.getFlashcard(token, userId)
//    }
//
//    override fun saveFlashcard(
//        token: String,
//        videoUrl: String,
//        flashcard: String
//    ): Call<GeneralResponseModel> {
//        return studyService.saveFlashcard(
//            token,
//            FlashcardRequest(videoUrl, flashcard)
//        )
//    }
//
//    override fun deleteFlashcard(token: String, userId: Int): Call<GeneralResponseModel> {
//        return studyService.deleteFlashcard(token, userId)
//    }
}


