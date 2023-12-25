package com.example.androidcomponents

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val MY_TAG = "MyServiceLogTag"
    init {
        Log.d(MY_TAG,"Service is now Running")
    }
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("MyString")
        dataString?.let {
            Log.d(MY_TAG,dataString)
        }

        Thread{
            for (i in 1..100000) {
                Log.d("HEAVY_CALCULATIONS", (i * i).toString())
            }
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }
}
