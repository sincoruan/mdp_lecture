package com.example.customersqliteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_member_entry.*

class MainActivity : AppCompatActivity() {
    lateinit var  dbcon:SQLController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbcon = SQLController(this)
        dbcon.open()
        val cursor = dbcon.readData()
        val from = arrayOf<String>(DBHelper.KEY_ROWID, DBHelper.NAME, DBHelper.PHONE, DBHelper.EMAIL)
        val to = intArrayOf(R.id.cid, R.id.vname, R.id.vmobile, R.id.vemail)
        val adapter = SimpleCursorAdapter(
            this@MainActivity, R.layout.view_member_entry, cursor, from, to,1)
        adapter.notifyDataSetChanged()
        lv1.setAdapter(adapter)
        // OnCLickListiner For List Items
        lv1.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                // Read the values from the view_member_entry.xml
                val vid = cid.text.toString()
                val vname = vname.text.toString()
                val vmobile = vmobile.text.toString()
                val vemail = vemail.text.toString()
                // Toast.makeText(getApplicationContext(), vid + "\n" + vname + "\n" + vmobile + "\n" + vemail,Toast.LENGTH_LONG).show();
                val modify_intent = Intent(
                    applicationContext,
                    Modify_member::class.java)
                modify_intent.putExtra("mid", vid)
                modify_intent.putExtra("mname", vname)
                modify_intent.putExtra("mmobile", vmobile)
                modify_intent.putExtra("memail", vemail)
                // Toast.makeText(getApplicationContext(), vid + "\n" + vname + "\n" + vmobile + "\n" + vemail,Toast.LENGTH_LONG).show();
                startActivity(modify_intent)
            }
    }
    fun addContact(v:View) {
        val add_mem = Intent(this@MainActivity, Add_member::class.java)
        startActivity(add_mem)
    }
}
