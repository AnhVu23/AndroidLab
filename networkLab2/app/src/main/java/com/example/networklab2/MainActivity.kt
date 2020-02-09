package com.example.networklab2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetImageTask{
            imageView.setImageBitmap(it)
        }.execute(URL("https://www.underconsideration.com/brandnew/archives/android_2019_logo_before_after.png"))
    }
    class GetImageTask(private val callback: (Bitmap) -> Unit) : AsyncTask<URL, Void, Bitmap>() {
        override fun onPostExecute(result: Bitmap?) {
            result?.let {
                callback(it)
            }
            super.onPostExecute(result)
        }

        override fun doInBackground(vararg params: URL): Bitmap? {
            return downloadImage(params[0])
        }

        private fun downloadImage(url: URL): Bitmap? {
            return try {
                (url.openConnection() as? HttpURLConnection)
                    ?.inputStream
                    ?.let {
                        BitmapFactory.decodeStream(it)
                    }

            } catch (e: Throwable) {
                null
            }
        }
    }
}
