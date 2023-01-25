package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    Button general, ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        general = findViewById(R.id.btn_general);
        general.setOnClickListener(this);
        ms = findViewById(R.id.btn_ms);
        ms.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_general:
                startActivity(new Intent(this, GeneralQuestionsActivity.class));
                break;
            case R.id.btn_ms:
                startActivity(new Intent(this, MoviesAndSeriesQuestionsActivity.class));
                break;
        }
    }
}