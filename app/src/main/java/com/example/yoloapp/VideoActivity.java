package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Intent intent;

            setContentView(R.layout.activity_video);
            intent = getIntent();
            this.videoView = (VideoView) findViewById(R.id.videoView);
            this.mediaController = new MediaController( this);
            this.mediaController.setAnchorView(videoView);

            Uri uri = (Uri) intent.getParcelableExtra( "VIDEO_URI");
            Log.d( "videoUri", uri.toString());
            this.videoView.setMediaController( this.mediaController);
            this.videoView.setVideoURI(uri);
            this.videoView.start();
        }catch ( Exception e){
            Log.e( "onCreate", "exceptionThrown", e);
        }

    }
}