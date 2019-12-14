package com.example.popupmenudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.graphics.Color

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // Set click listener to the button
            bt.setOnClickListener(object:View.OnClickListener {
           override fun onClick(view:View) {
                // Initialize a new instance of popup menu
                val popupMenu = PopupMenu(this@MainActivity.applicationContext, bt)

                // Inflate the popup menu
                popupMenu.getMenuInflater().inflate(R.menu.popup_menuu, popupMenu.getMenu())

                // Set a click listener for menu item click
                popupMenu.setOnMenuItemClickListener(object:PopupMenu.OnMenuItemClickListener {
                   override fun onMenuItemClick(menuItem:MenuItem):Boolean {
                        when (menuItem.getItemId()) {
                            // Handle the menu items here
                            R.id.red -> {
                                // Set the text color to red
                                tv.setTextColor(Color.RED)
                                return true
                            }
                            R.id.green -> {
                                // Set the text color to green
                               tv.setTextColor(Color.GREEN)
                                return true
                            }
                            R.id.blue -> {
                                // Set the text color to blue
                               tv.setTextColor(Color.BLUE)
                                return true
                            }
                            else -> return false
                        }
                    }
                })
                // Finally, show the popup menu
                popupMenu.show()
            }
        })
    }
}
