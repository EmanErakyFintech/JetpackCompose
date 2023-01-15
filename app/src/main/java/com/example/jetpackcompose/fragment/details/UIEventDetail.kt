package com.example.jetpackcompose.fragment.details

sealed class UIEventDetail {
    data class SendId(val id:Int,val token :String) :UIEventDetail()
}
