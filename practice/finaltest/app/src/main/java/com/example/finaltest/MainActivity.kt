package com.example.finaltest

import android.content.Intent
import android.hardware.Sensor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_video_recording.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreference.setOnClickListener {
            var intent =Intent(this,SharePreferenceActivity::class.java)
            startActivity(intent)
        }
        sensor.setOnClickListener {
            var intent =Intent(this,SensorActivity::class.java)
            startActivity(intent)
        }
        webview.setOnClickListener {
            var intent =Intent(this,WebViewActivity::class.java)
            startActivity(intent)
        }
        videoplay.setOnClickListener {
            var intent =Intent(this,VideoPlayActivity::class.java)
            startActivity(intent)
        }
        videorecord.setOnClickListener {
            var intent =Intent(this,VideoRecording::class.java)
            startActivity(intent)
        }
        audiorecord.setOnClickListener {
            var intent =Intent(this,AudioRecordActivity::class.java)
            startActivity(intent)
        }

    }

}
