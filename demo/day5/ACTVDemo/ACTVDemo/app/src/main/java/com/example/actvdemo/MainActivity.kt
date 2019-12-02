package com.example.actvdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

class MainActivity : AppCompatActivity() {

    private lateinit var  strings : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        strings = arrayOf("Asia","Australia","America","Belgium","Brazil","Canada","California","Dubai","France","Paris")
        // Get the XML configured vales into the Activity and stored into an String Array
        //strings = getResources().getStringArray(R.array.countries);
        /* Pass three parameters to the ArrayAdapter
        1. The current context,
        2. The resource ID for a built-in layout file containing a TextView to use when instantiating views,
           which are available in android.R.layout
        3. The objects to represent in the values
        */
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strings)
        actv.setAdapter(adapter)
        actv.threshold = 1

        actv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
              Toast.makeText(this,"Item selected is " + parent.getItemAtPosition(position),Toast.LENGTH_LONG).show()

            }

    }
}












/*
                  var idval = parent.getItemIdAtPosition(position)
                  getItemAtPosition takes the int position and return object
                  Toast.makeText(this, "Value at "+id.toString() + " selected is : "+parent.getItemAtPosition(position) + "is in : " + position,Toast.LENGTH_LONG).show();
                 var idval = parent.getItemIdAtPosition(position)
                Toast.makeText(this,"Item selected is : "+parent.getItemIdAtPosition(id.toInt()),Toast.LENGTH_LONG).show();*/