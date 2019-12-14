package com.example.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            webview.loadUrl("http://facebook.com")
            //webview.loadUrl("file:///android_asset/login.html")
//            var url = search.text.toString()
//            Toast.makeText(this,url,Toast.LENGTH_LONG).show()
//            webview.loadUrl("https://"+url)
        }
        button2.setOnClickListener {
            var intent = Intent(this,NavigateActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            var intent = Intent(this,PreferenceActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            var intent = Intent(this,SensorActivity::class.java)
            startActivity(intent)
        }

        webview.settings.javaScriptEnabled=true
        webview.settings.builtInZoomControls = true;

        webview.webViewClient = WebViewClient()

        webview.addJavascriptInterface(this,"main_interface");

    }
    @JavascriptInterface
    fun displayMsg(name: String, pass: String) {
        Toast.makeText(applicationContext, "$name logged in", Toast.LENGTH_LONG).show()
    }
}
