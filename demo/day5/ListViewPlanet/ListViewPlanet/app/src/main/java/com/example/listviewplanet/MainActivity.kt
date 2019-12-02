package com.example.listviewplanet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var imageges = intArrayOf(R.drawable.mercury, R.drawable.ven, R.drawable.earth, R.drawable.mars,
                              R.drawable.jupitar, R.drawable.saturn, R.drawable.uranus, R.drawable.neptune)
    var planets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, planets)
        lview.adapter = adapter
        lview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                val intent = Intent(applicationContext, PlanetActivity::class.java)
                intent.putExtra("image", imageges[position])
                startActivity(intent)
            }
    }
   }

