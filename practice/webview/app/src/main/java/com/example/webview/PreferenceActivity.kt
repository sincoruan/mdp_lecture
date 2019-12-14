package com.example.webview

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preference.*

class PreferenceActivity : AppCompatActivity() {
    lateinit var spf :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        spf = getSharedPreferences("testspf", Context.MODE_PRIVATE)

        store.setOnClickListener {

            var editor = spf.edit()
            editor.putString("username",username.text.toString())
            editor.putString("password",password.text.toString())
            editor.apply()
        }
        display.setOnClickListener {
            disuser.text = spf.getString("username","null")
            dispass.text = spf.getString("password","null")

        }
    }
}
