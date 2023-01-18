package com.example.netflix.models

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (
    @SerializedName("results")
    val movie : List<Movie>

        ):  Parcelable{
            constructor() : this(mutableListOf())
        }