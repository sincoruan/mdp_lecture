package com.example.finaltest

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        wview.settings.javaScriptEnabled =true
        wview.settings.builtInZoomControls = true

        wview.webViewClient  = WebViewClient()

        button.setOnClickListener {
            wview.loadUrl("http://google.com")
        }
        prebtn.setOnClickListener {
            wview.goBack()
        }
        nextbtn.setOnClickListener {
            wview.goForward()
        }

    }
    inner class MyWebViewClient:WebViewClient(){
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}
