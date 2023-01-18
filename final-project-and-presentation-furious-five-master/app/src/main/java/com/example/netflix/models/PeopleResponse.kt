package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PeopleResponse(
    @SerializedName("results")
    val people : List<People>

): Parcelable {
    constructor() : this(mutableListOf())
}
