package com.example.sinifishi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sinifishi.PlaylistsAddAdapter.PlayListsViewHolder
import com.example.sinifishi.databinding.PlaylistsMainItemBinding
import com.example.sinifishi.databinding.RecyclerViewerPlaylistsItemBinding

class PlayListsAdapter(val playlists: List<Playlists>): RecyclerView.Adapter< PlayListsAdapter.PlayListsView>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayListsView {
        val item = PlaylistsMainItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayListsView(item)
    }

    override fun onBindViewHolder(
        holder: PlayListsView,
        position: Int
    ) {
        val playlist = playlists[position]
        holder.binding.playlistName.text = playlist.nam
        holder.binding.playlistSize.text = playlist.songs.size.toString()
    }

    override fun getItemCount(): Int {
        return playlists.size
    }


    class PlayListsView(val binding : PlaylistsMainItemBinding):
            RecyclerView.ViewHolder(binding.root)

}