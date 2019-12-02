package com.example.explicitintentobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    lateinit var result: UserAccount
       override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var tv1 = findViewById<TextView>(R.id.fn)
        var tv2 = findViewById<TextView>(R.id.ln)
        var tv3 = findViewById<TextView>(R.id.mid)
        val intent = intent
        val temp = intent.getSerializableExtra("user")
        result = temp as UserAccount // Casting object type of temp to UserAccount
        tv1.text = result.firstName
        tv2.text = result.lastName
        tv3.text = result.emailId
         //  Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show()
    }
}