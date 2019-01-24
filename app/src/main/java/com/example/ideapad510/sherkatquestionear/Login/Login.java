package com.example.ideapad510.sherkatquestionear.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Question.Questions;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    private EditText editText;
    private LoginDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = new LoginDatabase(this);

//        db.insertRow("ali","123");
//        db.insertRow("hamid","1234");
    }

    public void getEditTexts(View view){
        editText = findViewById(R.id.username);
        username = editText.getText().toString();
        editText = findViewById(R.id.password);
        password = editText.getText().toString();
    }

    public void onButtonClicked(View view){
        getEditTexts(view);
        System.out.println("input :"+username+ "  "+password);
        if (db.searchInDatabase(username,password)) {
            Intent i = new Intent(Login.this, Questions.class);
            startActivity(i);
            finish();
        }
    }

}
