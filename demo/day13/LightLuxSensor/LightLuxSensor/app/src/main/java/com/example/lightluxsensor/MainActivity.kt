package com.example.lightluxsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//implement SensorEventListener
class MainActivity : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var lightSensor: Sensor?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get sensor manager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        //get the specified sensor
        lightSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)
        if(lightSensor==null){
            Toast.makeText(this,"Your device has no Sensor.TYPE_LIGHT",Toast.LENGTH_LONG).show()
        }
    }
    // Register your Sensor Manager
    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    // Unregister your Sensor Manager
    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
    // get sensor update and reading
    override fun onSensorChanged(event: SensorEvent) {
        val ac = event.accuracy
        // Toast.makeText(this,event.toString()+" Accuracy : "+ac,Toast.LENGTH_LONG).show();
        if (event.sensor.type == Sensor.TYPE_LIGHT)  {
            val currentReading = event.values[0]
            // lightmeter is the id of ProgressBar from the layout
            lightmeter.progress = currentReading.toInt()
            reading.text = ("Current Reading: "
                    + (currentReading).toString() + " Lux")
        }
    }
    override fun onAccuracyChanged(sensor:Sensor, i:Int) {
    }
}
