package com.example.jetpackcompose.data.models.employees

import com.google.gson.annotations.SerializedName

data class RegionsItem(
    @SerializedName("id")
    val id: Int=0,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("flag")
    val flag: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("nationality")
    val nationality: String? = null,
    )

