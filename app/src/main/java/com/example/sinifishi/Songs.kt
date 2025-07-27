package com.example.sinifishi

import android.os.Parcelable
import  kotlinx.parcelize.Parcelize
@Parcelize
data class Songs(
    var title:String,
    var artist: String,
    var songsCover : Int,
    var song:Int
): Parcelable

