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

        this.camButton = findViewById(R.id.imageButtonCamVideoRecord);
        this.uploadButton = findViewById(R.id.imageViewUploadUndetectedVideo);

    }

    public void recordVideo( View v){
        Intent intent;

        intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra( MediaStore.EXTRA_DURATION_LIMIT, 10);
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
            if( resultCode == RESULT_OK){
                switch ( requestCode){
                    case VIDEO_REQUEST:
                        Uri selectedVideo;
                        String selectedVideoPath;
                        Intent videoPlayer;
                        File file;

                        selectedVideo = data.getData();
                        selectedVideoPath = selectedVideo.getPath();
                        videoPlayer = new Intent(this, DetectionActivity.class);
                        Log.d( "recordVideo", "source-path: "+selectedVideoPath);
                        videoPlayer.putExtra("VIDEO_PATH", selectedVideoPath);
                        videoPlayer.putExtra("VIDEO_URI", selectedVideo);
                        startActivity(videoPlayer);

                        break;
                    case REQUEST_TAKE_GALLERY_VIDEO:

                        selectedVideo = data.getData();
                        selectedVideoPath = selectedVideo.getPath();
                        videoPlayer = new Intent(this, VideoActivity.class);
                        videoPlayer.putExtra("VIDEO_PATH", selectedVideoPath);
                        videoPlayer.putExtra("VIDEO_URI", selectedVideo);
                        startActivity(videoPlayer);

                        break;
                }
            }

        }catch( Exception e){
            Log.e( "onActivityResult", "exceptionThrown", e);
        }
    }
}