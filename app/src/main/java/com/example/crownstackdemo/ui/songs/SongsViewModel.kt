package com.example.crownstackdemo.ui.songs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crownstackdemo.data.Result
import com.example.crownstackdemo.data.model.Songs
import com.example.crownstackdemo.data.repository.ISongsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongsViewModel(private val repository: ISongsRepository) : ViewModel() {

    private val mutableSongs = MutableLiveData<List<Songs>>()
    val resultSongs: LiveData<List<Songs>>
        get() = mutableSongs

    companion object {
        private val TAG = SongsViewModel::class.java.simpleName
    }

    init {
        fetchDataFromRemote()
    }

    /**
     * Gets the data from the remote server.
     */
    private fun fetchDataFromRemote() {
        viewModelScope.launch {
            try {
                when (val fetchSongs =
                    withContext(Dispatchers.IO) { repository.fetchRemoteSongs() }) {
                    is Result.Success -> {
                        val songs = fetchSongs.data
                        mutableSongs.value = songs
                    }
                    is Result.Error -> {
                        Log.d(TAG, "Please check the network connection and try again")
                    }
                }

            } catch (e: Exception) {
                Log.d(TAG, "Error while fetching the data")
            }
        }
    }
}