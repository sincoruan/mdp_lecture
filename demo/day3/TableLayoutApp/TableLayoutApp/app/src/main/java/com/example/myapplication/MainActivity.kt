package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

// Program to show the Table Layout and give toast message by clicking the Button Views
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Retrieve the views from XML to Kotlin code using findViewBtId method
        val badd = findViewById<Button>(R.id.add_button)
        val bcan = findViewById<Button>(R.id.cancel_button)
        // Anonymous Implementation of Button click event listener to give a toast Message
        badd.setOnClickListener {
            Toast.makeText(this, "Add Product Button Pressed", Toast.LENGTH_LONG).show()
        }
        bcan.setOnClickListener {
            Toast.makeText(this, "Cancel Button Pressed", Toast.LENGTH_LONG).show()
        }
    }
}

