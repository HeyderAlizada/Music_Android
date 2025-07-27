package com.example.sinifishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sinifishi.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)



        val adapter = PlayListsAdapter(Playlists.playlists)
        binding.rvPlay.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }
}
