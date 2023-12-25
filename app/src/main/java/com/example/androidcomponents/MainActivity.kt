package com.example.androidcomponents

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var uri: Uri? = null
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnActivity: Button = findViewById(R.id.activity)
        val btnServices: Button = findViewById(R.id.services)
        val btnContentProvider: Button = findViewById(R.id.contentProvider)
        val broadCastReceiver: Button = findViewById(R.id.broadCastReceiver)
        val intentButton: Button = findViewById(R.id.intent)
        imageView = findViewById(R.id.imageView)

        btnActivity.setOnClickListener {
            val intent = Intent(this,ActivityScreen::class.java)
            startActivity(intent)
        }

        btnServices.setOnClickListener {
            val intent = Intent(this,ServicesScreen::class.java)
            startActivity(intent)
        }

        btnContentProvider.setOnClickListener {
            val intent = Intent(this,ContentProviderScreen::class.java)
            startActivity(intent)
        }

        broadCastReceiver.setOnClickListener {
            val intent = Intent(this,BroadCastReceiverScreen::class.java)
            startActivity(intent)
        }

        intentButton.setOnClickListener {
            val intent = Intent(this,IntentScreen::class.java)
            intent.putExtra("EXTRA_STRING", "Data passed using intent")
            startActivity(intent)
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            } else {
                intent.getParcelableExtra(Intent.EXTRA_STREAM)
            }
            Log.d("IMAGE_FROM_INTENT_FILTER",uri.toString())
            imageView.setImageURI(uri)
        }
    }
}
