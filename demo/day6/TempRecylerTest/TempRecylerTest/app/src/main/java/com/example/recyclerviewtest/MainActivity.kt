package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        list = ArrayList(arrayListOf("CS471 Parallel Programming","CS473 Mobile Device Programming","CS472 WAP","CS390 FPP","CS401 MPP","CS435Algorithms"))
        // Create an object for the MyAdapter and pass the values to its constructor
        var adpt = MyAdapter(list)
        // Set the MyAdapter object to your RecyclerView component
        recyclerView.adapter = adpt
    }
}
