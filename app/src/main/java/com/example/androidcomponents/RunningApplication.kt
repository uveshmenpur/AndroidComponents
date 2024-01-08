package com.example.androidcomponents

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class RunningApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("running_channel","Running Notification",NotificationManager.IMPORTANCE_HIGH)
        }
    }
}