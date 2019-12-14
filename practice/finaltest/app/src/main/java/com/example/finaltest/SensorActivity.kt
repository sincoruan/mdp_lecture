package com.example.finaltest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sensor.*
import kotlin.random.Random

class SensorActivity : AppCompatActivity(),SensorEventListener {
    var list  = arrayOf<String>("apple","banana","pear","cherry","blueberry")
    lateinit var shake:Sensor
    lateinit var sensorManager:SensorManager
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {

        var arr = event?.values
        Toast.makeText(this,"onSensorChanged  ${arr!![0]}- ${arr!![1]}- ${arr!![2]}",Toast.LENGTH_SHORT).show()
        if(arr!![0]>10 || arr!![1]>10 || arr!![2]>10){
            var random = (0..4).random()
            displaySensor.text = list[random]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        shake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if(shake==null)
            Toast.makeText(this,"has accelometer",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this,"has not accelometer",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,shake,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
