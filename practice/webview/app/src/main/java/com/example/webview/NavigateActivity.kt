package com.example.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_navigate.*

class NavigateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)

        navwebview.settings.javaScriptEnabled=true
        navwebview.settings.builtInZoomControls=true

        navwebview.webViewClient = MyWebClient()

        navbutton.setOnClickListener {
            navwebview.loadUrl("http://google.com")
        }
        pre.setOnClickListener {
            navwebview.goBack()
        }
        next.setOnClickListener {
            navwebview.goForward()
        }
    }
    inner class MyWebClient:WebViewClient(){
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            Toast.makeText(applicationContext,"pagestarted...",Toast.LENGTH_LONG).show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            Toast.makeText(applicationContext,"pagestarted...",Toast.LENGTH_LONG).show()
        }

        //Loading the Url
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}
