package com.example.sharedpreferencesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.content.ComponentName
import android.content.Context

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun submit(view: View) {
        // Return the object of SharedPreferences
        val spf = getSharedPreferences("myspf", Context.MODE_PRIVATE)

        // To write a data using SharedPreferences Object by calling edit, return Editor object
        val spe = spf.edit()

        // Using put method to write the data in SharedPreferences
        spe.putString("data", et1.text.toString())
        spe.apply()

        // Once finished writing we need to go back to the main activity to show the text
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
        et1.text.clear()
    }

    fun show(view: View) {
        val spf = getSharedPreferences("myspf", Context.MODE_PRIVATE)
        val name = spf.getString("data", "No data Available")
        tv.text = name
    }
}
