package com.example.crownstackdemo.data.api

import com.example.crownstackdemo.data.model.SongsResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * ApiService is responsible to define end points and its responses.
 */
interface ApiService {

    @GET("search?term=Michael+jackson")
    suspend fun fetchSongs(): Response<SongsResponse>
}