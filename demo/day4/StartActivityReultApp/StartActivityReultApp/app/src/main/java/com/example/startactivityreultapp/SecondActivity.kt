package com.example.startactivityreultapp
import android.app.Activity
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

class SecondActivity : AppCompatActivity() {
    var input: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_second)
        val l = LinearLayout(this)
        input = EditText(this)
        val b = Button(this)
        b.text = "Please Press after Entering Text"
        b.setOnClickListener(bListener)
        l.addView(input)
        l.addView(b)
        setContentView(l)
    }
    var bListener: View.OnClickListener = View.OnClickListener {
        val data = Intent()
        val text = input?.text.toString()
        //---set the data to pass back
        data.data = Uri.parse(text)
        setResult(Activity.RESULT_OK, data)
        //---close the activity---
        finish()
    }
}
