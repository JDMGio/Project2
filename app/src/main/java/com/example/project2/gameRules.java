package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameRules extends AppCompatActivity implements View.OnClickListener {

    Button btnStartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamerules);



        btnStartQuiz = findViewById(R.id.butStartQuiz);
        btnStartQuiz.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(this, quest1.class));

    }
}