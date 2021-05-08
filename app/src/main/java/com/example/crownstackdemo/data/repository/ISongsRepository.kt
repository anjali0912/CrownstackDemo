package com.example.crownstackdemo.data.repository

import com.example.crownstackdemo.data.Result
import com.example.crownstackdemo.data.model.Songs

interface ISongsRepository {
    /**
     * Fetch the data from the remote server.
     */
    suspend fun fetchRemoteSongs(): Result<List<Songs>>
}