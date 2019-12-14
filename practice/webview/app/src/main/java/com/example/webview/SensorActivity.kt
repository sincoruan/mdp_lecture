package com.example.webview

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sensor.*

class SensorActivity : AppCompatActivity(),SensorEventListener {
    lateinit var sensorManager:SensorManager
    lateinit var lightSensor:Sensor
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        Toast.makeText(this,"light change...${accuracy}",Toast.LENGTH_LONG).show()
        if( sensor!=null && sensor?.type == Sensor.TYPE_LIGHT)
        {
            if(accuracy >1 ){

                webview.loadUrl("http://facebook.com")

            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (event?.sensor?.type == Sensor.TYPE_LIGHT)  {
            val currentReading = event.values[0]
            // lightmeter is the id of ProgressBar from the layout
            lightmeter.progress = currentReading.toInt()
            reading.text = ("Current Reading: "
                    + (currentReading).toString() + " Lux")
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        webview.settings.builtInZoomControls = true
        webview.settings.javaScriptEnabled = true

        webview.webViewClient = WebViewClient()


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lightSensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        if(lightSensor==null)
            Toast.makeText(this,"start sensor pag...",Toast.LENGTH_LONG).show()
        else
            println("there is light sensor...")

    }
}
