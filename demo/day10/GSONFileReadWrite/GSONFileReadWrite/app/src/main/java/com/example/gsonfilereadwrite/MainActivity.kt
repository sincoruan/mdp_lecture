package com.example.gsonfilereadwrite

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileWriter
import java.io.IOException
import android.Manifest;
import java.io.FileNotFoundException
import java.io.FileReader

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList<Employee>()

        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED))
        {
            write.isEnabled = false
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
        }
    }

    // Check permission of the camera Intent & External Storage
   override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<String>, grantResults:IntArray) {
        if (requestCode == 0)
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                write.isEnabled = true
            }
        }
    }
    // Add into the ArrayList
    fun add(v: View) {
        // Create an Employee object using the EditText Inputs
        val e = Employee()
        e.id = Integer.parseInt(et1.text.toString())
        e.name = et2.text.toString()
        e.desig = et3.text.toString()
        e.dept = et4.text.toString()
       // Add an Employee into the list
        list.add(e)
        Toast.makeText(applicationContext, "Added into List ${e.toString()}", Toast.LENGTH_LONG).show()
        // Code to clear text
        et1.setText("") // or et1.text.clear()
        et2.setText("")
        et3.setText("")
        et4.setText("")
    }
    // Write the data into JSON  and store JSON into your Device External Storage(SD card)
    fun write(v:View) {
        // Set the list of Employees
        if (list.size > 0)
        {
            val emps = Employees()
            emps.employees = list
           // Conversion Employees list object to JSON using Gson
            val gson = Gson()
            val response = gson.toJson(emps)
            // Writing the converted data into File using FileWriter in Your device external storage
            val path = (Environment.getExternalStorageDirectory().absolutePath
                + "/emps_gson.json")
            try
            {
                val writer = FileWriter(path)
                writer.write(response)
                writer.flush()
                writer.close()
                Toast.makeText(applicationContext, "Write successfully on file", Toast.LENGTH_LONG).show()
            }
            catch (e1: IOException) {
                e1.printStackTrace()
            }
        }
        else
            Toast.makeText(applicationContext, "Can't Write Empty List", Toast.LENGTH_LONG).show()
    }
    // Read the Device Storage File into activity.
    fun read(v:View) {
        // Read the File using FileReader
        val path = (Environment.getExternalStorageDirectory()
            .absolutePath + "/emps_gson.json")
        try
        {
            val reader = FileReader(path)
            val gson = Gson()
            val emps = gson.fromJson(reader, Employees::class.java)
            Toast.makeText(applicationContext, emps.toString(), Toast.LENGTH_LONG).show()
            val list = emps.employees
            val builder = StringBuilder()
            if (list.size > 0)
            {
                for (e in list)
                {
                    // Add the list into buffer and the result is added in the Textview
                    builder.append(e.toString())
                    builder.append("\n")
                    Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_LONG).show()
                }
                //Buffered text added into the TextView
                result.text = builder.toString()
            }
            else
                Toast.makeText(applicationContext, "No data", Toast.LENGTH_LONG).show()
        }
        catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }
}
