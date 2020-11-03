package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.RadioGroup;

public class quest1 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg1;
    int rg1id;
    Button btnSubmitQ1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest1);



        btnSubmitQ1 = findViewById(R.id.submitq1);
        btnSubmitQ1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        rg1 = (RadioGroup)findViewById(R.id.rgq1);
        rg1id = rg1.getCheckedRadioButtonId();

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(rg1id == R.id.q1c2)
            editor.putInt("Q1Score", 1);
        else
            editor.putInt("Q1Score", 0);
        editor.apply();

        startActivity(new Intent(this, quest2.class));

    }
}