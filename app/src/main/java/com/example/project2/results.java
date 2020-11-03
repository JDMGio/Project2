package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class results extends AppCompatActivity implements View.OnClickListener {

    TextView display1;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);



        display1 = (TextView)findViewById(R.id.display);

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE);
        int q1score = sharedPrefs.getInt("Q1Score", 0);
        int q2score = sharedPrefs.getInt("Q2Score", 0);
        int q3score = sharedPrefs.getInt("Q3Score", 0);
        int q4score = sharedPrefs.getInt("Q4Score", 0);
        int q5score = sharedPrefs.getInt("Q5Score", 0);

        int total = q1score + q2score + q3score + q4score + q5score;

        display1.setText("Your total score is: " + total + " out of 5");

        btnRestart = findViewById(R.id.restart);
        btnRestart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this, quest1.class));

    }
}