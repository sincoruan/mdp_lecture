package com.example.showsensorslist

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sensorManager: SensorManager
    lateinit var listsensor:List<Sensor>
    lateinit var liststring:ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liststring = ArrayList()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL)
        for (i in listsensor.indices)
        {
            liststring.add(listsensor[i].name)
        }
        adapter = ArrayAdapter(this@MainActivity,
            android.R.layout.simple_list_item_1,
            liststring
        )
        lv1.adapter = adapter
    }
}
