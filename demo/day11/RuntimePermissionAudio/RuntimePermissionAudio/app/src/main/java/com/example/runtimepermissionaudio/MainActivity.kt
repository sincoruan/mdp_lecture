package com.example.runtimepermissionaudio

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "Permission"
    private val RECORD_REQUEST_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1.we should check the platform

        //2.get the permission status
        // Set onclick Listener for the button
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.RECORD_AUDIO)
        btn.setOnClickListener {
            //2.check the permission
            if (permission == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission already granted")
                Toast.makeText(this,"You are already granted this permission",Toast.LENGTH_LONG).show()
            }
            else {
                //3.if there is no permission  -->Requesting the permissions setup
                setupPermissions()
            }
        }
    }
    private fun setupPermissions() {
        // 4.Explain the reason
        // why do you need permission by showing Alert Dialog action
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.RECORD_AUDIO)) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Permission to access the microphone is required for this app to record audio.")
                .setTitle("Permission required")
            builder.setPositiveButton("OK"
            ) { dialog, id ->
                Log.i(TAG, "Clicked")
                // 5.request permission
                makeRequest()
            }
            val dialog = builder.create()
            dialog.show()
        } else {
            // 5.request permission without explaining purpose  send permission request
            makeRequest()
        }

    }

    private fun makeRequest() {
        //request permission, there is request code
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            RECORD_REQUEST_CODE)
    }
    //6.set the call back method,to deal with the return result
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults : IntArray) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.
                        PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                    Toast.makeText(this,"Permission has been denied by user",Toast.LENGTH_LONG).show()
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                    Toast.makeText(this,"Permission has been granted by the user",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
