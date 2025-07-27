package com.example.sinifishi

class Playlists(var cover: Int, var nam: String, var songs: MutableList<Songs>) {
    companion object {
        var playlists = listOf(
            Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ),
            Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ), Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ), Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ), Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ), Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ), Playlists(
                R.drawable.in_utero,
                "A Random Playlist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            ),
            Playlists(
                R.drawable.in_utero,
                "A Random Pldsadasdasdadasdadsasdadasdasdadassdasdaylist",
                mutableListOf(
                    Songs(
                        "Heart-Shaped Box",
                        "Nirvana",
                        R.drawable.in_utero,
                        R.raw.heart_shaped_box
                    ),
                    Songs("Come As You Are", "Nirvana", R.drawable.am, R.raw.heart_shaped_box)
                )
            )
        )
    }
}