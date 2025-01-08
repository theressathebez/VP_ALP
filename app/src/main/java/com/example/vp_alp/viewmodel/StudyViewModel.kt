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

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> get() = _categories

    private val _topics = MutableStateFlow<List<Topic>>(emptyList())
    val topics: StateFlow<List<Topic>> get() = _topics

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> get() = _videos

    private val _video = MutableStateFlow<Video?>(null)
    val video: StateFlow<Video?> get() = _video

    fun fetchCategories() {
        viewModelScope.launch {
            categoryDataStatus = CategoryDataStatusUIState.Loading

            try {
                val call = studyRepository.getCategories()
                call.enqueue(object : Callback<GetAllCategoriesResponse> {
                    override fun onResponse(
                        call: Call<GetAllCategoriesResponse>,
                        res: Response<GetAllCategoriesResponse>
                    ) {
                        if (res.isSuccessful) {
                            categoryDataStatus = CategoryDataStatusUIState.Success(res.body()!!.categories)

                            Log.d("get-todo-result", "GET TODO: ${res.body()}")

                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                            categoryDataStatus = CategoryDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GetAllCategoriesResponse>, t: Throwable) {
                        categoryDataStatus = CategoryDataStatusUIState.Failed(t.localizedMessage)
                    }
                })
            } catch (error: IOException) {
                categoryDataStatus = CategoryDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    fun fetchTopics(categoryId: Int) {
        viewModelScope.launch {
            topicDataStatus = TopicDataStatusUIState.Loading

            try {
                val call = studyRepository.getTopics(categoryId)
                call.enqueue(object : Callback<GetAllTopicResponse> {
                    override fun onResponse(
                        call: Call<GetAllTopicResponse>,
                        res: Response<GetAllTopicResponse>
                    ) {
                        if (res.isSuccessful) {
                            topicDataStatus = TopicDataStatusUIState.Success(res.body()!!.topics)

                            Log.d("get-todo-result", "GET TODO: ${res.body()}")

                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                            topicDataStatus = TopicDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GetAllTopicResponse>, t: Throwable) {
                        topicDataStatus = TopicDataStatusUIState.Failed(t.localizedMessage)
                    }
                })
            } catch (error: IOException) {
                topicDataStatus = TopicDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    fun fetchVideos(topicId: Int) {
        viewModelScope.launch {
            videosDataStatus = VideosDataStatusUIState.Loading

            try {
                val call = studyRepository.getVideos(topicId)
                call.enqueue(object : Callback<GetAllVideoResponse> {
                    override fun onResponse(
                        call: Call<GetAllVideoResponse>,
                        res: Response<GetAllVideoResponse>
                    ) {
                        if (res.isSuccessful) {
                            videosDataStatus = VideosDataStatusUIState.Success(res.body()!!.videos)

                            Log.d("get-todo-result", "GET TODO: ${res.body()}")

                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                            videosDataStatus = VideosDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GetAllVideoResponse>, t: Throwable) {
                        videosDataStatus = VideosDataStatusUIState.Failed(t.localizedMessage)
                    }
                })
            } catch (error: IOException) {
                videosDataStatus = VideosDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    fun getVideo(videoId: Int) {
        viewModelScope.launch {
            videoDataStatus = StringDataStatusUIState.Loading

            try {
                val call = studyRepository.getVideo(videoId)
                call.enqueue(object : Callback<GetVideoResponse> {
                    override fun onResponse(
                        call: Call<GetVideoResponse>,
                        res: Response<GetVideoResponse>
                    ) {
                        if (res.isSuccessful) {
                            videoDataStatus = StringDataStatusUIState.Success(res.body()!!.video)

                            Log.d("get-todo-result", "GET TODO: ${res.body()}")

                        } else {
                            val errorMessage = Gson().fromJson(
                                res.errorBody()!!.charStream(),
                                ErrorModel::class.java
                            )

                            videoDataStatus = StringDataStatusUIState.Failed(errorMessage.errors)
                        }
                    }

                    override fun onFailure(call: Call<GetVideoResponse>, t: Throwable) {
                        videoDataStatus = StringDataStatusUIState.Failed(t.localizedMessage)
                    }
                })
            } catch (error: IOException) {
                videosDataStatus = VideosDataStatusUIState.Failed(error.localizedMessage)
            }
        }
    }

    //jembatan antara view dengan viewmodel, kalo ga ada ini data yang dari view ke viewmodel ga bisa ke update
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SilenceApplication)
                val studyRepository = application.container.studyRepository
                StudyViewModel( studyRepository)
            }
        }
    }

}
