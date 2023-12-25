package com.example.androidcomponents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings

class AirplaneModeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if(intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isAirplaneModeOn = Settings.Global.getInt(
                context.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) != 0
            android.util.Log.d("CHECK_AIRPLANE_MODE","$isAirplaneModeOn")
        }
    }
}