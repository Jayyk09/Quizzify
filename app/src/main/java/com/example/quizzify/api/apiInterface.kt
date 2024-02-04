package com.example.quizzify.api

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.Response

interface apiInterface {
    @POST("MY_API_ENDPOINT")
    suspend fun Questions(
        @Query("code") code: String
    ): Response<List<Question>>}