package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Listvideo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listvideo);
        getSupportActionBar().hide();
        //private ImageButton camButton;
        ImageView mainview = (ImageView) findViewById(R.id.ImageMain);
        mainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        ImageView executar = (ImageView) findViewById(R.id.pessoa);
        ImageView executar2 = (ImageView) findViewById(R.id.cachorro);
        ImageView executar3 = (ImageView) findViewById(R.id.passaro);
        ImageView executar4 = (ImageView) findViewById(R.id.praia);

        executar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri rawSourceUri;

                rawSourceUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.peopledetect);
                openVideoPlayer( rawSourceUri);
            }

        });

        executar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri rawSourceUri;

                rawSourceUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dogdetect);
                openVideoPlayer( rawSourceUri);
            }

        });
        executar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri rawSourceUri;

                rawSourceUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birddetect);
                openVideoPlayer( rawSourceUri);
            }

        });
        executar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri rawSourceUri;

                rawSourceUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.summerdetect);
                openVideoPlayer( rawSourceUri);
            }

        });

    }
    public void openVideoPlayer( Uri selectedVideo){
        Intent videoPlayer;

        videoPlayer = new Intent(this, VideoActivity.class);
        videoPlayer.putExtra("VIDEO_URI", selectedVideo);
        startActivity(videoPlayer);
    }

}