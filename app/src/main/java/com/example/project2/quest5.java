package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.SharedPreferences;

public class quest5 extends AppCompatActivity implements View.OnClickListener {

    CheckBox box1,box2,box3,box4;
    Button btnSubmitQ5;
    boolean box1id,box2id,box3id,box4id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest5);



        btnSubmitQ5 = findViewById(R.id.submitq5);
        btnSubmitQ5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        box1 = (CheckBox)findViewById(R.id.cb1);
        box1id = box1.isChecked();
        box2 = (CheckBox)findViewById(R.id.cb2);
        box2id = box2.isChecked();
        box3 = (CheckBox)findViewById(R.id.cb3);
        box3id = box3.isChecked();
        box4 = (CheckBox)findViewById(R.id.cb4);
        box4id = box4.isChecked();

        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if(box1id == true &&
            box2id == false &&
            box3id == true &&
            box4id == true)
            editor.putInt("Q5Score", 1);
        else
            editor.putInt("Q5Score", 0);
        editor.apply();

        startActivity(new Intent(this, results.class));

    }
}