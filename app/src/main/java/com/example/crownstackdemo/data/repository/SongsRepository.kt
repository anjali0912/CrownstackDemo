package com.example.crownstackdemo.data.repository

import com.example.crownstackdemo.data.Result
import com.example.crownstackdemo.data.api.ApiService
import com.example.crownstackdemo.data.model.Songs

/**
 * SongsRepository responsible for doing network transactions.
 */
class SongsRepository(private val apiService: ApiService) : ISongsRepository {

    companion object {
        private val TAG = SongsRepository::class.java.simpleName
    }

    override suspend fun fetchRemoteSongs(): Result<List<Songs>> {
        return try {
            val response = apiService.fetchSongs()
            if (response.isSuccessful) {
                Result.Success(response.body()?.results ?: emptyList())
            } else {
                Result.Error(RuntimeException(response.message()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}

