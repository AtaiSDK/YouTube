package com.example.youtube.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.core.data.model.PlaylistsModel
import com.example.youtube.databinding.ItemVideoBinding
import com.bumptech.glide.Glide

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    private var _list = mutableListOf<PlaylistsModel.Item>()

    fun setListModel(playlist: PlaylistsModel){
        _list = playlist.items.toMutableList()
        notifyDataSetChanged()
    }
    inner class ViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlistModelItem: PlaylistsModel.Item) {
            with(binding){
                tvText1.text = playlistModelItem.snippet.title
                Glide.with(binding.imageView.context)
                    .load(playlistModelItem.snippet.thumbnails.default)
                    .into(binding.imageView)
                tvText2.text = "${playlistModelItem.contentDetails.itemCount}"
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(_list[position])
    }

    override fun getItemCount(): Int {
        return _list.size
    }
}