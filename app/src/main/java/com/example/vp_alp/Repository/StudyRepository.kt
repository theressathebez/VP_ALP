package com.example.vp_alp.Repository

import com.example.vp_alp.model.Category
import com.example.vp_alp.model.Topic
import com.example.vp_alp.model.Video

class StudyRepository {
    // Dummy Data
    private val categories = listOf(
        Category(1, "Perkenalan"),
        Category(2, "Keluarga"),
        Category(3, "Sekolah"),
        Category(4, "Pekerjaan"),
        Category(5, "Perasaan")
    )

    private val topics = listOf(
        Topic(1, 1, "Alfabet", "10 mins"),
        Topic(2, 1, "Menyapa", "15 mins"),
        Topic(3, 1, "Angka", "20 mins"),
        Topic(4, 1, "Waktu", "25 mins"),
        Topic(5, 2, "Alat Tulis", "10 mins"),
        Topic(6, 2, "Olahraga", "15 mins"),
        Topic(7, 2, "Mata Pelajaran", "20 mins"),
        Topic(8, 3, "Alat Tulis Sekolah", "10 mins"),
        Topic(9, 3, "Olahraga Sekolah", "15 mins")
    )

    private val videos = listOf(
        Video(1, 1, "Video 1", "Intro to Topic 1", "https://www.youtube.com/watch?v=qOD9M95_fS0"),
        Video(2, 2, "Video 2", "Intro to Topic 2", "https://example.com/video2"),
        Video(3, 1, "Video 3", "Intro to Topic 3", "https://example.com/video3"),
        Video(4, 3, "Video 4", "Intro to Topic 4", "https://example.com/video4")
    )

    fun getCategories(): List<Category> = categories

    fun getTopicsByCategoryId(categoryId: Int): List<Topic> {
        return topics.filter { it.categoryId == categoryId }
    }

    fun getVideosByTopicId(topicId: Int): List<Video> {
        return videos.filter { it.topicId == topicId }
    }

    fun getVideoById(videoId: Int): Video? {
        return videos.find { it.id == videoId }
    }
}