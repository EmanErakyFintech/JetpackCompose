package com.example.jetpackcompose.fragment.home

sealed class EmployeeIntent{
    data class CallEmployees(val token :String, val map: MutableMap<String, String>) : EmployeeIntent()
}
