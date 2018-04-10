package com.androidexample.kbc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable (){

            @Override
            public void run() {
                intent = new Intent(MainActivity.this,IntroVideo.class);
                startActivity(intent);

                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
