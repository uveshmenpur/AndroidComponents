package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)
    }
}