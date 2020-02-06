package com.example.fragmentlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun updateTextView(text: String) {
        (supportFragmentManager.findFragmentById(R.id.fragment_detail) as? DetailFragment)
            ?.updateText(text)
    }
}
