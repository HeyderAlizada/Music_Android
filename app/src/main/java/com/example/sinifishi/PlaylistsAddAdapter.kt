package com.example.sinifishi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sinifishi.databinding.RecyclerViewerPlaylistsItemBinding
class PlaylistsAddAdapter(
    private val playlists: List<Playlists>,
    private val songToAdd: Songs
) : RecyclerView.Adapter<PlaylistsAddAdapter.PlayListsViewHolder>() {

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
        val binding = holder.binding

        binding.playlistName.text = playlist.nam
        binding.playlistSize.text = playlist.songs.size.toString()

        // Check if this playlist already has the song
        binding.radioButton.isChecked = playlist.songs.contains(songToAdd)

        // Avoid duplicate listeners due to RecyclerView recycling
        binding.radioButton.setOnCheckedChangeListener(null)

        binding.radioButton.setOnCheckedChangeListener { _, isChecked ->
            val context = binding.root.context
            if (isChecked) {
                // If the playlist doesn't already have the song, add it
                if (!playlist.songs.contains(songToAdd)) {
                    (playlist.songs as MutableList).add(songToAdd)
                    Toast.makeText(context, "Song added to ${playlist.nam}", Toast.LENGTH_SHORT).show()
                    binding.playlistSize.text = playlist.songs.size.toString()
                }
            } else {
                // Remove the song
                (playlist.songs as MutableList).remove(songToAdd)
                Toast.makeText(context, "Song removed from ${playlist.nam}", Toast.LENGTH_SHORT).show()
                binding.playlistSize.text = playlist.songs.size.toString()
            }
        }
    }

    override fun getItemCount(): Int = playlists.size

    class PlayListsViewHolder(val binding: RecyclerViewerPlaylistsItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
