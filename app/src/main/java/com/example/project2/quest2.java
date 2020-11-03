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

public class quest2 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg2;
    int rg2id;
    Button btnSubmitQ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest2);



        btnSubmitQ2 = findViewById(R.id.submitq2);
        btnSubmitQ2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        rg2 = (RadioGroup)findViewById(R.id.rgq2);
        rg2id = rg2.getCheckedRadioButtonId();

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(rg2id == R.id.q2c3)
            editor.putInt("Q2Score", 1);
        else
            editor.putInt("Q2Score", 0);
        editor.apply();


        startActivity(new Intent(this, quest3.class));

    }
}