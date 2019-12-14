
package com.example.sqlitecrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var dbHelper = DatabaseHelper(this)

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //  function to show Toast message
    fun showToast(text: String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    // Function to show an alert dialog with Employee data

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    /**
     * Let's create a method to clear our edittexts
     */
    fun clearEditTexts(){
        idTxt.setText("")
        nameTxt.setText("")
        desigTxt.setText("")
        deptTxt.setText("")

    }
    // Insert Employee data click event handler part
    fun insert(view: View) {
        try {

            dbHelper.insertData(
                nameTxt.text.toString(), desigTxt.text.toString(),
                deptTxt.text.toString())
                showToast("Insert Successfully")
                clearEditTexts()
        }
        catch (e: Exception){
            e.printStackTrace()
            showToast(e.message.toString())
        }
    }
    // Update Employee data click event handler part
    fun update(view: View) {
        try {
            val isUpdate = dbHelper.updateData(idTxt.text.toString(),
                nameTxt.text.toString(),
                desigTxt.text.toString(), deptTxt.text.toString())
            if (isUpdate) {
                showToast("Data Updated Successfully")
                clearEditTexts()
            }
            else
                showToast("Data Not Updated")
        }catch (e: Exception){
            e.printStackTrace()
            showToast(e.message.toString())
        }
    }

    // Delete Employee data click event handler part
    fun delete(view: View) {
       try {
            dbHelper.deleteData(idTxt.text.toString())
           showToast("Deleted Successfully for the id : " + idTxt.text.toString())
            clearEditTexts()
        }catch (e: Exception){
            e.printStackTrace()
            showToast(e.message.toString())
        }

    }
    // Read the Employee data by giving id
    fun read(view: View) {
       try {
           val c = dbHelper.readData(idTxt?.text.toString())
           if (c.count > 0) {
               // To avoid getting errors type mismatch Editable to Text use Setter Property
               nameTxt.setText(c.getString(1))
               desigTxt.setText(c.getString(2))
               deptTxt.setText(c.getString(3))
           } else {
               showToast("No id found")
           }
       }
       catch(e:Exception){
           e.printStackTrace()
           showToast(e.message.toString())
       }

    }

    // To View all Employee data in Alert Dialog
    fun viewall(view: View) {
        val res = dbHelper.allData
        if (res.count == 0) {
            showDialog("Error", "No Data Found")
        }
        val buffer = StringBuffer()
        while (res.moveToNext()) {
            buffer.append("ID :" + res.getString(0) + "\n")
            buffer.append("NAME :" + res.getString(1) + "\n")
            buffer.append("DESIGNATION :" + res.getString(2) + "\n")
            buffer.append("DEPARTMENT :" + res.getString(3) + "\n\n")
        }
        showDialog("Data Listing", buffer.toString())
    }


}



