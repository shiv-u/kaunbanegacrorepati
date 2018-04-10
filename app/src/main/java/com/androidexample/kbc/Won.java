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

public class Won extends AppCompatActivity {

    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        String name = getIntent().getExtras().getString("name");
        TextView textView = findViewById(R.id.name);
        textView.setText(name);
        MediaPlayer song = MediaPlayer.create(Won.this,R.raw.win);
        song.start();
        quit=findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Won.this);
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
    public void play_again(View view)
    {
        Intent intent = new Intent(this,Game.class);
        startActivity(intent);
    }
}
