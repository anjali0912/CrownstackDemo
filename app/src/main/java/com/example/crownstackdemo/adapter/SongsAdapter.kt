package com.example.crownstackdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.crownstackdemo.data.model.Songs
import com.example.crownstackdemo.databinding.ItemSongsBinding
import com.example.crownstackdemo.ui.songs.SongsViewModel

class SongsAdapter(private val viewModel: SongsViewModel,
                   private val clickListener: (Songs) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {

    private var events = listOf<Songs>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemSongsBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(events[position], clickListener)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    fun setEvents(results: List<Songs>) {
        events = results
        notifyDataSetChanged()
    }

}

class MyViewHolder(val binding: ItemSongsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Songs, clickListener: (Songs) -> Unit) {
        binding.songs = item
        binding.layoutMain.setOnClickListener {
            clickListener(item)
        }
    }
}