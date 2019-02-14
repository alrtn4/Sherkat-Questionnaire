package com.example.ideapad510.sherkatquestionear.Mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.Questions.Question;
import com.example.ideapad510.sherkatquestionear.R;


public class Mobile extends Activity {
    MobileController mobileController = new MobileController(this);
    Params params = Params.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile);
    }

    public void onRegisterClick(View view){
        EditText mobileNumber = findViewById(R.id.mobileNumber);
        String number = mobileNumber.getText().toString();
        mobileController.insertPhoneNumber(number);
        params.setPasokhgoo(number);

        Intent intent = new Intent(Mobile.this, Question.class);
        startActivity(intent);
    }
}
