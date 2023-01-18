package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Trending (
    @SerializedName("id")
    val id : String? ,

    @SerializedName("title")
    val title : String? ,

    @SerializedName("poster_path")
    val poster : String? ,






    ): Parcelable {
        constructor() : this("" ,"" ,"")

    }
