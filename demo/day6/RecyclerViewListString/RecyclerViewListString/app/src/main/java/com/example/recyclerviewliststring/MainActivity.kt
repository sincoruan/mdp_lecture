package com.example.recyclerviewliststring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  get recycler view
        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        // Give the recycler view with Linear layout manager.
        rv?.layoutManager =  LinearLayoutManager(this)
        // Populate Book data list
        val books = ArrayList<Book>()
        books.add(Book("Java","Horstman"))
        books.add(Book("Kotlin","Joshua Bloch"))
        books.add(Book("JavaFX","Herbert"))
        books.add(Book("Android Essentials","Kathy"))
        books.add(Book("Android Development","Bruce"))
        books.add(Book("Kotlin Coding","Brain Goetz"))
        // Create an adapter and supply the data to be displayed.
        var adapter = CustomAdapter(books)
        // Connect the adapter with the recycler view.
        rv.adapter = adapter
    }
}
