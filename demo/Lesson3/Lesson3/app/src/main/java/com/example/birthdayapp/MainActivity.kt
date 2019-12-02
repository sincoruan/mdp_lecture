package com.example.birthdayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set a Click Listener for the button - Method 1
    /*    button.setOnClickListener {
            // Change the Label Text
            msg.text = "Happy BirthDay Dear ${name.text}!"
            // Change the ImageView dynamically
            image.setImageResource(R.drawable.gift)
        }

        // Set a Click Listener for the button - Method 2
        button.setOnClickListener({ v ->
            // Change the Label Text
            msg.text = "Happy BirthDay Dear ${name.text}!"
            // Change the ImageView dynamically
            image.setImageResource(R.drawable.gift)
        })


        // Set a Click Listener for the button - Method 3
        button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                // Change the Label Text
                msg.text = "Happy BirthDay Dear ${name.text}!"
                // Change the ImageView dynamically
                image.setImageResource(R.drawable.gift)
            }
        })*/
  }

    // Button click event implementation - XML Way
    fun click(view : View){
   /*
          // Get the widgets reference using findViewById
        val name = findViewById<EditText>(R.id.name)
        var msg = findViewById<TextView>(R.id.msg)
        var image =  findViewById<ImageView>(R.id.image)
        val button =  findViewById<Button>(R.id.button)*/

        // Change the Label Text
         msg.text = "Happy BirthDay Dear ${name.text}!"
        // Change the ImageView dynamically
        image.setImageResource(R.drawable.gift)
    }

}
