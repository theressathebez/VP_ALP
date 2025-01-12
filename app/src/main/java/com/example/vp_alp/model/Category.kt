package com.example.vp_alp.model

data class GetAllCategoriesResponse(
    val data: List<Category>
)

data class Category(
    val id: Int,
    val name: String,
)
