package com.example.spinnerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import android.view.View
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var wt: EditText? = null
    var weight = 0.0
    var value = 0.0 // var value = 0 // To work with Integer type
    var x: String? = null
    private lateinit var  values : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        values = resources.getStringArray(R.array.planets);
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, values)
        spinner.adapter = adapter;
        wt =  findViewById<EditText>(R.id.mass);
        // Called when the focus state of a view has changed.
        wt?.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    // * is unbounded wildcard like ? in java
                    override fun onItemSelected(parent: AdapterView<*>,view: View,position: Int,id: Long) {
                        val item = parent.getItemAtPosition(position).toString()
                        x = wt?.text.toString()
                        // Follow the below two lines of code to convert EditText Decimal into Double
                        val formatter = DecimalFormat("#.##")
                        val mass= formatter.parse(x) as Double
                        //    mass = Integer.parseInt(x) // To work with Integer type
                        //  val mass = value
                        weight = when (item) {
                            "Mercury" -> mass * 0.38
                            "Venus" -> mass * 0.91
                            "Earth" -> mass * 1.0
                            "Mars" -> mass * 0.38
                            "Jupiter" -> mass * 2.34
                            "Saturn" -> mass * 0.93
                            "Uranus" -> mass * 0.92
                            "Neptune" -> mass * 0.91
                            else -> 0.0
                        }
                        // Convert double to String
                        val res = formatter.format(weight)
                        Toast.makeText(this@MainActivity, "Your weight in the  " + item + "is : " + res, Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {}
                }
            }
        }
    }
}
