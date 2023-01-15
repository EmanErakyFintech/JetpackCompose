package com.example.jetpackcompose.data.di

import com.example.jetpackcompose.data.remotely.services.EmployeeService
import org.koin.dsl.module
import retrofit2.Retrofit



val serviceModule = module{
    single{getEmployeeServices(get())}
}
fun getEmployeeServices(retrofit: Retrofit) :  EmployeeService =
    retrofit.create(EmployeeService::class.java)
