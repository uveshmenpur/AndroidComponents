package com.example.androidcomponents

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ServicesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_screen)
        val btnStartService: Button = findViewById(R.id.startIntentService)
        val btnStopService: Button = findViewById(R.id.stopIntentService)
        val tvDisplayText: TextView = findViewById(R.id.message)

        btnStartService.setOnClickListener{
            Intent(this, MyIntentService::class.java).also {
                startService(intent)
                tvDisplayText.text = "Service is Running"
            }
        }

        btnStopService.setOnClickListener{
            MyIntentService.stopService()
            tvDisplayText.text =  "Service Stopped Now"
        }
    }
}