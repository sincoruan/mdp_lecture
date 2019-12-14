package com.example.spfloginreigter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var spf:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        // key, value pair. Here by default name is not found assign " no value"
        val name = spf.getString("name", "")
        val pwd = spf.getString("pass", "")
        et1.setText(name)
        et2.setText(pwd)
    }
    // Check whether the user exist already in the SharedPreferences.
    fun login(view: View) {
        // To get the SharedPreferences using its name
        // SharedPreferences spf = getSharedPreferences("login", Context.MODE_PRIVATE);
        val name = spf.getString("name", "no value") // key, value pair. Here by default name is not found assign " no value"
        val pwd = spf.getString("pass", "no value")
        if ((name.equals(et1.text.toString(), ignoreCase = true) && et2.text.toString() == pwd)) {
            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(applicationContext, "Fail to Login", Toast.LENGTH_LONG).show()
        }
    }
    fun register(view:View) {
        // We are navigating through to the RegisterActivty from ManinActivity using Intent
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}
