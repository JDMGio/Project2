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

public class quest4 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg4;
    int rg4id;
    Button btnSubmitQ4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest4);



        btnSubmitQ4 = findViewById(R.id.submitq4);
        btnSubmitQ4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        rg4 = (RadioGroup)findViewById(R.id.rgq4);
        rg4id = rg4.getCheckedRadioButtonId();

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(rg4id == R.id.q4c1)
            editor.putInt("Q4Score", 1);
        else
            editor.putInt("Q4Score", 0);
        editor.apply();

        startActivity(new Intent(this, quest5.class));

    }
}