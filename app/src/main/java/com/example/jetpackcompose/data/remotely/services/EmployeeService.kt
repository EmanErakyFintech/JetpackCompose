package com.example.jetpackcompose.data.remotely.services

import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.data.models.employees.GeneralResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface EmployeeService {

    @GET("facility/{id}/vendor_employees")
    suspend fun vendorEmployees(
        @Header("Authorization") token: String,
        @Path("id") id: Int = 6,
        @QueryMap map: MutableMap<String, String>,
        @Header("Accept-Language") language: String = "ar",
        @Header("Accept") string: String = "application/json",
    ): Response<GeneralResponse<ArrayList<EmployeeView>>>


    @GET("facility/6/vendor_employees/{employeeId}")
    suspend fun viewEmployee(
        @Path("employeeId") employeeId: Int,
        @Header("Authorization") token: String,
        @Header("Accept-Language") language: String = "ar"
    ): EmployeeView

}