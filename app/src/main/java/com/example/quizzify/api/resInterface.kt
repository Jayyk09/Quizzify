package com.example.quizzify.api

data class Question(
    val property1: String,
    val property2: String,
    val property3: String,
    val property4: String,
    val property5: String,
    val property6: String
)
data class SubmitAnswersRequest(val score: Int)

data class LoginResponse(val token: String)
data class RegisterResponse(val token: String)

//login request
data class LoginRequest(val email: String, val password: String)