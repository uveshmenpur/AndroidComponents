package com.example.androidcomponents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntentScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_screen)
        val btn1:Button = findViewById(R.id.mainActivityButton)
        val btn2:Button = findViewById(R.id.youtubeButton)
        val btn3:Button = findViewById(R.id.gmailButton)
        val tvExtraData: TextView = findViewById(R.id.textView4)
        val getIntent = intent
        val data = getIntent.getStringExtra("EXTRA_STRING")
        tvExtraData.text = data

        /** Navigate to main Activity using Intent */
        btn1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        /** Open Youtube Application using Intent */
        btn2.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.`package` = "com.google.android.youtube"
            startActivity(intent)
        }

        /** Open GMAIL Application using Intent and pass all the mail content from our application */
        btn3.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("uveshmenpur.03@gmail.com"))
                putExtra(Intent.EXTRA_PHONE_NUMBER, arrayOf("9624150392"))
                putExtra(Intent.EXTRA_SUBJECT,"This is the subject of my email")
                putExtra(Intent.EXTRA_TEXT,"This is the content of my email passed using intent")
            }
            /** this condition checks if there is any application in our application that accepts such intent */
            /** [Intent.resolveActivity] gives warning as after android 10
             * it is not allowed for application to scan
             * users device to check all the application whether they can accept this intent or not
             * If you want to use this function than you need to add queries for the same in AndroidManifest.xml file*/
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }
    }
}