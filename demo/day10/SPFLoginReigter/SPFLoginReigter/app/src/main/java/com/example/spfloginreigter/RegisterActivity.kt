package com.example.spfloginreigter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun register(view: View) {
        // Create and Read the SharedPreferences
        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        // To write a data using SharedPreferences Object
        val spe = spf.edit()
        // Using put method to write the data in SharedPreferences
        spe.putString("name", et1.text.toString())
        spe.putString("pass", et2.text.toString())
        spe.putString("phone", et3.text.toString())
        spe.putString("email", et4.text.toString())
        spe.apply()
        Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show()
        // Once finished writing we need to go back to the main activity to show the Login
        finish() // automatically destroy the activity and give the visibility of Main Activity
    }
}
