package com.example.ideapad510.sherkatquestionear.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Database;
import com.example.ideapad510.sherkatquestionear.Question.Questions;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    private EditText editText;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = new Database(this);

//        db.insertRowLogin("ali","123");
//        db.insertRowLogin("hamid","1234");
        db.insertRowLogin("1","1");
        db.getRowsCountLogin();
//        db.getRowsCountLogin2();
    }

    public void getEditTexts(View view){
        editText = findViewById(R.id.username);
        username = editText.getText().toString();
        editText = findViewById(R.id.password);
        password = editText.getText().toString();
    }

    public void onButtonClicked(View view){
        getEditTexts(view);
        if (db.searchInDatabaseLogin(username,password)) {
            Intent i = new Intent(Login.this, Questions.class);
            startActivity(i);
            finish();
        }
    }

}
