package com.example.androidcomponents

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService : Service() {

    override fun onBind(intent: Intent): IBinder? {
       return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        /** Here we pass this as a context which means we are using service as a context
         * and makes our notification service lifecycle aware */
        val notification = NotificationCompat.Builder(this,"running_channel").setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle("Foreground Service is Running").setContentText("Time remaining: ").build()
        startForeground(1,notification)
    }

    enum class Actions {
        START, STOP
    }
}