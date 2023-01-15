package com.example.jetpackcompose.utils

sealed class UiResult<out R> {

    object Idle : UiResult<Nothing>()

    object
    Loading : UiResult<Nothing>()

    data class Success<out T>(val data: T?, val successMessage: String = "") :
        UiResult<T>()

    data class Error(
        val exception: String? = null
    ) : UiResult<Nothing>()
}
