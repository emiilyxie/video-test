package com.mlproject.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Intent intent = getIntent();
        String VIDEO_SAMPLE = intent.getStringExtra(MainActivity.LINK);
        String message = intent.getStringExtra(MainActivity.NAME);

        TextView textView = findViewById(R.id.detailText);
        textView.setText(message);
        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse(VIDEO_SAMPLE);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}
