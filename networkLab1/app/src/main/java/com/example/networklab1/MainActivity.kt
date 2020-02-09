package com.example.networklab1

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        if (isOnline()) {
            Thread(
                Client(
                    object : Handler(Looper.getMainLooper()) {
                        override fun handleMessage(msg: Message) {
                            super.handleMessage(msg)
                            if (msg.what == 0) {
                                textView1.text = msg.obj.toString()
                            }
                        }
                    }
                )
            ).start()

        }
    }

    private fun isOnline():Boolean {
        return  (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private class Client(private val handler: Handler) : Runnable {
        override fun run() {
            try {
                (URL("http://www.greens.org/about/software/editor.txt").openConnection() as? HttpURLConnection)
                    ?.apply {
                        requestMethod = "GET"
                    }
                    ?.inputStream
                    ?.bufferedReader()
                    ?.use {
                        it.readText()
                    }?.let {
                        handler.obtainMessage()
                            .apply {
                                what = 0
                                obj = it
                            }
                            .also { mes ->
                                handler.sendMessage(mes)
                            }
                    }
            } catch (ignored: Exception) {
            }
        }
    }
}
