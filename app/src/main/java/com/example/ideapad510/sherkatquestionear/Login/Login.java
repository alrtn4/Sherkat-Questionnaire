package com.example.ideapad510.sherkatquestionear.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Question.Questions;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    private EditText editText;
//    private Database db;
    private LoginControler lc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        lc = new LoginControler(this);

//        sampleUserPass();
    }

    public void onLoginButtonClicked(View view){
        getEditTexts(view);
        if (lc.searchInDatabase(username,password)) {
            Intent i = new Intent(Login.this, Questions.class);
            startActivity(i);
            finish();
        }
    }

    private void getEditTexts(View view){
        editText = findViewById(R.id.username);
        username = editText.getText().toString();
        editText = findViewById(R.id.password);
        password = editText.getText().toString();
    }

    private void sampleUserPass(){
        lc.insertToDatabase("ali","123");
        lc.insertToDatabase("hamid","1234");
        lc.insertToDatabase("1","1");

    }
}
