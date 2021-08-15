package com.ottomancoder.videoplayertutorial

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    private var videoPlayer: VideoView? = null
    private var videoController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoPlayer = findViewById(R.id.player)

        configVideoPlayer()

    }

    private fun configVideoPlayer() {
       if(videoController == null){
           videoController = MediaController(this)
           videoController!!.setAnchorView(this.videoPlayer)
       }

        videoPlayer!!.setMediaController(videoController)

        videoPlayer!!.setVideoURI(
            Uri.parse(
            "android.resource://" + packageName + "/" + R.raw.test
        )
        )

        videoPlayer!!.requestFocus()

        videoPlayer!!.pause()

        videoPlayer!!.setOnErrorListener {
                _, _, _ ->
            Toast.makeText(applicationContext,"Getting Error",Toast.LENGTH_SHORT).show()
            false

        }

        videoPlayer!!.setOnCompletionListener {

            Toast.makeText(applicationContext,"Video Completed",Toast.LENGTH_SHORT).show()

        }

    }
}