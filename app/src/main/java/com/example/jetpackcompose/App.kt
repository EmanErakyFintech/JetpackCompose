package com.example.jetpackcompose

import android.app.Application
import com.example.jetpackcompose.data.di.appModule
import com.example.jetpackcompose.data.di.repoModule
import com.example.jetpackcompose.data.di.serviceModule
import com.example.jetpackcompose.data.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, repoModule, viewModelModule, serviceModule))
        }
    }
}