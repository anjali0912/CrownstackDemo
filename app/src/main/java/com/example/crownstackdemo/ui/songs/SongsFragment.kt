package com.example.crownstackdemo.ui.songs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.crownstackdemo.R
import com.example.crownstackdemo.adapter.SongsAdapter
import com.example.crownstackdemo.data.model.Songs
import com.example.crownstackdemo.databinding.FragmentSongsBinding
import com.example.techalchemytask.helpers.isNetworkConnected
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SongsFragment : Fragment() {

    /**
     * SongsViewModel injected by dependency injection.
     */
    private val viewModel by viewModel<SongsViewModel>()

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: FragmentSongsBinding

    /**
     * Converts the simple data into view and set to the recycler view.
     */
    private lateinit var adapter: SongsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observerSongs()
    }

    /**
     * Initialize the view.
     */
    private fun initView() {
        adapter = SongsAdapter(viewModel, {selectedFruitItem: Songs ->
            listItemClicked(selectedFruitItem)})
        binding.recyclerView.adapter = adapter
    }

    /**
     * Observes the songs data and set to the recycler view.
     */
    private fun observerSongs() {
        viewModel.resultSongs.observe(viewLifecycleOwner, Observer<List<Songs>> {
            if (!it.isNullOrEmpty()) {
                binding.tvEmpty.visibility = View.GONE
                adapter.setEvents(it)
            }
        })
    }

    private  fun listItemClicked(song: Songs){
        val directions = SongsFragmentDirections.navigateToProductDetail(arg = song)
        findNavController().navigate(directions)
    }
}