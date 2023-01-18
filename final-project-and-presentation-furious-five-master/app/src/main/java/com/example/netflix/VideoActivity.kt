package com.example.netflix

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoPath = "android.resource://"+packageName+"/"+R.raw.netflix_intro_final
        val uri = Uri.parse(videoPath)
        var videoView : VideoView = findViewById(R.id.videoview)

        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}