package com.example.funlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int QNo = 0;
    TextView starV;
    TextView countV;
    TextView QusV;
    Button but;
    CharSequence starNo = "0";
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starV = (TextView)findViewById(R.id.texstar);
        countV = (TextView)findViewById(R.id.textime);
        but = (Button)findViewById(R.id.but2);
        QusV = (TextView)findViewById(R.id.texNu);
        progress = (ProgressBar)findViewById(R.id.Bar2);
        QusV.setText("1/5");
        progress.setMax(5);
        progress.setProgress(QNo);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                countV.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                countV.setText("0");
                incorrect(starV);
                start();

            }
        }.start();
    }

    public void incorrect(View view){
        int i = Integer.parseInt(starNo.toString());
        i-=1;
        starNo = String.valueOf(i);
        starV.setText(starNo);
    }

    public void correct(View view){
        but.setBackgroundColor(Color.rgb(0, 128, 43));
        progress.setProgress(++QNo);
        int i = Integer.parseInt(starNo.toString());
        i+=7;
        starNo = String.valueOf(i);
        String text = "Correct: Sir Isaac Newton was an English mathematician and mathematician and physicist who lived from 1642-1727.";

        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
        starV.setText(starNo);

        final Intent goSecond = new Intent();
        goSecond.setClass(this, SecondActivity2.class);
        goSecond.putExtra("star",starNo);
        goSecond.putExtra("pro",QNo);


        progress.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(goSecond);
            }

        }, 3000); // 5000ms delay

    }

    public void wrong(View view){
        String text = "sorry: wrong answer !!!";
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        int i = Integer.parseInt(starNo.toString());
        i-=1;
        starNo = String.valueOf(i);
        starV.setText(starNo);

    }
}