package com.example.vp_alp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vp_alp.Repository.StudyRepository
import com.example.vp_alp.SilenceApplication
import com.example.vp_alp.model.GetAllCategoriesResponse
import com.example.vp_alp.model.GetAllTopicResponse
import com.example.vp_alp.model.GetAllVideoResponse
import com.example.vp_alp.model.GetVideoResponse
import com.example.vp_alp.model.Video
import kotlinx.coroutines.launch


class StudyViewModel(
    private val studyRepository: StudyRepository
) : ViewModel() {

    var categoryId by mutableStateOf(0)
        private set

    private val _categories = mutableStateOf(GetAllCategoriesResponse(emptyList()))
    val categories: State<GetAllCategoriesResponse> = _categories

    private val _topics = mutableStateOf(GetAllTopicResponse(emptyList()))
    val topics: State<GetAllTopicResponse> = _topics

    private val _videos = mutableStateOf(GetAllVideoResponse(emptyList()))
    val videos: State<GetAllVideoResponse> = _videos

    private val _video = mutableStateOf(GetVideoResponse(Video()))
    val video: State<GetVideoResponse> = _video

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = studyRepository.getCategories()
                if (response.isSuccessful) {
                    _categories.value =
                        GetAllCategoriesResponse(response.body()?.data ?: emptyList())
                    Log.d("StudyViewModel", "Fetched categories: ${_categories.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching categories: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching categories: ${e.message}")
            }
        }
    }


    fun fetchTopics(categoryId: Int) {
        viewModelScope.launch {
            try {
                val response = studyRepository.getTopics(categoryId)
                Log.d("API Response", "Response Body: ${response.body()}")

                if (response.isSuccessful) {
                    _topics.value = GetAllTopicResponse(
                        response.body()?.data ?: emptyList()
                    )
                    Log.d("Category ID", "Fetching topics for categoryId: $categoryId")

                    Log.d("StudyViewModel", "Fetched topics: ${_topics.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching topics: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching topics: ${e.message}")
            }
        }
    }

    fun fetchVideos(topicId: Int) {
        viewModelScope.launch {
            try {
                val response = studyRepository.getVideos(topicId)
                Log.d("API Response", "Response Body: ${response.body()}")

                if (response.isSuccessful) {
                    _videos.value = GetAllVideoResponse(response.body()?.data ?: emptyList())
                    Log.d("Video ID", "Fetching topics for videoId: $topicId")

                    Log.d("StudyViewModel", "Fetched videos: ${_videos.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching videos: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching videos: ${e.message}")
            }
        }
    }

    fun getVideo(videoId: Int) {
        viewModelScope.launch {
            try {
                val response = studyRepository.getVideo(videoId)
                if (response.isSuccessful) {
                    _video.value = GetVideoResponse(response.body()?.data ?: Video())
                    Log.d("Video ID", "Fetching topics for videoId: $videoId")

                    Log.d("StudyViewModel", "Fetched video: ${_video.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching video: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching video: ${e.message}")
            }
        }
    }


    //jembatan antara view dengan viewmodel, kalo ga ada ini data yang dari view ke viewmodel ga bisa ke update
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SilenceApplication)
                val studyRepository = application.container.studyRepository
                StudyViewModel(studyRepository)
            }
        }
    }

}
