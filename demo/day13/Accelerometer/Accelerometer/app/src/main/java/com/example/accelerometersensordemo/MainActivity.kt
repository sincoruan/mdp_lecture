package com.example.accelerometersensordemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit  var sensor:Sensor
    //help us manage sensor components
    lateinit var sm:SensorManager
    lateinit var mPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sm = getSystemService(SENSOR_SERVICE) as SensorManager
        //select the sensor we wish to use
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mPlayer = MediaPlayer.create(this, R.raw.iphone)
    }

    // Register your Sensor Manager
    override fun onResume() {
        super.onResume()
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    // Unregister your Sensor Manager
    override fun onPause() {
        super.onPause()
        sm.unregisterListener(this)
    }
    override fun onSensorChanged(event:SensorEvent) {
        display_reading.text = "X" + event.values[0] + "\nY" + event.values[1] + "\nZ" + event.values[2]
        if (event.values[0] > 10) {
            mPlayer.start()
        }
    }
    // Called when the accuracy of a sensor has changed. We are not going to make use of this.
    override fun onAccuracyChanged(arg0:Sensor, arg1:Int) {
    }
}
