package com.example.quizzify.api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface apiInterface {

    //login and register
    @POST("MY_API_ENDPOINT")
    suspend fun loginUser(
        @Body request: LoginRequest // Assuming LoginRequest is a data class for the request body
    ): Response<LoginResponse>

    @POST("MY_API_ENDPOINT")
    suspend fun registerUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<String>

    @POST("MY_API_ENDPOINT")
    suspend fun Questions(
        @Body request: String
    ): Response<List<Question>>

    @POST("MY_API_ENDPOINT")
    suspend fun SubmitAnswers(
        @Body request: SubmitAnswersRequest
    ): Response<SubmitAnswersRequest>

    companion object {
        // Factory function to create ApiService instance
        fun create(baseUrl: String): apiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(apiInterface::class.java)
        }
    }

}
    //suspend fun Questions(): List<resInterface