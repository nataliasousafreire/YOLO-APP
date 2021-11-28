package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        videoView = findViewById(R.id.videoView2);
        // esconder a actionbar
        getSupportActionBar().hide();
        // executar o video
        videoView.setMediaController( new MediaController(this));
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.birddetect);
        videoView.start();

    }
}