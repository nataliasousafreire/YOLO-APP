package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle resultado = getIntent().getExtras();

        setContentView(R.layout.activity_play);
        videoView = findViewById(R.id.videoView2);
        // esconder a actionbar
        getSupportActionBar().hide();
        // executar o video
        videoView.setMediaController( new MediaController(this));
        if (resultado !=null){
            Integer id = resultado.getInt("itemSelecionado");
            if(id == 1){
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.peopledetect);
                videoView.start();
            }else if(id == 2){
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.dogdetect);
                videoView.start();
            }else if(id == 3){
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.birddetect);
                videoView.start();
            }else{
                videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.summerdetect);
                videoView.start();
            }
        }




    }
}