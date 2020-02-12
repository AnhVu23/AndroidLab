package com.example.retrofitlab

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Snackbar.make(
            fragment_container,
            "Empty message",
            Snackbar.LENGTH_LONG
        ).setAction("OK") { /* do smth */ }
        .show()
        val notif = NotificationCompat.Builder(this, "1")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle(getString(R.string.notify_title))
        .setContentText("The long description text...")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()
        NotificationManagerCompat.from(this).notify(1, notif)
    }

    fun updateTextView(text: String, hit: Int) {
        (supportFragmentManager.findFragmentById(R.id.fragment_detail) as? DetailFragment)
            ?.updateText(text, hit)
    }
}
