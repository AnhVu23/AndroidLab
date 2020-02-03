package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{onButtonClickListener()}
    }
    private fun onButtonClickListener() {
        val titleTextView = findViewById<TextView>(R.id.textView1)
        if (titleTextView.text === getString(R.string.title)) {
            titleTextView.text = getString(R.string.alter_title)
        } else {
            titleTextView.text = getString(R.string.title)
        }
    }
}
