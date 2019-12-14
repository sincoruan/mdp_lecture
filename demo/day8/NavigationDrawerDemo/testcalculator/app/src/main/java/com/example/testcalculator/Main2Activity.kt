package com.example.testcalculator

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent = intent
        intent.getStringExtra("value")
        textView.text = intent.getStringExtra("value")


    }

    fun click(view: View) {
        var data = Intent()
        data.data = Uri.parse("123")
        setResult(Activity.RESULT_OK,data)

        finish()
    }
}
