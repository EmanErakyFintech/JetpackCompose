package com.example.jetpackcompose.fragment.details


sealed class ViewEmployeeIntent{
    data class CallViewEmployee(val id: Int ,val token :String ) : ViewEmployeeIntent()

}
