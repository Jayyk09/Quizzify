package com.example.quizzify.api

import retrofit2.http.POST

interface apiInterface {
    @POST("MY_API_ENDPOINT")
    suspend fun Questions(): List<resInterface>
}