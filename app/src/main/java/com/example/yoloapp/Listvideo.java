package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        ImageView executar = (ImageView) findViewById(R.id.ImageExecutar);
        executar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(startIntent);
            }
        });

    }

}