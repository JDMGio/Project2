package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project2.ui.login.LoginActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.content.SharedPreferences;

public class registration extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2,etd,ete,etp;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        et1 = (EditText) findViewById(R.id.etFirstName);
        et2 = (EditText) findViewById(R.id.etLastName);
        etd = (EditText) findViewById(R.id.etDate);
        ete = (EditText) findViewById(R.id.etEmailAddress);
        etp = (EditText) findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.butregister);
        btnRegister.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.butregister:

                String fName=et1.getText().toString();
                String lName=et2.getText().toString();
                String Date=etd.getText().toString();
                String Email=ete.getText().toString();
                String pw=etp.getText().toString();
                if(fName.length() == 0) {
                et1.requestFocus();
                et1.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(fName.length() < 3) {
                    et1.requestFocus();
                    et1.setError("THIS FIELD MUST BE AT LEAST 3 CHARACTERS");
                }
                else if(fName.length() > 30) {
                    et1.requestFocus();
                    et1.setError("THIS FIELD MUST CANNOT BE MORE THAN 30 CHARACTERS");
                }
                else if(lName.length() == 0) {
                    et2.requestFocus();
                    et2.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(Date.length() == 0) {
                    etd.requestFocus();
                    etd.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(validateDate(Date) == false) {
                    etd.requestFocus();
                    etd.setError("DATE MUST BE ENTERED IN MM/DD/YYYY FORMAT");
                }
                else if(Email.length() == 0) {
                    ete.requestFocus();
                    ete.setError("THIS FIELD CANNOT BE EMPTY");
                }
                else if(!(Email.trim().matches(emailPattern))) {
                    ete.requestFocus();
                    ete.setError("NOT A VALID EMAIL");
                }

                else if(pw.length() == 0) {
                    etp.requestFocus();
                    etp.setError("THIS FIELD CANNOT BE EMPTY");
                }


                else {

                    SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("firstName",fName);
                    editor.putString("lastName",lName);
                    editor.putString("date",Date);
                    editor.putString("email",Email);
                    editor.putString("password",pw);
                    editor.apply();

                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, LoginActivity.class));
                }

                break;
        }
    }


    public static boolean validateDate(String strDate)
    {

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);

            try
            {
                Date date = sdf.parse(strDate);
            }

            catch (ParseException e)
            {
                return false;
            }

            return true;

    }

}