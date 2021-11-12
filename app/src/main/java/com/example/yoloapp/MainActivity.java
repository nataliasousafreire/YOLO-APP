package com.example.yoloapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEO_REQUEST = 999;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 888;

    private ImageButton camButton;
    private ImageButton uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camButton = findViewById(R.id.imageButtonCamVideoRecord);
        uploadButton = findViewById(R.id.imageViewUploadUndetectedVideo);

    }

    public void recordVideo( View v){
        Intent intent;

        intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult( intent, VIDEO_REQUEST);
    }

    public void openStorageFolder(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                +  File.separator + "myFolder" + File.separator);
        intent.setDataAndType(uri, "video/*");
        startActivityForResult(intent, REQUEST_TAKE_GALLERY_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            switch ( requestCode){
                case VIDEO_REQUEST:
                    Uri selectedVideo;
                    String selectedVideoPath;
                    Intent videoPlayer;

                    selectedVideo = data.getData();
                    selectedVideoPath = selectedVideo.getPath();
                    videoPlayer = new Intent(this, VideoActivity.class);
                    Log.d( "video-capturado", "source-path: "+selectedVideoPath);
                    videoPlayer.putExtra("VIDEO_PATH", selectedVideoPath);
                    startActivity(videoPlayer);
                break;
                case REQUEST_TAKE_GALLERY_VIDEO:

                    selectedVideo = data.getData();
                    selectedVideoPath = selectedVideo.getPath();
                    videoPlayer = new Intent(this, VideoActivity.class);
                    videoPlayer.putExtra("VIDEO_PATH", selectedVideoPath);
                    startActivity(videoPlayer);
                break;
            }
        }catch( Exception e){
            Log.e( "onActivityR", "exceptionThrown", e);
        }
    }
}