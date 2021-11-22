package com.example.yoloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Listvideo extends AppCompatActivity {
    //private ImageButton camButton;
    private ImageView mainview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listvideo);

        mainview = (ImageView) findViewById(R.id.ImageMain);
        mainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
    }
    public void abrirvideo(View view){
        startActivity(new Intent(this,PlayActivity.class));

    }

}