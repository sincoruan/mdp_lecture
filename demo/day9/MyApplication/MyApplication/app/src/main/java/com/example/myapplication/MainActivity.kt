package com.example.myapplication

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var url : String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        url = "http://google.com"
        webView.loadUrl(url)
        webView.webViewClient = MyWebClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        btnprev!!.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            }
            else{
                Toast.makeText(this,"NO previous history available",Toast.LENGTH_LONG).show()
            }
        }
        btnnext!!.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            }

            else{
                Toast.makeText(this,"NO back history available",Toast.LENGTH_LONG).show()
            }
        }
   }
    inner class MyWebClient : WebViewClient() {
        // Page Loading started
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            Toast.makeText(this@MainActivity,"Page Started",Toast.LENGTH_LONG).show()
        }
        //Loading the Url
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
        // Page
        override fun onPageFinished(view: WebView, url: String) {
            Toast.makeText(this@MainActivity,"Page Finished",Toast.LENGTH_LONG).show()
            super.onPageFinished(view, url)
        }
    }
}
