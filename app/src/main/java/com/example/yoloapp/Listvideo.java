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
        ImageView executar = (ImageView) findViewById(R.id.pessoa);
        ImageView executar2 = (ImageView) findViewById(R.id.cachorro);
        ImageView executar3 = (ImageView) findViewById(R.id.passaro);
        ImageView executar4 = (ImageView) findViewById(R.id.praia);

        executar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startIntent.putExtra("itemSelecionado", 1);

                startActivity(startIntent);
            }

        });

        executar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startIntent.putExtra("itemSelecionado", 2);
                startActivity(startIntent);
            }

        });
        executar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startIntent.putExtra("itemSelecionado", 3);
                startActivity(startIntent);
            }

        });
        executar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela principal
                Intent startIntent = new Intent(getApplicationContext(), PlayActivity.class);
                startIntent.putExtra("itemSelecionado", 4);
                startActivity(startIntent);
            }

        });

    }

}