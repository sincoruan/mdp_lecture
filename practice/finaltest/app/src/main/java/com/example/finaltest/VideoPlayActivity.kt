package com.example.finaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_play.*

class VideoPlayActivity : AppCompatActivity() {

    var mediaController: MediaController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)

        configureView()
        videoplay.setOnClickListener {
            videoView.start()
        }
    }
    fun configureView(){
        //videoView
        videoView.setVideoPath("https://www.demonuts.com/Demonuts/smallvideo.mp4")
        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

    }
}
