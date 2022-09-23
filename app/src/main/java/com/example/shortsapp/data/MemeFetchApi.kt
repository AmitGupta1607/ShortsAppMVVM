package com.example.shortsapp.data

import retrofit2.http.GET

interface MemeFetchApi {

    @GET("/get_memes")
    suspend fun fetchMemes():MemeResponse
}