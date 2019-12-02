package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onSendMessage(view:View){
        var input = smsg.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message",input ) // Here message is a key to retrieve the input text in the second activity
        startActivity(intent)
    }
}
