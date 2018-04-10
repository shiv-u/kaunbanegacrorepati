package com.androidexample.kbc;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class eliminated extends AppCompatActivity {

    Button quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminated);
        String name = getIntent().getExtras().getString("name");
        MediaPlayer mediaPlayer = MediaPlayer.create(eliminated.this,R.raw.wrong);
        mediaPlayer.start();
        TextView textView = findViewById(R.id.textView);
        textView.setText("Sorry "+name+" you are ");
        quit=findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(eliminated.this);
                builder.setCancelable(true);
                builder.setTitle("Quit???");
                builder.setMessage("Do you really want to quit the game???");
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                          finish();

                          moveTaskToBack(true);
                        System.exit(0);




                    }
                });
                    builder.show();
            }
        });



    }

//
//    @Override
//    protected void onDestroy() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Process.killProcess(Process.myPid());
//
//            }
//        },SPLASH_TIME_OUT);
//        super.onDestroy();
//    }
    public void play_again(View view)
    {
        Intent intent = new Intent(this,Game.class);
        startActivity(intent);
    }
}
