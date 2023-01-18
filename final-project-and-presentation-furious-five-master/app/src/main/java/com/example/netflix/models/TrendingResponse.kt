package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrendingResponse(
    @SerializedName("results")
    val trending : List<Movie>

): Parcelable {
    constructor() : this(mutableListOf())
}