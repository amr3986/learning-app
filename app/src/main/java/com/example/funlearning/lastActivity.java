package com.example.funlearning;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lastActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_last);
        Intent call = getIntent();
        starNo = call.getCharSequenceExtra("str");
        QNo = call.getIntExtra("pr",0);
        starV = (TextView)findViewById(R.id.texstar);
        img = (ImageView)findViewById(R.id.imgV);
        but = (Button)findViewById(R.id.but1);
        Qusno = (TextView)findViewById(R.id.texNu);
        countV = (TextView)findViewById(R.id.textime);
        progress = (ProgressBar)findViewById(R.id.Bar2);
        Qusno.setText("8/8");
        progress.setMax(8);
        progress.setProgress(QNo);
        img.setImageResource(R.drawable.stephen);
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
        String text = "Correct: He died on 14 March 2018 (aged 76)\n" +
                "Cambridge, England";

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