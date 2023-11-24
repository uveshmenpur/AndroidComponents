package com.example.androidcomponents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnActivity: Button = findViewById(R.id.activity)
        val btnServices: Button = findViewById(R.id.services)
        val btnContentProvider: Button = findViewById(R.id.contentProvider)
        val broadCastReceiver: Button = findViewById(R.id.broadCastReceiver)
        val intentButton: Button = findViewById(R.id.intent)

        btnActivity.setOnClickListener {
            val intent = Intent(this,ActivityScreen::class.java)
            startActivity(intent)
        }
        btnServices.setOnClickListener {
            val intent = Intent(this,BroadCastReceiverScreen::class.java)
            startActivity(intent)
        }
        btnContentProvider.setOnClickListener {
            val intent = Intent(this,ContentProviderScreen::class.java)
            startActivity(intent)
        }
        broadCastReceiver.setOnClickListener {
            val intent = Intent(this,ServicesScreen::class.java)
            startActivity(intent)
        }
        intentButton.setOnClickListener {
            val intent = Intent(this,IntentScreen::class.java)
            startActivity(intent)
        }
    }
}