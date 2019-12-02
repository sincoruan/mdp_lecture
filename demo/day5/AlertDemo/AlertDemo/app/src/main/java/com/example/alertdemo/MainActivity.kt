package com.example.alertdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt.setOnClickListener {
            // 1. Create an object for AlertDialog by passing the current context object
            val builder = AlertDialog.Builder(this@MainActivity)
            // 2. Set the basic information for the builder object
            builder.setTitle("Alert Message")
            builder.setMessage("Do you want to Exit")
            builder.setIcon(R.drawable.alerticon)
            // 3. Performing positive action on clicking Yes button
            // Parameters : dialogInterface object of dialogInterface, which is integer id for the button onClick method
            // DialogInterface -> Interface that defines a dialog-type class that can be shown, dismissed, or canceled, and may have buttons that can be clicked.
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"It's a positive action click by which id : $which",Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss() // dismiss the dialog
                finish() // to destroy the activity
            }
            // 4. Performing Cancel action on clicking Cancel button
            builder.setNegativeButton("Cancel"){dialogInterface, which ->
                Toast.makeText(applicationContext,"It's a positive action click by which id : $which",Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss() // dismiss the dialog, but activity is still alive
            }
            builder.setNeutralButton("Thinking"){ dialogInterface, which ->
                Toast.makeText(applicationContext,"It's a neutral click by by which id : $which",Toast.LENGTH_SHORT).show()
            }
            // 5. Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()
            // 6. Display the alert dialog on app interface
            dialog.show()
        }
    }
}
