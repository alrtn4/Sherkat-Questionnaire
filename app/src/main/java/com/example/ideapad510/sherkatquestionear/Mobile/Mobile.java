package com.example.ideapad510.sherkatquestionear.Mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.R;


public class Mobile extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile);
    }

    public void onRegisterClick(View view){
        EditText mobileNumber = findViewById(R.id.mobileNumber);
        String number = mobileNumber.getText().toString();
    }
}
