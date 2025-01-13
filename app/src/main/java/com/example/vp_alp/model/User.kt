package com.example.vp_alp.model


data class UserResponse (
    val data: UserModel
)

data class UserModel (
    val email: String,
    val username: String,
    val password: String,
    val token: String?
)

data class UserRequest (
    val password: String
)