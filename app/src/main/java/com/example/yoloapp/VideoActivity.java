package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String videoPath = intent.getStringExtra("VIDEO_PATH");

        VideoView videoView = findViewById(R.id.videoView);

        videoView.setVideoPath(videoPath);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + videoPath);

        videoView.setVideoURI(uri);

        videoView.start();

    }
}