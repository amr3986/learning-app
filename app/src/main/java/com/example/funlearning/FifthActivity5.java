package com.example.funlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class FifthActivity5 extends AppCompatActivity {
    int QNo;
    TextView starV;
    TextView Qusno;
    Button but;
    TextView countV;
    CharSequence starNo;
    ProgressBar progress;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth5);
        Intent call = getIntent();
        starNo = call.getCharSequenceExtra("str");
        QNo = call.getIntExtra("pr",0);
        starV = (TextView)findViewById(R.id.texstar);
        img = (ImageView)findViewById(R.id.imgV);
        but = (Button)findViewById(R.id.but3);
        Qusno = (TextView)findViewById(R.id.texNu);
        countV = (TextView)findViewById(R.id.textime);
        progress = (ProgressBar)findViewById(R.id.Bar2);
        Qusno.setText("5/5");
        progress.setMax(5);
        progress.setProgress(QNo);
        img.setImageResource(R.drawable.tit);
        starV.setText(starNo);


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
        String text = "Correct: The RMS Titanic sank in the early morning hours of 15 April 1912 in the North Atlantic Ocean";

        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
        starV.setText(starNo);

        final Intent Final = new Intent();
        Final.setClass(this,FinalActivity.class);
        Final.putExtra("stv",starNo);
        progress.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(Final);
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