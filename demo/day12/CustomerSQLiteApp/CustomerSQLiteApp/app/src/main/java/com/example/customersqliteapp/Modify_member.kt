package com.example.customersqliteapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
/**
 * Created by rMohanraj on 8/5/2017.
 */
class Modify_member:Activity(), View.OnClickListener {
    lateinit var et:EditText
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var edit_bt:Button
    lateinit var delete_bt:Button
    var member_id:Long = 0
    lateinit var dbcon:SQLController
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modify_member)
        dbcon = SQLController(this)
        dbcon.open()
        // Configure the ids from modify_member.xml
        et = findViewById(R.id.eid) as EditText
        et1 = findViewById(R.id.ephone) as EditText
        et2 = findViewById(R.id.eemail) as EditText
        edit_bt = findViewById(R.id.udateid) as Button
        delete_bt = findViewById(R.id.deleteid) as Button
        // get the intent and retrieve the values from MainActivity.java ListView setOnItemClickListener
        val i = getIntent()
        val id = i.getStringExtra("mid")
        val name = i.getStringExtra("mname")
        val mobile = i.getStringExtra("mmobile")
        val email = i.getStringExtra("memail")
        member_id = java.lang.Long.parseLong(id)
        /*Retrieve the contents from the selected element from the ListView
     Set the values in EditText controls of this activity,
     if needed do modification on the contents
     */
        et.setText(name)
        et1.setText(mobile)
        et2.setText(email)
        // Invoke the Click Listener of Update and Delete button
        edit_bt.setOnClickListener(this)
        delete_bt.setOnClickListener(this)
    }
    override fun onClick(v:View) {
        // TODO Auto-generated method stub
        when (v.getId()) {
            R.id.udateid -> {
                // Retrieve the modified components from the components
                val update_name = et.getText().toString()
                val update_mobile = et1.getText().toString()
                val update_email = et2.getText().toString()
                dbcon.updateData(member_id, update_name, update_mobile, update_email)
                // after clicking Update, return to MainActivity
                this.returnHome()
            }
            R.id.deleteid -> {
                dbcon.deleteData(member_id)
                // after deleting Update, return to MainActivity
                this.returnHome()
            }
        }
    }
    fun returnHome() {
        val home_intent = Intent(getApplicationContext(),
            MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(home_intent)
    }
}