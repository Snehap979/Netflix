package com.example.netflix.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    @SerializedName("id")
    val id : String? ,

    @SerializedName("profile_path")
    val profile : String?,

    @SerializedName("name")
    val name : String


): Parcelable{
    constructor() : this("" , "" , "")

}
