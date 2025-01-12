package com.example.vp_alp.uiState

import com.example.vp_alp.model.Video

sealed interface VideosDataStatusUIState {
    data class Success(val videos: List<Video>): VideosDataStatusUIState
    object Start: VideosDataStatusUIState
    object Loading: VideosDataStatusUIState
    data class Failed(val errorMessage:String): VideosDataStatusUIState
}