package com.example.testcalculator

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmanager = supportFragmentManager
        var tx = fragmanager.beginTransaction()
        var fragment1 = Fragment1()
        tx.replace(R.id.frag1,fragment1)
        tx.commit()


        start.setOnClickListener{
            var intent = Intent(this,Main2Activity::class.java)
            intent.putExtra("value",text1.text.toString())
            startActivityForResult(intent,1)
        }

    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==1)
        {
            if (resultCode == Activity.RESULT_OK) {
                val returnedResult = data!!.data!!.toString()
                Toast.makeText(this,"returnedResult:$returnedResult",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun onclick(view: View){
        var txt1 = findViewById<TextView>(R.id.text1).text.toString().toInt()
        var txt2 = findViewById<TextView>(R.id.text2).text.toString().toInt()

        var resul = 0
        when(view.id){
            R.id.plus-> resul = txt1+txt2
            R.id.minus-> resul = txt1-txt2
            R.id.times-> resul = txt1*txt2
        }
        result.text = resul.toString()
    }
}
