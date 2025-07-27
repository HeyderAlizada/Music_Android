package com.example.sinifishi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sinifishi.databinding.ActivityMainBinding
import com.example.sinifishi.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainMenuBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val songList = listOf<Songs>(Songs("Heart-Shaped Box", "Nirvana", R.drawable.in_utero, R.raw.heart_shaped_box),
//            Songs("Rape Me", "Nirvana", R.drawable.in_utero, R.drawable.in_utero),
//            Songs("All Apologies", "Nirvana", R.drawable.in_utero, R.raw.heart_shaped_box),
//            Songs("Frances Farmer Will Have Her Revenge on Seattle", "Nirvana", R.drawable.in_utero, R.raw.heart_shaped_box),
//            Songs("Do I Wanna Know?", "Arctic Monkeys", R.drawable.am, R.raw.heart_shaped_box),
//            Songs("R U Mine?", "Arctic Monkeys", R.drawable.am, R.raw.heart_shaped_box),
//            Songs("I Wanna Be Yours", "Arctic Monkeys", R.drawable.am, R.raw.heart_shaped_box),
//            Songs("Arabella", "Arctic Monkeys", R.drawable.am, R.raw.heart_shaped_box)
            )




        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        binding.rvHome.adapter = SozAdapter(songList)

    }

}