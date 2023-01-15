package com.example.jetpackcompose.data.models.employees

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T>(
    @SerializedName("data")
    val data: T,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("meta")
    val meta : Paginate
)