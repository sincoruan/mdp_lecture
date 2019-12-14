package com.example.videoplayer

import android.net.Uri
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var TAG = "VideoPlayer"
    var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureVideoView()
    }
    private fun configureVideoView() {
        // To read from the given URL needs Internet permission in Manifest
       videoView1.setVideoPath("https://www.demonuts.com/Demonuts/smallvideo.mp4")
        // To read from raw folder
      //  videoView1.setVideoPath("android.resource://" + packageName + "/" + R.raw.samplevideo )
        /*VideoView canvas will cause the media controls will appear over the video playback by tapping.
         These controls should include a seekbar together with fast forward, rewind and play/pause buttons.
        * */
        mediaController = MediaController(this)

        /* Set the view that acts as the anchor for the control view.
     * This can for example be a VideoView, or your Activity's main view.
     * When VideoView calls this method, it will use the VideoView's parent(SurfaceView)
     * as the anchor. Parameter view The view to which to anchor the controller when it is visible*/
        mediaController?.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController)

        // configure video playback to loop continuously and display the video duration on logs.

        videoView1.setOnPreparedListener { mp ->
            mp.isLooping = true
            Log.i(TAG, "Duration = " + videoView1.duration)
        }
        // Start Playing
        videoView1.start()
    }
}
