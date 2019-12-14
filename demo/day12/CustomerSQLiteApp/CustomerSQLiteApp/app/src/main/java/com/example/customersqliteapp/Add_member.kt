package com.example.customersqliteapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
/**
 * Created by rMohanraj on 7/30/2017.
 */
class Add_member:Activity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var et3:EditText
    lateinit var add_bt:Button
    lateinit var dbcon:SQLController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_member)
        et1 = findViewById(R.id.cname) as EditText
        et2 = findViewById(R.id.mobile) as EditText
        et3 = findViewById(R.id.email) as EditText
        add_bt = findViewById(R.id.bt1) as Button
        dbcon = SQLController(this)
        dbcon.open()
    }
    fun addContact(v:View) {
        val name = et1.getText().toString()
        val mobile = et2.getText().toString()
        val email = et3.getText().toString()
        dbcon.insertData(name, mobile, email)
        Toast.makeText(getApplicationContext(), "Successfully Inserted : " + name + "\n" + mobile + "\n" + email,
            Toast.LENGTH_SHORT).show()
        val main = Intent(this@Add_member, MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        /*Intent.FLAG_ACTIVITY_CLEAR_TOP - If the Intent resolves to an Activity in the current task the Activities
     above it on the stack are destroyed so that it is at the top of the stack, and it is re-used.*/
        startActivity(main)
    }
}