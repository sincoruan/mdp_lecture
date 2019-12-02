package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var txt : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Method 1 : get the component from XML to Kotlin
        txt = findViewById<TextView>(R.id.tv)

    }

    fun btnClick(view: View) {
      txt?.text = "Button Clicked"

    }
}
