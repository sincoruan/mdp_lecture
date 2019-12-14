package com.ebookfrenzy.tablayoutdemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.design.widget.TabLayout

import kotlinx.android.synthetic.main.activity_tab_layout_demo.*

class TabLayoutDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_demo)
        setSupportActionBar(toolbar)

        configureTabLayout()
    }

    private fun configureTabLayout() {
        /* The code begins by creating four tabs, assigning the text to appear on each:
        tab_layout.addTab(tab_layout.newTab().setText("Tab 1 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 2 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 3 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 4 Item"))
        */

        // The code begins by creating four tabs, assigning the Icon to appear on each:
        // Here tab_layout id from the layout file. API Icons files
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_email))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_dialer))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_map))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_info))

        /* Creating a Tabbed Interface using the TabLayout Component
          for the ViewPager and the TabLayout component added to the page change listener*/

        val adapter = TabPagerAdapter(supportFragmentManager,tab_layout.tabCount)
        // pager is the ViewPager id from the layout file
        pager.adapter = adapter
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        /*Finally, the onTabSelectedListener is configured on the TabLayout instance
         and the onTabSelected() method implemented to set the current page on the ViewPager
          based on the currently selected tab number.*/

        tab_layout.run {
            // pager is the ViewPager id from the layout file
            pager.adapter = adapter
            pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

            /*Finally, the onTabSelectedListener is configured on the TabLayout instance
             and the onTabSelected() method implemented to set the current page on the ViewPager
              based on the currently selected tab number.*/

            tab_layout.addOnTabSelectedListener(object : TabLayout.
           OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_tab_layout_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
