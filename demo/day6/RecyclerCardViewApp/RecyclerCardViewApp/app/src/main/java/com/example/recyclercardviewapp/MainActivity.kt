package com.example.recyclercardviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var s1 : Array<String>?=null
    var s2 : Array<String>?=null
    var s3 : Array<String>?=null
    var s4 : ArrayList<String>?=null
    var madr : MyAdapter?=null
    var imageges = intArrayOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.cherries,
        R.drawable.dates,
        R.drawable.grapes,
        R.drawable.mango
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        r1 = findViewById<RecyclerView>(R.id.rv)
        s1 = resources.getStringArray(R.array.fruits);
        s2 = resources.getStringArray(R.array.desc);
        s3 = resources.getStringArray(R.array.detail);
        madr = MyAdapter(this,s1 as Array<String>, s2 as Array<String>,imageges,s3 as Array<String>)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr

    }
}
