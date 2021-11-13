package com.example.yoloapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEO_REQUEST = 999;

    //private ImageButton camButton;
    private ImageView uploadView;
    private ImageView cameraView;
    private ImageView arquivosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View
        uploadView = (ImageView) findViewById(R.id.imageViewUploadUndetectedVideo);
        uploadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                Intent startIntent = new Intent(getApplicationContext(), DetectionActivity.class);
                startActivity(startIntent);
            }
        });

        // Cam
        cameraView = (ImageView) findViewById(R.id.imageViewCamVideoRecord);
        cameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                Intent startIntent = new Intent(getApplicationContext(), DetectionActivity.class);
                startActivity(startIntent);
            }
        });

        //Arquivos
        arquivosView = (ImageView) findViewById(R.id.imageViewVideoSamples);
        arquivosView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                Intent startIntent = new Intent(getApplicationContext(), DetectionActivity.class);
                startActivity(startIntent);
            }
        });

        //camButton = findViewById(R.id.imageButtonCamVideoRecord);
    }

    public void recordVideo( View v){
        Intent intent;

        intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult( intent, VIDEO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_REQUEST) {
            Uri uri;

            Toast toast;

            //video
            uri = data.getData();
            toast = Toast.makeText(this.getApplicationContext(), "Imagem carregada!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}