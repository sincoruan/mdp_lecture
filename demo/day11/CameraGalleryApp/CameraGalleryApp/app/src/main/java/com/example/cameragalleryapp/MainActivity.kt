package com.example.cameragalleryapp

import android.Manifest.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var cam : Button
    val REQUEST_IMAGE_CAPTURE :Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cam = findViewById<Button>(R.id.camera)
        // If we don’t have the appropriate permissions, we disable the button until we do.
        // If we don’t have the appropriate permissions, we disable the button until we do.
        if (ContextCompat.checkSelfPermission(this,
                permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            cam.isEnabled = false
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    permission.CAMERA,
                    permission.WRITE_EXTERNAL_STORAGE
                ),
                0 // Directly use the request code
            )
        }
    }
    // Check permission of the camera Intent & External Storage
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                cam.isEnabled = true
            }
        }
    }
    fun camera(view: View){
        // Standard Intent action that can be sent to have the camera application capture an image and return it.
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)
        }
    }
    fun gallery(view: View){
        val i = Intent()
        // Activity Action for the intent : Pick an item from the data, returning what was selected.
        i.action = Intent.ACTION_PICK
        i.type = "image/*"
        // Start the Gallery Intent activity with the request_code 2
        startActivityForResult(i, 2)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Logic to get from Bundle
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            /*The Android Camera application encodes the photo in the return Intent delivered to onActivityResult() 
            as a small Bitmap in the extras, under the key "data".*/
            val extras = data!!.extras
            val imageBitmap = extras.get("data") as Bitmap // Similar java code is  Bitmap imageBitmap = (Bitmap) extras.get("data");
            iv.setImageBitmap(imageBitmap)
        } else if (requestCode == 2) { // For Clicking Gallery button
    // Set the selected image from the device image gallery to the ImageView component
           iv.setImageURI(data!!.data)
        }
    }
}
