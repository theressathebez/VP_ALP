package com.example.vp_alp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp.Repository.StudyRepository
import com.example.vp_alp.model.Category
import com.example.vp_alp.model.Topic
import com.example.vp_alp.model.Video
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudyViewModel : ViewModel() {
    private val repository = StudyRepository()

    //set  category
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _topics = MutableStateFlow<List<Topic>>(emptyList())
    val topics: StateFlow<List<Topic>> = _topics

    // Videos
    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> = _videos

    private val _selectedVideo = MutableStateFlow<Video?>(null)
    val selectedVideo: StateFlow<Video?> = _selectedVideo


    init {
        loadCategories()
    }

    fun loadCategories() {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
        }
    }

    fun fetchTopicsByCategoryId(categoryId: Int) {
        viewModelScope.launch {
            _topics.value = repository.getTopicsByCategoryId(categoryId)
        }
    }

    fun fetchVideosByTopicId(topicId: Int) {
        viewModelScope.launch {
            _videos.value = repository.getVideosByTopicId(topicId)
        }
    }

    fun fetchVideoById(videoId: Int) {
        viewModelScope.launch {
            _selectedVideo.value = repository.getVideoById(videoId)
        }
    }

}
