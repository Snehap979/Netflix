package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Genre(
    @SerializedName("id")
    val id : String? ,

    @SerializedName("name")
    val name : String?
): Parcelable {
    constructor() : this("" ,"" )

}

