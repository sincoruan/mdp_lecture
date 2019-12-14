package com.example.gsonspfdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun save(view: View) {
        // Create Gson obeject to store into Shared Preferences
        val gson = Gson()
        val name =et1.text.toString()
        val pass = et2.text.toString()
        // Get the Input from the Edit text and make an User Object
        val ob = User(name, pass)
        // Convert User object into String object using toJson() method
        val first = gson.toJson(ob)
        // Store the retrieved Sting into Shared Preferences
        val spf = getSharedPreferences("user", 0)
        val edit = spf.edit()
        edit.putString("data", first)
        edit.apply()
        Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
        et1.setText("")
        et2.setText("")
    }
    fun show(view:View) {
        // Create Gson obeject to retrieve data from Shared Preferences
        val gson = Gson()
        val spf = getSharedPreferences("user", 0)
        val res = spf.getString("data", "")
        // Convert the String object into User object using fromJson() method, return a type of User
        val opt = gson.fromJson(res, User::class.java)
        if (opt != null) {
            et1.setText(opt.uname)
            et2.setText(opt.password)
        }
        else {
            Toast.makeText(applicationContext, "Failure to retrieve", Toast.LENGTH_LONG).show()
        }
    }
}
