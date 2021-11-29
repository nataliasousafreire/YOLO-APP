package com.example.yoloapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO = 999;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 888;

    private ImageView uploadView;
    private ImageView camView;
    private ImageView samplesView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View
        this.uploadView = (ImageView) findViewById(R.id.imageViewUploadUndetectedVideo);
        this.uploadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                takeGalleryVideo( v);
            }
        });

        // Cam
        this.camView = (ImageView) findViewById(R.id.imageViewCamVideoRecord);
        this.camView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                recordVideo( v);
            }
        });
        //samples
        this.samplesView = (ImageView) findViewById(R.id.imageViewVideoSamples);
        this.samplesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mudar para tela certo
                Intent startIntent = new Intent(getApplicationContext(), Listvideo.class);
                startActivity(startIntent);
            }
        });
    }

    public void recordVideo( View v){
        Intent intent;

        intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra( MediaStore.EXTRA_DURATION_LIMIT, 10);
        startActivityForResult( intent, REQUEST_VIDEO);
    }

    public void takeGalleryVideo(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                +  File.separator + "myFolder" + File.separator);
        intent.setDataAndType(uri, "video/*");
        startActivityForResult(intent, REQUEST_TAKE_GALLERY_VIDEO);
    }

    public void openVideoPlayer( Uri selectedVideo){
        Intent videoPlayer;

        videoPlayer = new Intent(this, VideoActivity.class);
        videoPlayer.putExtra("VIDEO_URI", selectedVideo);
        startActivity(videoPlayer);
    }

    public void detect( Uri selectedVideo){
        Intent videoPlayer;

        videoPlayer = new Intent(this, DetectionActivity.class);
        videoPlayer.putExtra("VIDEO_URI", selectedVideo);
        startActivity(videoPlayer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if( resultCode == RESULT_OK){
                switch ( requestCode){
                    case REQUEST_VIDEO:
                        Uri selectedVideoUri;
                        String selectedVideoPath;

                        selectedVideoUri = data.getData();
                        selectedVideoPath = selectedVideoUri.getPath();
                        Log.d( "recordVideo", "source-path: "+selectedVideoPath);
                        detect( selectedVideoUri);
                        break;
                    case REQUEST_TAKE_GALLERY_VIDEO:

                        selectedVideoUri = data.getData();
                        selectedVideoPath = selectedVideoUri.getPath();
                        detect( selectedVideoUri);

                        break;
                }
            }

        }catch( Exception e){
            Log.e( "onActivityResult", "exceptionThrown", e);
        }
    }
}