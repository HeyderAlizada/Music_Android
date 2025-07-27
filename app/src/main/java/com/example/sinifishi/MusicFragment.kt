package com.example.sinifishi

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sinifishi.databinding.FragmentMusicBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MusicFragment : Fragment() {
    private val args : MusicFragmentArgs by navArgs()
    private lateinit var binding: FragmentMusicBinding
    private lateinit var mp: MediaPlayer
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var updateSeekBar: Runnable
    private lateinit var secondBottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // MediaPlayer setup
        mp = MediaPlayer.create(requireContext(), args.Song.song)
        binding.seek.max = mp.duration
        binding.artist.text= args.Song.artist
        binding.songName.text=args.Song.title
        binding.songCover.setImageResource(args.Song.songsCover)
        binding.totalTime.text = format(mp.duration)

        updateSeekBar = object : Runnable {
            override fun run() {
                if (mp.isPlaying) {
                    binding.seek.progress = mp.currentPosition
                    binding.currentTime.text = format(mp.currentPosition)
                }
                handler.postDelayed(this, 1000)
            }
        }

        mp.start()
        binding.playBtn.setImageResource(R.drawable.ic_pause)
        handler.post(updateSeekBar)

        binding.playBtn.setOnClickListener {
            if (mp.isPlaying) {
                mp.pause()
                binding.playBtn.setImageResource(R.drawable.ic_play)
            } else {
                mp.start()
                binding.playBtn.setImageResource(R.drawable.ic_pause)
            }
        }

        binding.prevBtn.setOnClickListener {
            mp.seekTo(0)
            binding.seek.progress = 0
        }

        // Bottom sheet setup
        bottomSheetBehavior = BottomSheetBehavior.from(binding.sheet).apply {
            peekHeight = 0
            skipCollapsed = true
            isHideable = true
            state = BottomSheetBehavior.STATE_HIDDEN
        }

        // Expand bottom sheet on Add button click
        binding.addButton.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        // RecyclerView setup
        val rv2Adapter = PlaylistsAddAdapter(Playlists.playlists, args.Song)
        binding.rvPlaylists.apply {
            adapter = rv2Adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        // SeekBar tracking
        binding.seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mp.seekTo(progress)
                    binding.currentTime.text = format(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        secondBottomSheetBehavior = BottomSheetBehavior.from(binding.sheet2).apply {
            peekHeight = 0
            skipCollapsed = true
            isHideable = true
            state = BottomSheetBehavior.STATE_HIDDEN
        }
        binding.create.setOnClickListener {
            secondBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(updateSeekBar)
        mp.release()
    }

    private fun format(duration: Int): String {
        val minutes = duration / 1000 / 60
        val seconds = (duration / 1000) % 60
        return String.format("%d:%02d", minutes, seconds)
    }
}
