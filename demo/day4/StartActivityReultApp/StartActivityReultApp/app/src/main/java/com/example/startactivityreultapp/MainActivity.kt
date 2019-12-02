package com.example.startactivityreultapp

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.Button
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    var t: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_main)
        val l = LinearLayout(this)
        val b = Button(this)
        b.setText("Please Press")
        b.setOnClickListener(bListener)
        t = TextView(this)
        t?.text = "Result will go here"
        t?.setTextColor(Color.GRAY)
        l.addView(b)
        l.addView(t)
        setContentView(l) // Here we have no layout xml file, hard coded layout
    }
    var bListener: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(v: View) {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(intent, 1) // Here 1 is the request code
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                t?.setTextColor(Color.RED)
                val returnedResult = data!!.data!!.toString()
                t?.text = returnedResult
            }
        }
    }
}
