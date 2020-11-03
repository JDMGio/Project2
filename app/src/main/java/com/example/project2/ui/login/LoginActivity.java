package com.example.project2.ui.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.example.project2.R;
import com.example.project2.registration;
import com.example.project2.gameRules;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {



    EditText et1,et2;
    TextView tvReg;
    Button login;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        et1 = (EditText) findViewById(R.id.email);
        et2 = (EditText) findViewById(R.id.password);
        tvReg = (TextView)findViewById(R.id.registerOpt);
        login = findViewById(R.id.login);

        login.setOnClickListener(this);
        tvReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login:

                String email=et1.getText().toString();
                String pw=et2.getText().toString();

                SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                String emailPref = sharedPrefs.getString("email", "");
                String pwPref = sharedPrefs.getString("password", "");

                if(email.length() == 0) {
                    et1.requestFocus();
                    et1.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(!(email.trim().matches(emailPattern))) {
                    et1.requestFocus();
                    et1.setError("NOT A VALID EMAIL");
                }
                else if(pw.length() == 0) {
                    et2.requestFocus();
                    et2.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(!emailPref.equals(email)){
                        et1.requestFocus();
                        et1.setError("THIS EMAIL IS NOT REGISTERED");
                    }
                    else if(!pwPref.equals(pw)){
                            et2.requestFocus();
                            et2.setError("THE PASSWORD ENTERED IS NOT CORRECT");
                        }

                        else {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(this, gameRules.class));
                        }



                    break;

            case R.id.registerOpt:

                startActivity(new Intent(this, registration.class));

                break;
        }
    }
}