package com.example.score;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Main3Activity extends AppCompatActivity {
    TextView textTime,textScore;
    ImageView imageView, imageView1, imageViev2, imageViev3, imageViev4, imageViev5, imageViev6, imageViev7, imageViev8;
    ImageView arrayImage[];
    int score;
    Handler handler;
    Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTime = findViewById(R.id.textTime);
        textScore = findViewById(R.id.textScore);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageViev2 = findViewById(R.id.imageView2);
        imageViev3 = findViewById(R.id.imageView3);
        imageViev4 = findViewById(R.id.imageView4);
        imageViev5 = findViewById(R.id.imageView5);
        imageViev6 = findViewById(R.id.imageView6);
        imageViev7 = findViewById(R.id.imageView7);
        imageViev8 = findViewById(R.id.imageView8);
        arrayImage = new ImageView[]{imageView, imageView1, imageViev2, imageViev3, imageViev4, imageViev5, imageViev6, imageViev6, imageViev7, imageViev8};
        hide();
        score = 0;

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textTime.setText("TİME: " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                builder.setMessage("Do you want to again play the game?");
                builder.setIcon(R.drawable.warning);
                builder.setTitle("Warning");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }.start();
    }
    public void tiklanma(View view) {
        score++;
        textScore.setText("SCORE: " + score);
    }
    public void hide() {
        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image : arrayImage) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                int i=random.nextInt(9);
                arrayImage[i].setVisibility(View.VISIBLE);

                Intent intent=getIntent();
                String medium=intent.getStringExtra("medium");
                handler.postDelayed(this,500);



            }
        };
        handler.post(runnable);
    }
}
