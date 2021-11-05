package com.example.yoloapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEO_REQUEST = 999;

    private ImageButton camButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camButton = findViewById(R.id.imageButtonCamVideoRecord);
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