package com.example.retrofitlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun updateTextView(text: String, hit: Int) {
        (supportFragmentManager.findFragmentById(R.id.fragment_detail) as? DetailFragment)
            ?.updateText(text, hit)
    }
}
