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

public class quest3 extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg3;
    int rg3id;
    Button btnSubmitQ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest3);



        btnSubmitQ3 = findViewById(R.id.submitq3);
        btnSubmitQ3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        rg3 = (RadioGroup)findViewById(R.id.rgq3);
        rg3id = rg3.getCheckedRadioButtonId();

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(rg3id == R.id.q3c4)
            editor.putInt("Q3Score", 1);
        else
            editor.putInt("Q3Score", 0);
        editor.apply();


        startActivity(new Intent(this, quest4.class));

    }
}