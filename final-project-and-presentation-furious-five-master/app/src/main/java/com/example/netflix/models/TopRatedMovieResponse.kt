package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class TopRatedMovieResponse (
@SerializedName("results")
val topRatedMovie : List<Movie>

): Parcelable {
    constructor() : this(mutableListOf())
}