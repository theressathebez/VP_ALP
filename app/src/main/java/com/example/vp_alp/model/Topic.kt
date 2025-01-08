package com.example.vp_alp.model

data class GetAllTopicResponse(
    val topics: List<Topic>
)

data class Topic(
    val id: Int,
    val categoryId: Int,
    val topic_name: String
)
