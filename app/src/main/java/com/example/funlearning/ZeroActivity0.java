package com.example.funlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class ZeroActivity0 extends AppCompatActivity {

    MediaPlayer gameMusic;
    public String in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero0);
        gameMusic = MediaPlayer.create(this, R.raw.clean);
        Switch music = (Switch)findViewById(R.id.muc);
        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gameMusic.start();

                if(!b)
                    gameMusic.pause();
            }
        });


    }
    public void start(View view){

        Intent main = new Intent();
        main.setClass(this,MainActivity.class);
        startActivity(main);
    }
}