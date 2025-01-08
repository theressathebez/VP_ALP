package com.example.vp_alp.model

data class GetAllVideoResponse(
    val videos: List<Video>
)

data class GetVideoResponse(
    val video: String
)

data class Video(
    val id: Int,
    val topicId: Int,
    val title: String,
    val flashcard: String,
    val videoUrl: String
)

data class FlashcardRequest(
    val videoUrl: String = "",
    val flashcard: String = "",
)
