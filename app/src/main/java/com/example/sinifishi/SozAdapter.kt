package com.example.sinifishi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sinifishi.databinding.RecyclerViewItemBinding
import kotlinx.serialization.descriptors.PrimitiveKind

class SozAdapter(val songs : List<Songs> ) : RecyclerView.Adapter<SozAdapter.SozViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SozViewHolder {
        val item = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SozViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: SozViewHolder,
        position: Int
    ) {
        val song = songs[position]

        holder.binding.tv1.text = song.title
        holder.binding.tv2.text = song.artist


        holder.binding.image.setImageResource(song.songsCover)

        holder.binding.root.setOnClickListener {
            Navigation.findNavController(it ).navigate(MainMenuFragmentDirections.actionMainMenuFragmentToMusicFragment2(song))

        }

    }

    override fun getItemCount(): Int {
        return songs.size
    }

    class SozViewHolder(val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)




}