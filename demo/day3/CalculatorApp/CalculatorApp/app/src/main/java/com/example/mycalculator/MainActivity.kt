package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
// To get the ids directly from XML without using findViewById() need to do below import
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    // click event implementation from xml  android:onClick="click"
    fun click(view:View) {
        val num1 = et1.text.toString() // to retrieve a text like getter - First Number
        val num2 = et2.text.toString() // Second  Number
        when (view.id) { // Read the clicked Component
            R.id.add -> {  // If View is add button
                val addition = num1.toInt() + num2.toInt()
                tv4.text = addition.toString() // Setting value to the Result text view like setter
            }
            R.id.sub -> {   // If View is subtract button
                val minus = num1.toInt() - num2.toInt()
                tv4.text = minus.toString()
            }
            R.id.mul -> {   // If View is multiplication button
                val mult = num1.toInt() * num2.toInt()
                tv4. text = mult.toString()
            }
            R.id.div -> try { // If View is divide button
                val dvd = num1.toInt() / num2.toInt()
                tv4.text = dvd.toString()
            }
            catch (e:Exception) {
                tv4.text = "Division be Zero"
            }
        }
    }
}
