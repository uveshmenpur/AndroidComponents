package com.example.androidcomponents

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityScreen : AppCompatActivity() {

    // 1. onCreate: Called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        /// We can connect our Views with Objects using findViewById function and entering the ID of our Views
        val textView: TextView = findViewById(R.id.textView)
        textView.append(R.string.check_the_logs_to_understand_the_activity_lifecycle.toString())

        // Initialization code goes here
        Log.d("LIFECYCLE LOGS","onCreate() :-Activity Created")
    }

    // 2. onStart: Called when the activity is becoming visible to the user.
    override fun onStart() {
        super.onStart()

        // The activity is about to become visible
        Log.d("LIFECYCLE LOGS","onStart() :-Activity Becomes Visible")
    }

    // 3. onResume: Called when the activity will start interacting with the user.
    override fun onResume() {
        super.onResume()

        // The activity has become visible
        Log.d("LIFECYCLE LOGS","onResume() :-Activity Resumed")
    }

    // 4. onPause: Called when the system is about to start resuming another activity.
    override fun onPause() {
        super.onPause()

        // Another activity becomes visible
        Log.d("LIFECYCLE LOGS","onPause() :-Activity Goes in Background ")
    }

    // 5. onStop: Called when the activity is no longer visible to the user.
    override fun onStop() {
        super.onStop()

        // The activity is no longer visible
        Log.d("LIFECYCLE LOGS","onStop() :-Activity has Stopped")
    }
    // 6. onStop: Called when the activity is no longer visible to the user.
    override fun onRestart() {
        super.onRestart()
        // The activity is Restarted
        Log.d("LIFECYCLE LOGS","onRestart() :-The activity is Restarted")
    }

    // 7. onDestroy: Called before the activity is destroyed.
    override fun onDestroy() {
        super.onDestroy()
        // Cleanup or finalization code goes here
        Log.d("LIFECYCLE LOGS","onDestroy() :-User has closed application from recent application")
    }
}
