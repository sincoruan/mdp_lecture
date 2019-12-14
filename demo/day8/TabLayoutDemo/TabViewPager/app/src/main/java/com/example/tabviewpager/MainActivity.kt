package com.example.tabviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.tabs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val adapter = ViewPageAdapter(supportFragmentManager)

        adapter.addFragment(Fragment1(),"Word Search")
        adapter.addFragment(Fragment2(),"Favorite")
        adapter.addFragment(Fragment3(),"About Me")

        var viewpage = findViewById<ViewPager>(R.id.viewPager)

        viewpage.adapter = adapter

        tabs.setupWithViewPager(viewpage)
    }
}