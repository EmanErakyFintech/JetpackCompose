package com.example.jetpackcompose.data.di

import com.example.jetpackcompose.fragment.details.ViewEmployeeViewModel
import com.example.jetpackcompose.fragment.home.HistoryEmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ViewEmployeeViewModel(get()) }
    viewModel { HistoryEmployeeViewModel(get()) }
}