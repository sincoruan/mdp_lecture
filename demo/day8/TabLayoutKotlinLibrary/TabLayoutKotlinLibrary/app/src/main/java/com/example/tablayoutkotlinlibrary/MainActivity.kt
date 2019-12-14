package com.example.tablayoutkotlinlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set the toolbar into your appbar in onCreate
        setSupportActionBar(toolbar)
        // Create an object of ViewPagerAdapter by passing supportFragmentManager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        // Call the addFragment to add Fragment tabs and Tab Title
        adapter.addFragment(HomeFragment(), "HOME")
        adapter.addFragment(WorkFragment(), "WORK")
        adapter.addFragment(ContactFragment(), "CONTACT")
        // set your adpater to the ViewPager UI on the Layout
        viewPager.adapter = adapter
        // set the ViewPager to the respective tabs
        tabs.setupWithViewPager(viewPager)
    }
}
