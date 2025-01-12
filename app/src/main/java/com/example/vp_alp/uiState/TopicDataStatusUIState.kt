package com.example.vp_alp.uiState

import com.example.vp_alp.model.Topic

sealed interface TopicDataStatusUIState {
    data class Success(val topic: List<Topic>): TopicDataStatusUIState
    object Start: TopicDataStatusUIState
    object Loading: TopicDataStatusUIState
    data class Failed(val errorMessage:String): TopicDataStatusUIState
}