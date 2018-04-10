package com.androidexample.kbc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class IntroVideo extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into_video);

        String videopath="android.resource://com.androidexample.kbc/"+R.raw.intro;
        videoView= findViewById(R.id.video_view);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                next();
            }
        });
    }
    public void next()
    {
        Intent intent=new Intent(this,Instructions.class);
        startActivity(intent);
    }
    public void instructions(View view)
    {
        Intent intent=new Intent(this,Instructions.class);
        startActivity(intent);
    }
}
