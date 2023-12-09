package com.example.androidcomponents

import android.app.IntentService
import android.content.Intent
import android.util.Log

object MyIntentService : IntentService("MyIntentService") {

    /// To check if the service is running or not
    var isRunning = false

    /// To Stop this service
    fun stopService(){
        isRunning = true
        Log.d("MyIntentService","Stopped Running")
        this.stopSelf()
    }

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(p0: Intent?) {
        Log.d("MyIntentService","Intent Service is Running");
        try {

            isRunning =  true
            while (isRunning){
                Thread.sleep(1000)
            }
        }catch (err:Error){
            Log.d("MyIntentService",err.toString() + err.message)
        }
    }
}