package com.example.androidcomponents

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BroadCastReceiverScreen : AppCompatActivity() {
    /**
     * This type of receiver is a dynamic receiver which only receive broadcast when our app is open
     * There are also static receiver which can receive System or External broadcast even when our application
     * is not running this type of receiver has too many restrictions and can only be used by following google's
     * policies for doing the same
     */
    private val airplaneModeReceiver = AirplaneModeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            airplaneModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        setContentView(R.layout.activity_broad_cast_receiver_screen)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}