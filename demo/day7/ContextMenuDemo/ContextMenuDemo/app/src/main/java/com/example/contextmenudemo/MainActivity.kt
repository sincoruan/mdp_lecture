package com.example.contextmenudemo

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val callid:Int =1
    private val smsid:Int =2
    private val mailid:Int =3
    private val whatsid:Int =4
    var adp : ArrayAdapter<String>?=null

    lateinit var students: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       students = arrayOf("Adnan", "Amanuel", "Aya","Battuguldur", "Bruk", "Desale", "Emmanuel",
           "Fabrice", "Ho", "Jean",  "Osama", "Purevdemberel", "Resty", "Samiksha", "Sibtain",
           "Xingke",  "Yared",   "Yousef", "Ahmed")
        //Creating Adapter
         adp = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, students)

        //Set Adapter to ListView
      lv.adapter = adp

        // Implement a click listener for the list item
//        lv.onItemClickListener =
//            AdapterView.OnItemClickListener { adapterView, view, i, l ->
//                Toast.makeText(this@MainActivity, adapterView.getItemAtPosition(i).toString(),
//                    Toast.LENGTH_SHORT).show() }

        //Register ListView for Context Menu. Accepts a view argument that should show a context menu.
        registerForContextMenu(lv)
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        // Whatever you typed to search the content, will be received using SearchManager object
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        // get the currently set action view for this menu item which returns View and cast it as a SearchView
        val searchView = menu.findItem(R.id.menu_item_search).actionView as SearchView
        // Set Search bar hint
        searchView.queryHint= "Search"
        // Gets information about a searchable activity (Activity exist, searchable activity or null)
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
       // Listener to perform the search based on the types text
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }
    // Filter the text from the List items
    override fun onQueryTextChange(newText: String?): Boolean {
        adp?.filter?.filter(newText)
        return true
    }

    // Programmatically added Context menus without using menu resource xml file
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

       //Set Header of Context Menu
        menu!!.setHeaderTitle("Select Option to Communicate")

        /*
            menu.add get 4 Parameters
            1. groupId if you want to add multiple Group than for every group Id is Different Here
               we have only One Group so We take 0(Zero) as GroupId
            2. menu id for each context menu
            3. Set Order of Our Item(Position Of Item) if you Change order of Call to 1 and SMS to 0
                 than in Menu SMS Display First.
            4. Title to Display on Context menu
        */

        menu.add(0, callid, 0, "Call")
        menu.add(0, smsid, 1, "SMS")
        menu.add(0, mailid, 2, "Email")
        menu.add(0, whatsid, 3, "WhatsApp")

    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        //Get Order of Selected Item such as 0,1,2,3
        val selectedItemOrder = item!!.order

        //Get Title Of Selected Item such as Call, SMS, Email and WhatsApp
        val selectedItemTitle = item.title
        // Get the id of the menu selected
        val id = item.itemId
        //To get Name of student Click on ListView
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val listPosition = info.position
        val name = students[listPosition]

        Toast.makeText(this@MainActivity,
               "Context Menu $selectedItemTitle in the order $selectedItemOrder with the id $id " +
                       "for the student $name",
            Toast.LENGTH_LONG).show()
        return true
    }


}
