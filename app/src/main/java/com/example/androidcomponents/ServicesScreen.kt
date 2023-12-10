package com.example.androidcomponents

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ServicesScreen : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_screen)
        val MY_TAG = "MyServiceLogTag"
        val btnStartService: Button = findViewById(R.id.startIntentService)
        val btnStopService: Button = findViewById(R.id.stopIntentService)
        val btnStartMyService: Button = findViewById(R.id.startService)
        val btnStopMyService: Button = findViewById(R.id.stopService)
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

        btnStartMyService.setOnClickListener{
            Intent(this,MyService::class.java).also {
                it.putExtra("MyString","Value Passed Using Intent")
                startService(it)
                tvDisplayText.text = "Service has Started"
                Log.d(MY_TAG,"Service Has Started")
            }
        }

        btnStopMyService.setOnClickListener {
            Intent(this,MyService::class.java).also { intent ->
                stopService(intent).let {
                    Log.d(MY_TAG,it.toString())
                }
                tvDisplayText.text = "Service Has Stopped now"
                Log.d(MY_TAG,"My Service Has Stopped Running")
            }
        }
    }
}