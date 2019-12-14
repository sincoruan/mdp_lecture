package com.example.lightonoffmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.widget.Toast

class MainActivity : AppCompatActivity(),SensorEventListener {
    // Declare Sensor object to select particular sensor
    private var sensor:Sensor? = null
    // To manage Sensor components declare SensorManager Object
    private var sm:SensorManager? = null
    // Declare MediaPlayer object to play music
    lateinit  var mp:MediaPlayer
    var cuttentLux = 0
    // Declare the boolean flag to know the player is running or not
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize object for Sensor service using getSystemService()
        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        // Initialize Sensor object for the Type light using getDefaultSensor() from SensorManager object
        sensor = sm!!.getDefaultSensor(Sensor.TYPE_LIGHT)
       // Check device has the requested Sensor or not
        if(sensor==null){
            Toast.makeText(this,"Your device has no Sensor.TYPE_LIGHT",Toast.LENGTH_LONG).show()
        }

    }
    // Register your Sensor Manager
    override fun onResume() {
        super.onResume()
        sm!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    // Unregister your Sensor Manager
    override fun onPause() {
        super.onPause()
        sm!!.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.values!![0] > 10 && !flag)
        { // < 10 use for dark. > 40 to run in light
            println("get the change...")
            try
            {
                flag = true
                 mp.setDataSource("http://www.tamilmp3plus.com/837/vijay-prakash-hits/");
                 mp.prepare();
                mp = MediaPlayer.create(applicationContext, R.raw.iphone)
                mp.start()
            }
            catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

}
}
