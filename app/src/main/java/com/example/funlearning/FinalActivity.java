package com.example.funlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    TextView starV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        starV = (TextView)findViewById(R.id.texstar);
        Intent str = getIntent();
        starV.setText(str.getCharSequenceExtra("stv"));

    }
}