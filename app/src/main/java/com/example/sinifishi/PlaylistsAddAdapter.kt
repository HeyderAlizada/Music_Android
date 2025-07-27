package com.example.sinifishi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sinifishi.databinding.RecyclerViewerPlaylistsItemBinding

class PlaylistsAddAdapter(val playlists: List<Playlists>) :
    RecyclerView.Adapter<PlaylistsAddAdapter.PlayListsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayListsViewHolder {
        val item = RecyclerViewerPlaylistsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayListsViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: PlayListsViewHolder,
        position: Int
    ) {
        val playlist = playlists[position]
        holder.binding.playlistName.text = playlist.nam
        holder.binding.playlistSize.text = playlist.songs.size.toString()



        holder.binding.radioButton.setOnClickListener {
            val radio = holder.binding.radioButton
            if (radio.isChecked) {
                Toast.makeText(
                    holder.binding.root.context,
                    "The song has been added to the playlist",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    holder.binding.root.context,
                    "The song has been deleted from the playlist",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    class PlayListsViewHolder(val binding: RecyclerViewerPlaylistsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}