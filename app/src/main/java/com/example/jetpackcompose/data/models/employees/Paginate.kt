package com.example.jetpackcompose.data.models.employees

import com.google.gson.annotations.SerializedName

data class Paginate(
    @SerializedName("current_page")
    var current_page: Int,
    @SerializedName("last_page")
    val last_page: Int,
)
