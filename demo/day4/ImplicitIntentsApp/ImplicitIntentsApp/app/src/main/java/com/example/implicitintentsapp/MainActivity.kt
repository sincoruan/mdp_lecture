package com.example.implicitintentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
 /*  Handles the onClick for the "Open Website" button.  Gets the URI
     from the edit text and sends an implicit intent for that URL.*/
    fun openWebsite(view: View) {
     // Get the URL text.
       var url = website_edittext.text.toString()
     // Parse the URI and create the intent.
     val webpage = Uri.parse(url)
     val intent = Intent(Intent.ACTION_VIEW, webpage)
     // Find an activity to handle the intent and start that activity.
     if (intent.resolveActivity(packageManager) != null) {
         startActivity(intent)
     } else {
         Log.d("ImplicitIntents", "Can't handle this intent!")
     }
    }
    /*
      Handles the onClick for the "Open Location" button.  Gets the location
      text from the edit text and sends an implicit intent for that location.
      The location text can be any searchable geographic location. */
    fun openLocation(view: View) {
        // Get the string indicating a location.
      var loc = location_editext.text.toString()
        // Parse the location and create the intent. geo:latitude,longitude?q=query
        // q defines the place(s) to highlight on the map. The q parameter is required for all Search requests.
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }
    /* Handles the onClick for the "Share This Text" button.
     The implicit intent here is created by the ShareCompat.IntentBuilder class.
     An app chooser appears with the available options for sharing.
     ShareCompat.IntentBuilder is available from the v4 Support Library.*/

    fun shareText(view: View) {
        var txt =  share_edittext.text.toString()
        // Build the share intent with the mimetype text/plain and launch
        // a chooser for the user to pick an app.
        ShareCompat.IntentBuilder
            .from(this)
            .setType("text/plain")
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser();
    }
 }


