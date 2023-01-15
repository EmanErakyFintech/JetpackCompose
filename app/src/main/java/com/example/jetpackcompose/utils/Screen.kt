package com.example.jetpackcompose.utils

sealed class Screen(val screen: String) {
    object Home: Screen("Home")
    object Detail: Screen("Detail/{employeeId}"){
        fun createRoute(employeeId :Int)= "Detail/$employeeId"
    }

    object Create :Screen("Create")

}
