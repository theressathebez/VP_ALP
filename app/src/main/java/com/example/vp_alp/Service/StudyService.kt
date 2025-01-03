//package com.example.vp_alp.Service
//
//import com.example.vp_alp.Repository.StudyRepository
//import com.example.vp_alp.model.Category
//import com.example.vp_alp.model.Topic
//import com.example.vp_alp.model.Video
//
//object StudyService {
//    fun fetchCategories(): List<Category> = StudyRepository.getCategories()
//
//    fun fetchTopicsByCategoryId(categoryId: Int): List<Topic>? =
//        StudyRepository.getCategoryById(categoryId)?.topics
//
//    fun fetchVideosByTopicId(topicId: Int): List<Video>? =
//        StudyRepository.getTopicById(topicId)?.videos
//}