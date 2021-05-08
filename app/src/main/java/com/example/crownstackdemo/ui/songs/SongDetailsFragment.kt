package com.example.crownstackdemo.ui.songs

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.crownstackdemo.data.model.Songs
import com.example.crownstackdemo.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SongDetailsFragment  : Fragment() {

    /**
     * SongsViewModel injected by dependency injection.
     */
    private val viewModel by viewModel<SongsViewModel>()

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: FragmentDetailsBinding

    lateinit var songs: Songs
    var player = MediaPlayer()

    private val safeArgs: SongDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * Initialize the view.
     */
    private fun initView() {
        songs = safeArgs.arg
        binding.songs = songs

        try {
            val uri: Uri = Uri.parse(songs.previewUrl)
            player.setAudioStreamType(AudioManager.STREAM_MUSIC)
            context?.let { it1 -> player.setDataSource(it1, uri) }
            player.prepare()
        } catch (e: Exception) {
            println(e.toString())
        }

        binding.buttonPlay.setOnClickListener {
           if(player.isPlaying){
               player.pause();
               binding.buttonPlay.setText("PLAY SONG")
           }
            else{
               player.start()
               binding.buttonPlay.setText("Stop playing")
           }
        }
    }

    override fun onPause() {
        super.onPause()
        if(player.isPlaying){
            player.stop()
            Toast.makeText(context, "player stopped",Toast.LENGTH_SHORT).show()
        }
    }

}