package com.example.jetpackcompose.data.di

import com.example.jetpackcompose.data.repository.EmployeeRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single { EmployeeRepositoryImpl(get()) }
}