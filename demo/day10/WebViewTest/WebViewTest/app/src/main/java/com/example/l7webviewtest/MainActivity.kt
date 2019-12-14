package com.example.l7webviewtest

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebViewClient;
import android.widget.Toast;
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Some Webpages support JavaScript, by default Android does not support Java Script and Zoom Controls.
       Through Android we need to enable by giving these two line of code*/
        wview.settings.javaScriptEnabled = true;
        wview.settings.builtInZoomControls = true;

        // To open links clicked by the user in the WebView instead of Default Browser
        wview.webViewClient = WebViewClient()

        // provide the communication between HTML UI & Android activity

        wview.addJavascriptInterface(this,"myinterface");
        /* Once you type this line you will get the error, by adding @JavascriptInterface
        before the method which you interact through HTML and Android activity
         */
    }

    @JavascriptInterface
    fun displayMsg(name: String, pass: String) {
        Toast.makeText(applicationContext, "$name logged in", Toast.LENGTH_LONG).show()
    }

    fun test(v:View) {
        when (v.id) {
            R.id.srch -> {
            // Load the EditText URL to the WebView UI, it is mendatory to mention http:// either here or at the runtime in EditText
            wview.loadUrl("http://" + et1.getText().toString())
            }
            R.id.fb -> wview.loadUrl("http://facebook.com")
            R.id.youtube -> wview.loadUrl("http://youtube.com")
            R.id.google -> wview.loadUrl("http://google.com")
            R.id.twitter -> wview.loadUrl("http://twitter.com")
            // Open your created web page inside Android asset folder
            R.id.html -> wview.loadUrl("file:///android_asset/login.html")
            // Use of existing web page inside asset folder
             R.id.html1 -> wview.loadUrl("file:///android_asset/mycoursewebpage.html")
        }
    }
}
