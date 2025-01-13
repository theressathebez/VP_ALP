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
import com.example.vp_alp.model.Category
import com.example.vp_alp.model.ErrorModel
import com.example.vp_alp.model.GetAllCategoriesResponse
import com.example.vp_alp.model.GetAllTopicResponse
import com.example.vp_alp.model.GetAllVideoResponse
import com.example.vp_alp.model.GetVideoResponse
import com.example.vp_alp.model.Topic
import com.example.vp_alp.model.Video
import com.example.vp_alp.uiState.CategoryDataStatusUIState
import com.example.vp_alp.uiState.StringDataStatusUIState
import com.example.vp_alp.uiState.TopicDataStatusUIState
import com.example.vp_alp.uiState.VideosDataStatusUIState
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class StudyViewModel(
    private val studyRepository: StudyRepository
) : ViewModel() {
    var categoryDataStatus: CategoryDataStatusUIState by mutableStateOf(CategoryDataStatusUIState.Start)
        private set

    var topicDataStatus: TopicDataStatusUIState by mutableStateOf(TopicDataStatusUIState.Start)
        private set

    var videosDataStatus: VideosDataStatusUIState by mutableStateOf(VideosDataStatusUIState.Start)
        private set

    var videoDataStatus: StringDataStatusUIState by mutableStateOf(StringDataStatusUIState.Start)
        private set

    var categoryId by mutableStateOf(0)
        private set

    private val _categories = mutableStateOf(GetAllCategoriesResponse(emptyList()))
    val categories: State<GetAllCategoriesResponse> = _categories

    private val _topics = mutableStateOf(GetAllTopicResponse(emptyList()))
    val topics: State<GetAllTopicResponse> = _topics

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> get() = _videos

    private val _video = MutableStateFlow<Video?>(null)
    val video: StateFlow<Video?> get() = _video

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

                    Log.d("StudyViewModel", "Fetched categories: ${_topics.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching categories: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching categories: ${e.message}")
            }
        }
    }

    fun fetchVideos(topicId: Int) {
        viewModelScope.launch {
            try {
                val response = studyRepository.getTopics(categoryId)
                if (response.isSuccessful) {
                    _topics.value = GetAllTopicResponse(response.body()?.data ?: emptyList())
                    Log.d("StudyViewModel", "Fetched categories: ${_topics.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching categories: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching categories: ${e.message}")
            }
        }
    }

    fun getVideo(videoId: Int) {
        viewModelScope.launch {
            try {
                val response = studyRepository.getTopics(categoryId)
                if (response.isSuccessful) {
                    _topics.value = GetAllTopicResponse(response.body()?.data ?: emptyList())
                    Log.d("StudyViewModel", "Fetched categories: ${_topics.value}")
                } else {
                    Log.e("StudyViewModel", "Error fetching categories: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("StudyViewModel", "Exception fetching categories: ${e.message}")
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
