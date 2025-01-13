package com.example.vp_alp.model

import com.google.gson.annotations.SerializedName

data class GetAllTopicResponse(
    val data: List<Topic>
)

data class Topic(
    val id: Int,
    val categoryId: Int,

    @SerializedName("topicName")
    val topic_name: String
)
