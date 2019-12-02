package com.example.uidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Better understanding with the help of Java Code for the listener implementation in Kotlin
        /*  spanish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                Toast.makeText(getApplicationContext(),"You have chosen Spanish", Toast.LENGTH_LONG).show();

            }
        });*/
        // Listener implementation for the check boxes Spanish and English
        spanish.setOnCheckedChangeListener { buttoiew, isChecked ->
            if (isChecked)
                Toast.makeText(
                    applicationContext,
                    "You have chosen Spanish",
                    Toast.LENGTH_LONG
                ).show()
        };

        english.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                Toast.makeText(
                    applicationContext,
                    "You have chosen English",
                    Toast.LENGTH_LONG
                ).show()
        };
        // Listener to handle the toggle button clicks

        tb.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this,"Turned On",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Turned Off",Toast.LENGTH_LONG).show()
            }
        }

        // Listener to handle RadioGroup buttons status
        rg.setOnCheckedChangeListener { group, checkedId ->
            // Get which radio button is clicked
            val clicked = rg.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            if (checked)
                Toast.makeText(
                    applicationContext,
                    clicked.text.toString() + " Selected",
                    Toast.LENGTH_LONG
                ).show()
        }
        // Listener to handle the status of Switch button UI
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                status.text = "Switch ON"
            } else {
                status.text = "Switch OFF"
            }
        }
    }
}

