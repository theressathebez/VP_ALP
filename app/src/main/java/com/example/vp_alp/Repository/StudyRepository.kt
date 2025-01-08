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

interface StudyRepository {
    fun getCategories(): Call<GetAllCategoriesResponse>

    fun getTopics(categoryId: Int): Call<GetAllTopicResponse>

    fun getVideos(topicId: Int): Call<GetAllVideoResponse>

    fun getVideo(videoId: Int): Call<GetVideoResponse>

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

    override fun getCategories(): Call<GetAllCategoriesResponse> {
        return studyService.getCategories()
    }

    override fun getTopics(categoryId: Int): Call<GetAllTopicResponse> {
        return studyService.getTopics(categoryId)
    }

    override fun getVideos(topicId: Int): Call<GetAllVideoResponse> {
        return studyService.getVideos(topicId)
    }

    override fun getVideo(videoId: Int): Call<GetVideoResponse> {
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


