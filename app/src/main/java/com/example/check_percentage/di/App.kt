package com.example.check_percentage.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        private lateinit var application: App
        fun getInstance() : App = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}