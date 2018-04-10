package com.androidexample.kbc;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    int questionno = 0, totalquestions = 0, chances = 1,next=1000;
    double SPLASH_TIME_OUT=0.999;

    boolean quizover = false;
    TextView questiontext;
    TextView question;
    Button button1 ;
    Button button2 ;
    Button button3 ;
    Button button4;
    ArrayList<Button> button = new ArrayList<>();
    MediaPlayer mediaPlayer;
    FloatingActionButton fifty;
    FloatingActionButton doubledip;
    String[] questions = {"Who is the only Indian film actor who has won national film award for both acting and playback singing??? ",
            "Who has been regarded as Father of Indian IT sector by Time's magazine???",
            "Who is known as 'The Wall' in the game of Cricket???",
            "Whose birthday is celebrated as 'Engineers Day' all over India???",
            "Which city is regarded as 'Silicon Valley of India' ???",
            "Which Indian Philosopher's statue was unveiled on the banks of river Thames in London???",
            "Which Indian language poets has won most number of  prestigious 'Jnanapitha Award'???",
            "Who is the youngest person to win all the world titles in English billiards???",
            "Who was the director of Indian Tv series Malgudi Days which was based on the works of R.K Narayan???",
            "Who is the creator of iconic cartoon character known as 'The Common Man'???"};
    String[][] options = {{"Dr.Rajkumar", "Rajanikanth", "Mohanlal", "Kamal Hasan"}
            , {"Azim Premji", "Vivek Paul", "Narayana Murthy", "Mukesh Ambani"},
            {"Sachin Tendulkar", "Rahul Dravid", "Sourav Ganguly", "VVS Laxman"},
            {"Sir.M.Visvesaraya", "Deerubai Ambani", "JRD Tata", "Aditya Birla"},
            {"Mumbai", "Kolkata", "Delhi", "Bengaluru"},
            {"Vivekananda", "Basavanna", "Gandhi", "Chanakya"},
            {"Kannada", "Tamil", "Hindi", "Bengali"},
            {"Geet Sethi", "Michael Ferreira", "Subhash Agarwal","Pankaj Advani"},
            {"Satyajit Ray","Shyam Benegal","Shankar Nag", "Mani Ratnam"},
            {"R.K.Narayan", "R.K.Laxman", "Mario Miranda", "Kutty"}};
    int[][] answers = {{1, 1}, {2, 3}, {3, 2}, {4, 1}, {5, 4}, {6, 2}, {7, 1}, {8, 4}, {9, 3}, {10, 2}};

    boolean lifeline1 = true;
    boolean lifeline2 = true;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("game","error");
        questionno=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        questiontext = findViewById(R.id.question_no);
        question = findViewById(R.id.question);
        totalquestions = questions.length;
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        fifty=findViewById(R.id.fifty);
        doubledip=findViewById(R.id.doubledip);
        button.add(button1);
        button.add(button2);
        button.add(button3);
        button.add(button4);
         mediaPlayer = MediaPlayer.create(Game.this,R.raw.game);
         mediaPlayer.setLooping(true);
         mediaPlayer.start();
         name = getIntent().getExtras().getString("name");
         play();



    }

    public void play() {

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {

                for(int i=0;i<4;i++)
                    button.get(i).setBackgroundResource(R.drawable.button);


            }
        }, (long) SPLASH_TIME_OUT);

        if(questionno!=10) {
            questiontext.setText("Question-"+(questionno + 1));
            question.setText(questions[questionno]);
            button1.setText(options[questionno][0]);
            button2.setText(options[questionno][1]);
            button3.setText(options[questionno][2]);
            button4.setText(options[questionno][3]);

        }
        if(questionno>=10)
        {
            Intent intent = new Intent(this,Won.class);
            intent.putExtra("name",name);
            mediaPlayer.stop();
            startActivity(intent);
        }
    }

    public void button1clicked(View view) {


            checkanswer(1, view);




    }

    public void button2clicked(View view) {

          //  able(2);
            checkanswer(2, view);

    }

    public void button3clicked(View view) {

            //able(3);
            checkanswer(3, view);


    }

    public void button4clicked(View view) {


            checkanswer(4, view);

    }

//    public void able(int id) {
//        int i = 0;
//        while (i != 4 && i != id - 1) {
//            button.get(i).setEnabled(false);
//            button.get(i).setClickable(false);
//            i++;
//        }
//    }



    public void fiftyclicked(View view) {

        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        if(lifeline1) {
            lifeline1=false;
            int q = questionno;
            int id = answers[q][1];
            int i = 0;
            int disabled = 0;
            fifty.setImageResource(R.drawable.redfifty);
            fifty.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            Snackbar.make(view, " 50-50  Activated", Snackbar.LENGTH_LONG).show();
            for(i=0;i<4;i++)
            {
                if(i!=id-1 && disabled!=2)
                {
                    button.get(i).setText(" ");
                    button.get(i).setClickable(false);
                    button.get(i).setEnabled(false);
                    disabled++;

                }
            }

        }
        else
        {


            mediaPlayer.start();
            Snackbar.make(view,"50-50 Already used",Snackbar.LENGTH_LONG).show();
        }

    }


    public void doubledipclicked(View view) {
        if (!lifeline2) {

            mediaPlayer.start();

            Snackbar.make(view, "DoubleDip already used", Snackbar.LENGTH_LONG).show();

        } else {
            for(int i=0;i<4;i++)
            {
                button.get(i).setEnabled(true);
                button.get(i).setClickable(true);
            }
            Snackbar.make(view,"Double Dip Activated",Snackbar.LENGTH_LONG).show();
            doubledip.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            lifeline2 = false;
            chances += 1;





        }


    }

    public void checkanswer(int id, View view) {
        int q = questionno;
        if (chances == 1) {

            if (id == answers[q][1]) {

                Snackbar.make(view, "Right Answer!!!", Snackbar.LENGTH_SHORT).show();
                button.get(id-1).setBackgroundResource(R.drawable.green);
                for(int i=0;i<4;i++)
                {

                    button.get(i).setEnabled(true);
                    button.get(i).setClickable(true);
                }
                questionno+=1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        play();


                    }
                },next);





            } else {
                Snackbar.make(view, "Wrong Answer!!!", Snackbar.LENGTH_SHORT).show();
                button.get(id - 1).setBackgroundResource(R.drawable.red);
                int realid = answers[q][1];
                for(int i=0;i<4;i++)
                {

                    button.get(i).setEnabled(true);
                    button.get(i).setClickable(true);
                }
                button.get(realid - 1).setBackgroundResource(R.drawable.green);
                Intent intent = new Intent(this, eliminated.class);
                intent.putExtra("name",name);
                mediaPlayer.stop();
                startActivity(intent);


            }
        }
        if (chances == 2) {

            chances-=1;

            if (id == answers[q][1]) {

                Snackbar.make(view, "Right Answer!!!", Snackbar.LENGTH_SHORT).show();
                button.get(id-1).setBackgroundResource(R.drawable.green);

                for(int i=0;i<4;i++)
                {

                    button.get(i).setEnabled(true);
                    button.get(i).setClickable(true);
                }
                questionno+=1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        play();


                    }
                },next);


            } else {
                Snackbar.make(view, "You have one more chance!!!", Snackbar.LENGTH_SHORT).show();
                button.get(id - 1).setBackgroundResource(R.drawable.red);
                button.get(id-1).setEnabled(false);
                button.get(id-1).setClickable(false);


            }
        }
    }


}