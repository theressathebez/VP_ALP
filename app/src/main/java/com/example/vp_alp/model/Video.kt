package com.example.vp_alp.model

import com.google.gson.annotations.SerializedName

data class GetAllVideoResponse(
    val data: List<Video>
)

data class GetVideoResponse(
    val data: Video
)

//data class videoOnly(
//    val videoUrl: String = "",
//    val thumbnail: String = ""
//)

data class Video(
    val id: Int = 0,
    val topicId: Int = 0,

    @SerializedName("videoName")
    val video_name: String = "",

    val flashcard: String = "",
    val video_url: String = ""
)

data class FlashcardRequest(
    val videoUrl: String = "",
    val flashcard: String = "",
)
